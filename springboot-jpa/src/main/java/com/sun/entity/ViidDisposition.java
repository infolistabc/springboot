package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidDisposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(33) comment '布控标识'")
    private String dispositionId; // string(33)
    @Column(columnDefinition = "varchar(100) comment '布控标题'")
    private String title; // string
    @Column(columnDefinition = "varchar(10) comment '布控类别，人、机动车、非机动车、'")
    private String dispositionCategory; // string
    @Column(columnDefinition = "varchar(50) comment '布控名称'")
    private String targetName; // string
    @Column(columnDefinition = "varchar(255) comment '布控对象图像'")
    private String targetImageUri; // string
    @Column(columnDefinition = "varchar(20) comment '布控优先级：取值范围为 1～3，1 表示最高'")
    private Integer priorityLevel; // int
    @Column(columnDefinition = "varchar(50) comment '申请人'")
    private String applicantName; // string(0..50)
    @Column(columnDefinition = "varchar(20) comment '申请人联系方式'")
    private String applicantInfo; // string
    @Column(columnDefinition = "varchar(100) comment '申请单位'")
    private String applicantOrg; // string(0..100)
    @Column(columnDefinition = "dateTime comment '开始时间'")
    private Date beginTime; // dateTime
    @Column(columnDefinition = "dateTime comment '结束时间'")
    private Date endTime; // dateTime
    @Column(columnDefinition = "dateTime comment '创建时间'")
    private Date creatTime; // dateTime
    @Column(columnDefinition = "int(20) comment '布控操作类型：0:布控；1：撤控'")
    private Integer operateType; // int
    @Column(columnDefinition = "varchar(5) comment '撤控状态：0：布控中 1：已撤控 2：布控到期 9：未布控;该字段只读'")
    private Integer dispositionStatus; // int
    @Column(columnDefinition = "varchar(100) comment '布控范围：1:卡口；2：区域布控，布控时必选'")
    private String dispositionRange; // string
    @Column(columnDefinition = "varchar(100) comment '布控卡口,卡口时使用；可带多个卡" +
            "口 ID，多个以”;”间隔'")
    private String tollgateList; // string
    @Column(columnDefinition = "varchar(20) comment '布控行政区代码'")
    private String dispositionArea; // string
    @Column(columnDefinition = "varchar(100) comment '告警信息接收地址'")
    private String receiveAddr; // string
    @Column(columnDefinition = "varchar(20) comment '告警信息接收手机号'")
    private String receiveMobile; // string
    @Column(columnDefinition = "varchar(100) comment '撤控原因'")
    private String reason; // string
    @Column(columnDefinition = "varchar(50) comment '撤控单位名称'")
    private String dispositionRemoveOrg; // string(0..100)
    @Column(columnDefinition = "varchar(20) comment '设备ID'")
    private String dispositionRemovePerson; // string
    @Column(columnDefinition = "dateTime comment '撤控时间'")
    private Date dispositionRemoveTime; // dateTime
    @Column(columnDefinition = "varchar(100) comment '撤控原因'")
    private String dispositionRemoveReason; // string
    @Column(columnDefinition = "varchar(100) comment '目标资源ID'")
    private String targetSourceId;
}
