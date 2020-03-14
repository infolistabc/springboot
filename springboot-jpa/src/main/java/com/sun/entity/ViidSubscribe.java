package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidSubscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '订阅标识'")
    private String subscribeId; // string(33)
    @Column(columnDefinition = "varchar(20) comment '标题'")
    private String title; // string
    @Column(columnDefinition = "varchar(20) comment '订阅类别'")
    private String  subscribeDetail; // string(2)
    @Column(columnDefinition = "varchar(20) comment '资源路径,资源路径 URI(卡口 ID、设备" +
            "ID、采集内容 ID、案件 ID、" +
            "目标视图库 ID、行政区编号" +
            "2/4/6 位等)" +
            "支持批量和单个订阅，订阅时" +
            "必选'")
    private String  resourceUri; // string
    @Column(columnDefinition = "varchar(20) comment '申请人'")
    private String applicantName; // string(0..50)
    @Column(columnDefinition = "varchar(20) comment '申请人Id'")
    private String applicantOrg; // string(0..100)
    @Column(columnDefinition = "varchar(20) comment '开始时间'")
    private Date beginTime; // dateTime
    @Column(columnDefinition = "varchar(20) comment '结束时间'")
    private Date endTime; // dateTime
    @Column(columnDefinition = "varchar(20) comment 'IP地址'")
    private String receiveAddr; // string
    @Column(columnDefinition = "varchar(20) comment '操作类型:0：订阅；1：取消订阅'")
    private Integer operateType; // int
    @Column(columnDefinition = "varchar(20) comment '订阅状态:0：订阅中" +
            "1：已取消订阅" +
            "2：订阅到期" +
            "9：未订阅" +
            "该字段只读'")
    private Integer subscribeStatus; // int
    @Column(columnDefinition = "varchar(20) comment '理由'")
    private String reason; // string
    @Column(columnDefinition = "varchar(20) comment '订阅取消单位'")
    private String subscribeCancelOrg; // string(0..100)
    @Column(columnDefinition = "varchar(20) comment '订阅取消人'")
    private String subscribeCancelPerson; // string
    @Column(columnDefinition = "varchar(20) comment '取消时间'")
    private Date cancelTime; // dateTime
    @Column(columnDefinition = "varchar(20) comment '取消理由'")
    private String cancelReason; // string
}
