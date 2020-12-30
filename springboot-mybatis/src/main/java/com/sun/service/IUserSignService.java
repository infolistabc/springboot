package com.sun.service;

import java.time.LocalDate;
import java.util.Map;

public interface IUserSignService {
    /**
     * 签到
     * @param uid 用户ID
     * @param date 日期
     * @return 成功返回true 否则返回false
     */
    boolean doSign(Long uid, LocalDate date);

    /**
     * 查询当月签到的次数
     * @param uid  用户ID
     * @param date 日期
     * @return 返回当月签到的数量
     */
    int getSignDays(Long uid,LocalDate date);

    /**
     * 查询当月某天是否签到
     * @param uid  用户ID
     * @param date 签到日期
     * @return 签到返回true, 否则false
     */
    boolean checkSign(Long uid,LocalDate date);

    /**
     * 获取当月首次签到日期
     * @param uid  用户ID
      * @param date 签到日期
     * @return 首次签到日期
     */
    LocalDate getFirstSignDate(Long uid,LocalDate date);

    /**
     * 查看当月签到详情
     * @param uid 用户ID
     * @param date 签到日期
     * @return 返回签到详情
     */
    Map<String, Boolean> getSignInfo(Long uid, LocalDate date);

    /**
     * 获取当月连续签到次数
     *
     * @param uid  用户ID
     * @param date 日期
     * @return 当月连续签到次数
     */
    long getContinuousSignCount(Long uid, LocalDate date);
}
