package com.sun.taskconfig;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.*;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.sun.tasktype.BaseTask;

import java.util.Date;
import java.util.List;
 /**
  * 定期任务配置器
  * @author 钱善良 2018/09/18
  *
  */
@Lazy(false)
@Configurable
@Component
@EnableScheduling
public class ScheduleTaskConfig implements SchedulingConfigurer {
    private Logger log = LoggerFactory.getLogger(ScheduleTaskConfig.class);
    private final static String TASK_NOT_EXISTS = "not exists";//任务不存在
    private final static String TASK_EXISTS = "exists";  //任务已存在
    private final static String FAILURE = "failure";   //添加任务失败
    private final static String SUCCESS = "success";   //添加任务成功
    
    private ScheduledTaskRegistrar scheduledTaskRegistrar;
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        this.scheduledTaskRegistrar = scheduledTaskRegistrar;
        initTask();
    }
    /**
     * 初始化已配置任务
     */
    private void initTask() {
        List<BaseTask> list = TaskConfig.getTasks();
        for(BaseTask task : list){
        	addTaskByTaskType(task);
        }
    }
    /**
     * 添加任务
     * @param task 添加任务
     * @return
     */
    public String addTask(BaseTask task) {
        if (scheduledTaskRegistrar == null || task == null) {
            return FAILURE;
        }
        if (TaskConfig.containsTask(task.getId())) {
            return TASK_EXISTS;
        }
        try {
        	addTaskByTaskType(task);//通过任务类型添加任务 
        	TaskConfig.addTask(task);//把任务添加到Map集合中，作为任务的缓存
            return SUCCESS;
        } catch (Exception e) {
            log.error("新增定时任务失败:" + task, e);
            throw e;
        }
    }   
    /**
     * 通过任务的时间周期类型添加任务，调用下面设置值的方法返回相对应的定时任务对象（ScheduledTask）
     * @param task 任务的基本信息
     */
    private void addTaskByTaskType(BaseTask task) {
        log.info("add task:" + task);
        switch (task.taskType) {
            case TRIGGER: task.setScheduledTask(addTriggerTask(task));
                break;
            case CRON: task.setScheduledTask(addCronTask(task, task.getExpression()));
                break;
            case FIXED_RATE: task.setScheduledTask(addFixedRateTask(task, task.interval()));
                break;
            case FIXED_DELAY: task.setScheduledTask(addFixedDelayTask(task, task.interval(), task.delay()));
                break;
            default:
        }
    }
 
    /**
     * 添加不可改变时间表的定时任务
     * @param task
     */
    private ScheduledTask addCronTask(Runnable task, String expression) {
        return scheduledTaskRegistrar.scheduleCronTask(new CronTask(task, expression));
    }
 
    /**
     * 添加可变时间task
     * @param task
     * @return
     */
    private ScheduledTask addTriggerTask(BaseTask task) {
        return scheduledTaskRegistrar.scheduleTriggerTask(new TriggerTask(task, triggerContext -> {
            CronTrigger trigger = new CronTrigger(task.getExpression());
            Date nextExec = trigger.nextExecutionTime(triggerContext);
            return nextExec;
        }));
    }
 
    /**
     * 设置固定频率的定时任务
     * @param task
     * @param interval
     */
    private ScheduledTask addFixedRateTask(Runnable task, long interval) {
        return scheduledTaskRegistrar.scheduleFixedRateTask(new IntervalTask(task, interval, 0L));
    }
 
    /**
     * 设置延迟以固定频率执行的定时任务
     * @param task
     * @param interval
     * @param delay
     */
    private ScheduledTask addFixedDelayTask(Runnable task, long interval, long delay) {
        return scheduledTaskRegistrar.scheduleFixedDelayTask(new IntervalTask(task, interval, delay));
    }
    /**
     * 改变任务执行频率
     * @param taskId
     * @param expression
     * @return
     */
    public String changeTask(String taskId, String expression) {
        BaseTask baseTask = TaskConfig.getTask(taskId); 
        if (baseTask == null || !TaskType.TRIGGER.equals(baseTask.taskType)  || expression == null) {
            return TASK_NOT_EXISTS;
        }
        log.info("change trigger expression:(id=" + taskId + ",expression=" + expression+")");
        baseTask.setExpression(expression);//修改周期
        return SUCCESS;
    }
 
    /**
     * 取消定时任务
     * @param taskId
     * @return
     */
    public String cancelTask(String taskId) {
        if (!TaskConfig.containsTask(taskId)) {
            return TASK_NOT_EXISTS;
        }
        try {
            log.info("cancel task:" + taskId);
            TaskConfig.removeTask(taskId).getScheduledTask().cancel();
        } catch (Exception e) {
            log.error("取消任务失败:" + taskId, e);
            throw e;
        }
        return SUCCESS;
    }
}

