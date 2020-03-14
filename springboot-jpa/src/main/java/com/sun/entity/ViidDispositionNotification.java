package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidDispositionNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(33) comment '告警标识'")
    private String notificationId; // string(33)
    @Column(columnDefinition = "varchar(33) comment '布控标识'")
    private String dispositionId; // string(33)
    @Column(columnDefinition = "varchar(20) comment '标题'")
    private String title; // string
    @Column(columnDefinition = "dateTime comment '触发时间'")
    private Date triggerTime; // dateTime
    @Column(columnDefinition = "varchar(48) comment '自动采集过车或过人记录ID'")
    private String cntObjectId; // string(48)
    @Column(columnDefinition = "bigInt(20) comment '人员ID'")
    private String personId; // string(48)
    @Column(columnDefinition = "bigInt(30) comment ''")
    private String motorVehicleId; // string(48)
}
