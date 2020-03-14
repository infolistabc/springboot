package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidBehaviorAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "int(11) comment '报警事件级别：行为分析产生的报警事件级别：0：提示；1：普通警告；2：严重警告； 其余数值保留。'")
    private Integer eventLevel; // int
    @Column(columnDefinition = "dateTime comment '行为开始的绝对时间'")
    private Date behaviorBeginTime; // dateTime
    @Column(columnDefinition = "dateTime comment '行为开始的相对时间'")
    private Date behaviorBeginTimeRlt; // dateTime
    @Column(columnDefinition = "int(11) comment '行为开始相对帧号'")
    private Integer behaviorBeginFrameNoRlt; // int
    @Column(columnDefinition = "dateTime comment '行为结束的绝对时间'")
    private Date behaviorEndTime; // dateTime
    @Column(columnDefinition = "dateTime comment '行为结束的相对时间'")
    private Date behaviorEndTimeRlt; // dateTime
    @Column(columnDefinition = "int(11) comment '行为结束相对帧号'")
    private Integer behaviorEndFrameNoRlt; // int
}
