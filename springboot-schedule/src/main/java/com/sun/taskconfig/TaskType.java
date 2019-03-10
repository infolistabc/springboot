package com.sun.taskconfig;
/**
 * 定义枚举类型，用来判断任务的类型
 * @author 钱善良 2018/09/18
 *
 */
public enum TaskType {
	/**
	 * trigger 表达式
	 */
    TRIGGER, 
    /**
     * cron 表达式
     */
    CRON, 
    /**
     * fixed_rate  表达式
     */
    FIXED_RATE, 
    /**
     * fixed_delay  表达式
     */
    FIXED_DELAY
}
