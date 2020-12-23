package com.sun.util;

import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 基于Redis位图的用户日活数据收集功能
 * <p>
 * 实现功能：
 * 1. 日用户的DAU数据
 * 2. 最近7天用户的DAU数据
 * 3. 最近一个月用户的DAU数据
 */
@Component
public class UserDau {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 用户登录记录
     * @param uid 用户ID
     * @param date 日期
     * @return 之前的签到状态
     */
    public boolean doLogin(LocalDate date,Long uid) {
        return redisTemplate.opsForValue().setBit(buildSignKey(date), uid, true);
    }

    /**
     * 统计用户日活数量
     *
     * @param date 日期
     * @return 当前日期的日活数量
     */
    public long getTodayCount(LocalDate date) {
        return (long)redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(buildSignKey(date).getBytes()));
    }

    /**
     * 统计最近7天的日活数据
     * @param date 当前日期
     * @return
     */
    public long getWeekCount(LocalDate date){
        long weekCount = 0;
        for (int i =0; i<=7;i++){
            LocalDate dateTemp = date.plusDays(-i);
            weekCount +=redisTemplate.execute((RedisCallback<Long>) con ->
                    con.bitCount(buildSignKey(dateTemp).getBytes()));
        }
        return weekCount;
    }
    /**
     * 返回签名的key
     *
     * @param date
     * @return
     */
    private static String buildSignKey(LocalDate date) {
        return String.format("u:online:%s", formatDate(date));
    }
    private static String formatDate(LocalDate date) {
        return formatDate(date, "yyyyMMdd");
    }
    private static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
