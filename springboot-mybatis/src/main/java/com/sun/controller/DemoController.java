package com.sun.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.entity.Demo;
import com.sun.service.IDemoService;

/**
 * @author wilson
 */
@RestController
public class DemoController {
	
	@Resource
	private IDemoService iDemoService;
	@RequestMapping("/test")
	public void add() {
		
		List<Demo> list = new ArrayList<>();
		
		Demo demo1 = new Demo();
		demo1.setId(1L);
		demo1.setDid(1L);
		demo1.setName("wilson");
		
		list.add(demo1);
		Demo demo2 = new Demo();
		demo2.setId(2L);
		demo2.setDid(2L);
		demo2.setName("aaaa");
		
		list.add(demo2);
		List<Long> a = list.stream().map(Demo::getId).collect(Collectors.toList());
		System.out.println(list);
		iDemoService.batchInsert(list);
	}
}
