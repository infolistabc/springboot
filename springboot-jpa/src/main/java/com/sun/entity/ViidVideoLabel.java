package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidVideoLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(30) comment '视频标签ID'")
    private String videoLabelId; // string(48)
    @Column(columnDefinition = "int(11) comment '视频图像分析类型'")
    private Integer eventSort; // int
    @Column(columnDefinition = "varchar(12) comment '事件分析规则ID'")
    private String eventRuleId; // string
    @Column(columnDefinition = "varchar(12) comment '视频图像ID'")
    private String videoImageId; // string(41)
    @Column(columnDefinition = "varchar(12) comment '视频图像Url'")
    private String videoImageUrl; // string
    @Column(columnDefinition = "varchar(12) comment '在线摄像机ID'")
    private String cameraId; // string(20)
    @Column(columnDefinition = "varchar(12) comment '分析系统ID'")
    private String iVADeviceId; // string(20)
    @Column(columnDefinition = "dateTime comment '标签生成绝对时间'")
    private Date createTimeAbs; // dateTime
    @Column(columnDefinition = "dateTime comment '标签生成相对时间'")
    private Date createTimeRlt; // int
    @Column(columnDefinition = "varchar(12) comment '人员ID'")
    private String personId; // string
    @Column(columnDefinition = "varchar(12) comment '人脸ID'")
    private String faceId; // string
    @Column(columnDefinition = "varchar(12) comment '机动车ID'")
    private String motorVehicleId; // string
    @Column(columnDefinition = "varchar(12) comment '非机动车ID'")
    private String nonMotorVehicleId; // string
    @Column(columnDefinition = "varchar(12) comment '物品ID'")
    private String thingId; // string
    @Column(columnDefinition = "varchar(12) comment '场景ID'")
    private String sceneId; // string
    @Column(columnDefinition = "varchar(5) comment '目标颜色'")
    private String targetColor; // string(2)
    @Column(columnDefinition = "int(11) comment '目标主色个数'")
    private Integer colorCount; // int
    @Column(columnDefinition = "int(11) comment '运动目标总数'")
    private Integer moveObjectNum; // int
    private String imagePath; // stirng
    private String description; // string
    @Column(columnDefinition = "int(11) comment '目标总数'")
    private Integer targetNum; // int
    @Column(columnDefinition = "int(11) comment '人员总数'")
    private Integer personNum; // int
    @Column(columnDefinition = "int(11) comment '人脸数量'")
    private Integer faceNum; // int
    @Column(columnDefinition = "int(11) comment '车辆数量'")
    private Integer vehicleNum; // int
    @Column(columnDefinition = "int(11) comment '物品数量'")
    private Integer thingNum; // int
    @Column(columnDefinition = "int(11) comment '所有目标绝对密度'")
    private Integer targetDensityAbs; // int
    @Column(columnDefinition = "int(11) comment '人员目标绝对密度'")
    private Integer personDensityAbs; // int
    @Column(columnDefinition = "int(11) comment '人脸目标绝对密度'")
    private Integer faceDensityAbs; // int
    @Column(columnDefinition = "int(11) comment '车辆目标绝对密度'")
    private Integer vehicleDensityAbs; // int
    @Column(columnDefinition = "int(11) comment '物品目标绝对密度'")
    private Integer thingDensityAbs; // int
    @Column(columnDefinition = "int(11) comment '所有目标相对密度'")
    private Integer targetDensityRlt; // int
    @Column(columnDefinition = "int(11) comment '人员目标相对密度'")
    private Integer personDensityRlt; // int
    @Column(columnDefinition = "int(11) comment '人脸目标相对密度'")
    private Integer faceDensityRlt; // int
    @Column(columnDefinition = "int(11) comment '车辆目标相对密度'")
    private Integer vehicleDensityRlt; // int
    @Column(columnDefinition = "int(11) comment '物品目标相对密度'")
    private Integer thingDensityRlt; // int
    @Column(columnDefinition = "int(11) comment '所有目标流量'")
    private Integer totalTargetFlowRate; // int
    @Column(columnDefinition = "int(11) comment '人员目标流量'")
    private Integer personFlowRate; // int
    @Column(columnDefinition = "int(11) comment '车辆目标流量'")
    private Integer vehicleFlowRate; // int
    @Column(columnDefinition = "int(11) comment '流量方向'")
    private Integer flowDirection; // int
    @Column(columnDefinition = "bigInt(20) comment '主色区域对象ID'")
    private Long colorAreaId; // ColorAreaList
    @Column(columnDefinition = "bigInt(20) comment '运动目标对象ID'")
    private Long targetId; // TargetList
    @Column(columnDefinition = "bigInt(20) comment '行为分析对象ID'")
    private Long behaviorAnalysisId; // BehaviorAnalysis
}
