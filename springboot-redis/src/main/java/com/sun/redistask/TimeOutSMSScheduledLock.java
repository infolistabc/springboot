package com.sun.redistask;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeOutSMSScheduledLock {

    private Logger log = LoggerFactory.getLogger(TimeOutSMSScheduledLock.class);

	//这是定时任务
    @Scheduled(cron = "0 0/1 * * * ?")
    //参数自己根据情况设置
    @SchedulerLock(name = "sugExpiredSMS", lockAtMostFor = "100000", lockAtLeastFor = "5000")
    public void sendSMS(){
        log.info("任务执行开始");
        System.out.println("测试数据");
    }
}
