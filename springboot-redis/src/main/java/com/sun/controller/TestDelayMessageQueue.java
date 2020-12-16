package com.sun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.service.DelayingQueueService;
import com.sun.vo.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

/**
 * @description: 消息提供者
 **/
@RestController
@RequestMapping("/message")
@Slf4j
public class TestDelayMessageQueue {

    @Resource
    DelayingQueueService delayingQueueService;

    private static ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();

    private static String USER_CHANNEL = "USER_CHANNEL";

    /**
     * 发送消息
     *
     * @param messageContent
     */
    @PostMapping("/sendMessage")
    public void sendMessage(String messageContent, long delay) {
        try {
            if (messageContent != null) {
                String seqId = UUID.randomUUID().toString();
                Message message = new Message();
                //时间戳默认为毫秒 延迟5s即为 5*1000
                long time = System.currentTimeMillis();
                LocalDateTime dateTime = Instant.ofEpochMilli(time).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
                //到期时间
                message.setDelayTime(time + (delay * 1000));
                message.setCreateTime(dateTime);
                message.setBody(messageContent);
                message.setId(seqId);
                message.setChannel(USER_CHANNEL);
                delayingQueueService.push(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 定时消费队列中的数据
     * zset会对score进行排序 让最早消费的数据位于最前
     * 拿最前的数据跟当前时间比较 时间到了则消费
     */
    @Scheduled(cron = "*/1 * * * * *")
    public void consumer() throws JsonProcessingException {
        List<Message> msgList = delayingQueueService.pull();
        if (null != msgList) {
            long current = System.currentTimeMillis();
            msgList.stream().forEach(msg -> {
                // 已超时的消息拿出来消费
                if (current >= msg.getDelayTime()) {
                    try {
                        log.info("消费消息：{}:消息创建时间：{},消费时间：{}", mapper.writeValueAsString(msg), msg.getCreateTime(), LocalDateTime.now());
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    //移除消息
                    delayingQueueService.remove(msg);
                }
            });
        }
    }
}