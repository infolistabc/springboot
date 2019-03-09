package com.sun.taskservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.sun.taskconfig.TaskType;



/**
 * spring容器初始化完成后，开始初始化任务
 * 容器重启后，原来内存中的任务被销毁，需要再次从
 * 持久化工具中拉取加载如内存
 */
@Component
public class InitTask implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private TaskExecuteService taskExecuteService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	List <TaskDto> list = new ArrayList();   	   	
    	TaskDto task2 = new TaskDto();
    	task2.setBusinessId("任务二");
    	task2.setExpression("0/10 * * * * ?");
    	task2.setTaskId("98765");
    	task2.setTaskType(TaskType.TRIGGER);
    	task2.setCallbackUrl("http://localhost:8089/hello");
    	list.add(task2);
    	if (!CollectionUtils.isEmpty(list)) {
    		list.forEach(task -> taskExecuteService.addTask(task));
        }
    }
}
