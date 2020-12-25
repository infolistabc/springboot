package com.sun.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试定时任务锁")
@RestController
@RequestMapping("/scheduled")
public class TestScheduledLockController {
    private Logger log = LoggerFactory.getLogger(TestScheduledLockController.class);


    @RequestMapping("/testScheduled")
    @Scheduled(cron = "0 0/1 * * * ?")
    @SchedulerLock(name = "redis:scheduled:lock", lockAtMostFor = "100000", lockAtLeastFor = "5000")
    public void sendSMS(){
        log.info("任务执行开始");
        System.out.println("测试数据");
    }
}
