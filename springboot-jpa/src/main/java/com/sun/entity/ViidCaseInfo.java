package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidCaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(30) comment '案件标识'")
    private String caseId; // string(30)
    @Column(columnDefinition = "varchar(23) comment '案件关联标识'")
    private String caseLinkMark; // string(23)
    @Column(columnDefinition = "varchar(120) comment '案件名称'")
    private String caseName; // string(0..120)
    @Column(columnDefinition = "varchar(4000) comment '简要案情'")
    private String caseAbstract; // string(0..4000)
    @Column(columnDefinition = "varchar(20) comment '线索标识'")
    private String clueId; // string
    @Column(columnDefinition = "dateTime comment '事发时间上限'")
    private Date timeUpLimit; // dateTime
    @Column(columnDefinition = "dateTime comment '事发时间下限'")
    private Date timeLowLimit; // dateTime
    @Column(columnDefinition = "dateTime comment '创建时间'")
    private Date createTime; // dateTime
    @Column(columnDefinition = "varchar(6) comment '事发地点行政区划代码'")
    private String placeCode; // string(6)
    @Column(columnDefinition = "varchar(100) comment '事发地点区划内详细地址'")
    private String placeFullAddress; // string(100)
    @Column(columnDefinition = "int(11) comment '可疑人数量'")
    private Integer suspectNumber; // int
    @Column(columnDefinition = "varchar(10) comment '发现人名称'")
    private String witnessName; // string(0..50)
    @Column(columnDefinition = "varchar(30) comment '发现人证件类型'")
    private String witnessIdType; // string(3)
    @Column(columnDefinition = "varchar(30) comment '发现人标识符'")
    private String witnessId; // string(0..30)
    @Column(columnDefinition = "varchar(100) comment '发现人组机构代码'")
    private String witnessOrg; // string(0..100)
    @Column(columnDefinition = "varchar(10) comment '创建人名称'")
    private String creatorName; // string(0..50)
    @Column(columnDefinition = "varchar(5) comment '创建人证件类型'")
    private String creatorIdType; // string(3)
    @Column(columnDefinition = "varchar(30) comment '创建人id'")
    private String creatorId; // string(0..30)
    @Column(columnDefinition = "varchar(100) comment '创建人组织机构'")
    private String creatorOrg; // string(0..100)
    @Column(columnDefinition = "double(10,5) comment '经度'")
    private Double longitude; // double
    @Column(columnDefinition = "double(10,5)  comment '纬度'")
    private Double latitude; // double
    @Column(columnDefinition = "varchar(33) comment '布控标识'")
    private String eventIds; // string
    @Column(columnDefinition = "varchar(30) comment '机动车标识符'")
    private String motorVehicleIds; // string
    @Column(columnDefinition = "varchar(30) comment '非机动车标识符'")
    private String nonMotorVehicleIds; // string
    @Column(columnDefinition = "varchar(30) comment '人员标识符'")
    private String personIds; // string
    @Column(columnDefinition = "varchar(30) comment '人脸标识符'")
    private String faceIds; // string
    @Column(columnDefinition = "varchar(30) comment '物品标识符'")
    private String thingIds; // string
    @Column(columnDefinition = "varchar(30) comment '场景标识符'")
    private String sceneIds; // string
    @Column(columnDefinition = "varchar(30) comment '相关案件标识'")
    private String relateCaseIdList; // string
    @Column(columnDefinition = "varchar(30) comment '父案件标识'")
    private String parentCaseId; // string(30)
    @Column(columnDefinition = "int(11) comment '案件状态0:事件，1：已立案，2：已侦破，3：侦破待复核，4：已结案，5：结案待复核，6：并案待复核、7：撤案待复核，8：结案归档，9：并案归档，" +
            "10：撤案归档'")
    private Integer state; // int
}
