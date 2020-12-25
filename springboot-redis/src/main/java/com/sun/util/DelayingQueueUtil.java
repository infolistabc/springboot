package com.sun.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.util.RedisUtil;
import com.sun.vo.Message;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: 延时队列功能类
 **/
@Component
public class DelayingQueueUtil {

    private static ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
    @Resource
    RedisUtil redisUtil;

    /**
     * 可以不同业务用不同的key
     */
    public static final String QUEUE_NAME = "message:queue";


    /**
     * 插入消息
     *
     * @param message
     * @return
     */
    @SneakyThrows
    public Boolean push(Message message) {
        Boolean addFlag = redisUtil.zAdd(QUEUE_NAME,mapper.writeValueAsString(message), message.getDelayTime());
        return addFlag;
    }

    /**
     * 移除消息
     *
     * @param message
     * @return
     */
    @SneakyThrows
    public Boolean remove(Message message) {
        Long remove = redisUtil.zRemove(QUEUE_NAME, mapper.writeValueAsString(message));
        return remove > 0 ? true : false;
    }


    /**
     * 拉取最新需要
     * 被消费的消息
     * rangeByScore 根据score范围获取 0-当前时间戳可以拉取当前时间及以前的需要被消费的消息
     *
     * @return
     */
    public List<Message> pull() {
        Set<Object> objects = redisUtil.zRangeByScore(QUEUE_NAME,0,System.currentTimeMillis());
        if (objects == null) {
            return null;
        }
        List<Message> msgList = objects.stream().map(msg -> {
            Message message = null;
            try {
                message = mapper.readValue(msg.toString(), Message.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return message;
        }).collect(Collectors.toList());
        return msgList;
    }


}
