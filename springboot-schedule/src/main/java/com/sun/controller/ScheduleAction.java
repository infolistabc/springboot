package com.sun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.taskconfig.TaskType;
import com.sun.taskservice.TaskDto;
import com.sun.taskservice.TaskExecuteService;

/**
 * 提供外部接口修改定时器的信息
 * @author Administrator
 *
 */
@RestController
public class ScheduleAction {
	@Autowired
    private TaskExecuteService taskExecuteService;
	@RequestMapping("/add")
	public String add(){
		TaskDto task1 = new TaskDto();
    	task1.setBusinessId("任务一");
    	task1.setExpression("0/13 * * * * ?");
    	task1.setTaskId("12345");
    	task1.setTaskType(TaskType.CRON);
    	task1.setCallbackUrl("http://localhost:8089/say");
    	this.taskExecuteService.addTask(task1);
    	return "add success";
	}
	@RequestMapping("/delete")
	public String deleteTask(){
		TaskDto task1 = new TaskDto();
    	task1.setBusinessId("任务二");
    	task1.setExpression("0/13 * * * * ?");
    	task1.setTaskId("12345");
    	task1.setTaskType(TaskType.CRON);
		this.taskExecuteService.removeTask(task1);
		return "sucess delete";
	}
	@RequestMapping("/update")
	public String updataTask(){
		TaskDto task1 = new TaskDto();
    	task1.setExpression("0/15 * * * * ?");
    	task1.setTaskId("98765");
    	this.taskExecuteService.updateTask(task1);
    	return "update success";
	}
	@RequestMapping("/updateurl")
	public String updataTask1(){
		TaskDto task1 = new TaskDto();
    	task1.setTaskId("98765");
    	task1.setCallbackUrl("http://localhost:8089/say");
    	this.taskExecuteService.updateTask(task1);
    	return "update success";
	}
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("执行了任务一");
		return "hello word";
	}
	@RequestMapping("/say")
	public String sayHello(){
		System.out.println("执行了任务二");
		return "welcome to wilson";
	}
	
}
