package com.sun.tasktype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.taskconfig.ScheduleTaskConfig;


@Component
public class ScheduleBaseService {
    @Autowired
    private ScheduleTaskConfig config;

    /**
     * 新增任务
     * @param task 任务信息对象
     * @return
     */
    public String addTask(BaseTask task) {
        return config.addTask(task);
    }

    /**
     * 修改任务执行频率等
     * @param taskId 任务的Id
     * @param expression 任务执行周期
     * @return
     */
    public String changeTask(String taskId, String expression) {
        return config.changeTask(taskId, expression);
    }

    /**
     * 删除任务
     * @param taskId 任务Id
     * @return
     */
    public String removeTask(String taskId) {
        return config.cancelTask(taskId);
    }
}
