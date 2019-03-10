package com.sun.taskservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.taskconfig.ScheduleTaskConfig;
import com.sun.tasktype.BaseTask;

/**
 * 调用配置类的增加任务，更新任务，删除任务的相关方法进行对任务的基本操作
 * 
 * @author wilson
 *
 */
@Component
public class ScheduleBaseService {
	@Autowired
	private ScheduleTaskConfig config;

	/**
	 * 新增任务
	 * 
	 * @param task 任务信息对象
	 * @return  添加成功返回 success，失败返回failure，任务已存在返回TASK_EXISTS
	 */
	public String addTask(BaseTask task) {
		return config.addTask(task);
	}

	/**
	 * 根据任务的ID修改任务执行频率等
	 * 
	 * @param taskId     任务的Id
	 * @param expression 任务执行周期
	 * @return  修改成功返回success
	 */
	public String changeTask(String taskId, String expression) {
		return config.changeTask(taskId, expression);
	}

	/**
	 * 删除任务
	 * 
	 * @param taskId 任务Id
	 * @return
	 */
	public String removeTask(String taskId) {
		return config.cancelTask(taskId);
	}
}
