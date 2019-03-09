package com.sun.tasktype;

import com.sun.taskconfig.TaskType;
/**
 *  使用corn表达式的是任务定时器的配置类
 * @author Administrator
 *
 */
public abstract class BaseCronTask extends BaseTask {
    private String expression;
   
    public BaseCronTask(TaskType taskType, String id) {
        super(taskType, id);
    }

    @Override
    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String getExpression() {
        return expression;
    }

    public final long interval() {
        return 0L;
    }

    public final long delay() {
        return 0L;
    }
}