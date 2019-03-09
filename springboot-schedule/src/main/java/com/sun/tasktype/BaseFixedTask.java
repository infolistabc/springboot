package com.sun.tasktype;

import com.sun.taskconfig.TaskType;
/**
 * 使用固定频率表达式的是任务定时器的配置类
 * @author Administrator
 *
 */
public abstract class BaseFixedTask extends BaseTask {
    private final long interval;//使用固定频率的时间间隔
    private final long delay;

    public BaseFixedTask(String id, long interval, long delay) {
        super(delay <= 0L ? TaskType.FIXED_RATE : TaskType.FIXED_DELAY, id);
        this.interval = interval;
        this.delay = delay;
    }

    @Override
    public long interval() {
        return interval;
    }

    @Override
    public long delay() {
        return delay;
    }

    @Override
    public final String getExpression() {
        return null;
    }

    @Override
    public final void setExpression(String expression) {

    }
}
