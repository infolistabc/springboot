package com.sun.taskconfig;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.tasktype.BaseTask;

/**
 * 缓存任务信息
 * @author 钱善良 2018/09/18
 *
 */
public abstract class TaskConfig {
    /**
     * 定义一个Map集合存储定时任务
     */
    private static final Map<String, BaseTask> tasks = new HashMap<>();

    /**
     * 获取全部任务列表
     * @return
     */
    public static List<BaseTask> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    /**
     * 把任务添加到map集合
     * @param baseTask
     */
    public static void addTask(BaseTask baseTask) {
        if (baseTask != null) {
            tasks.put(baseTask.getId(), baseTask);
        }
    }

    /**
     * 判断是否已经存在了定时任务
     * @param taskId
     * @return
     */
    static boolean containsTask(String taskId) {
        return tasks.containsKey(taskId);
    }

    /**
     * 获取单个任务信息
     * @param taskId
     * @return
     */
    static BaseTask getTask(String taskId) {
        return tasks.get(taskId);
    }
     /**
      * 根据任务Id删除任务
      * @param taskId
      * @return
      */
    static BaseTask removeTask(String taskId) {
        return tasks.remove(taskId);
    }
}
