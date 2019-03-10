package com.sun.taskservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sun.taskconfig.TaskType;
import com.sun.tasktype.BaseCronTask;
import com.sun.tasktype.BaseFixedTask;
import com.sun.tasktype.TaskDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 任务配置类
 * @author wilson
 *
 */
@Service
public class TaskExecuteService {
    @Autowired
    private ScheduleBaseService scheduleBaseService;
    @Autowired
    private CallbackExecuteService executeService;
    
    private static final Pattern FIXED = Pattern.compile("fixed=(\\d+)\\s*(,\\s*delay=(\\d+))?");
    /**
     * 新增任务
     * @param taskDto 添加任务对象信息必须包含如下字段信息：taskId，callbackUrl，expression，taskType）
     */
    public void addTask(TaskDto taskDto) {
        if (taskDto == null) {
            return;
        }
        String taskId = taskDto.getTaskId();
        //执行回调函数把对应的Id和URL存储在map集合中
        CallbackExecuteService.addOrUpdateTask(taskId, taskDto.getCallbackUrl());
        TaskType taskType = taskDto.getTaskType();        
        switch (taskType) {
            case FIXED_RATE:
            case FIXED_DELAY:
                long[] params = getFixedParameters(taskDto.getExpression());
                BaseFixedTask baseFixedTask = new BaseFixedTask(taskId,
                        params[0], params[1]) {
                    @Override
                    public void run() {
                        executeService.execute(this.getId());
                    }
                };
              //执行回调的线程
                scheduleBaseService.addTask(baseFixedTask);
                break;
            case CRON:
            case TRIGGER:
                BaseCronTask baseCronTask = new BaseCronTask(taskType == TaskType.CRON ?
                TaskType.CRON :
                TaskType.TRIGGER, taskId) {
                    @Override
                    public void run() {
                        executeService.execute(this.getId());
                    }
                };
                baseCronTask.setExpression(taskDto.getExpression());
              //执行回调的线程
                scheduleBaseService.addTask(baseCronTask);
                break;
           default:
        }
    }
    /**
     * 获取fixed类型的实际参数信息
     * @param expression
     * @return
     */
    private static long[] getFixedParameters(String expression) {
        Matcher matcher = FIXED.matcher(expression);
        if (matcher.find()) {
            long[] fixedParam = {0L, 0L};
            fixedParam[0] = Long.parseLong(matcher.group(1));
            String delay = matcher.group(3);
            if (delay != null) {
                fixedParam[1] = Long.parseLong(delay);
            }
            return fixedParam;
        }
        throw new IllegalArgumentException("invalid expression:" +expression);
    }
    /**
     * 根据任务的Id修改任务执行的周期和请求路径URL
     * @param taskDto 包含任务的Id，任务执行周期expression
     */
    public void updateTask(TaskDto taskDto) {
        if (!StringUtils.isEmpty(taskDto.getExpression())) {
            //修改表达式
           scheduleBaseService.changeTask(taskDto.getTaskId(), taskDto.getExpression());
           
        }
        if (!StringUtils.isEmpty(taskDto.getCallbackUrl())) {
            //修改回调地址
            CallbackExecuteService.addOrUpdateTask(taskDto.getTaskId(), taskDto.getCallbackUrl());
        }
    }

    /**
     * 根据删除任务，删除任务的时候需要清除所有的缓存在Map集合中的数据
     * @param taskDto
     */
    public void removeTask(TaskDto taskDto) {
    	//取消执行的任务
        scheduleBaseService.removeTask(taskDto.getTaskId());
        //取消回调任务，返回key对应的值
        CallbackExecuteService.removeTask(taskDto.getTaskId());
    }
}
