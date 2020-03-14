package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidNonMotorVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(30) comment '车辆标识'")
    private String nonMotorVehicleId; // string(48)
    @Column(columnDefinition = "int(11) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(41) comment '来源标识'")
    private String sourceId; // string(41)
    @Column(columnDefinition = "varchar(30) comment '设备ID'")
    private String deviceId; // string
    @Column(columnDefinition = "int(11) comment '左上角 X 坐标'")
    private Integer leftTopX; // int
    @Column(columnDefinition = "int(11) comment '左上角 Y 坐标'")
    private Integer leftTopY; // int
    @Column(columnDefinition = "int(11) comment '右上角 X 坐标'")
    private Integer rightBtmX; // int
    @Column(columnDefinition = "int(11) comment '右上角 Y 坐标'")
    private Integer rightBtmY; // int
    @Column(columnDefinition = "dateTime comment '标记时间'")
    private Date markTime; // dateTime
    @Column(columnDefinition = "dateTime comment '出现时间'")
    private Date appearTime; // dateTime
    @Column(columnDefinition = "dateTime comment '消失时间'")
    private Date disappearTime; // dateTime
    @Column(columnDefinition = "varchar(10) comment '有无车牌'")
    private String hasPlate; // string
    @Column(columnDefinition = "varchar(10) comment '号牌种类'")
    private String plateClass; // string(2)
    @Column(columnDefinition = "varchar(10) comment '车牌颜色'")
    private String plateColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '车牌号'")
    private String plateNo; // string
    @Column(columnDefinition = "varchar(10) comment '挂车牌号'")
    private String plateNoAttach; // string
    @Column(columnDefinition = "varchar(100) comment '车牌描述，车牌框广告信息，包括车行名称，联系电话等'")
    private String plateDescribe; // string
    @Column(columnDefinition = "varchar(10) comment '是否套牌'")
    private String isDecked; // string
    @Column(columnDefinition = "varchar(10) comment '是否涂改'")
    private String isAltered; // string
    @Column(columnDefinition = "varchar(10) comment '是否遮挡'")
    private String isCovered; // string
    @Column(columnDefinition = "double(10,5) comment '行驶速度，单位千米每小时（km/h）'")
    private Double speed; // double
    @Column(columnDefinition = "varchar(30) comment '行驶状态代码'")
    private String drivingStatusCode; // string(4)
    @Column(columnDefinition = "varchar(30) comment '车辆使用性质代码'")
    private Integer usingPropertiesCode; // int
    @Column(columnDefinition = "varchar(20) comment '车辆品牌'")
    private String vehicleBrand; // string
    @Column(columnDefinition = "varchar(30) comment '车辆款型，被标注车辆的款式型号描述'")
    private String vehicleType; // string
    @Column(columnDefinition = "varchar(30) comment '车辆长度'")
    private Integer vehicleLength; // int
    @Column(columnDefinition = "int(10) comment '车辆宽度'")
    private Integer vehicleWidth; // int
    @Column(columnDefinition = "int(10) comment '车辆高度'")
    private Integer vehicleHeight; // int
    @Column(columnDefinition = "int(10) comment '车身颜色'")
    private Integer vehicleColor; // int
    @Column(columnDefinition = "varchar(30) comment '车前盖'")
    private String vehicleHood; // string
    @Column(columnDefinition = "varchar(30) comment '车后盖'")
    private String vehicleTrunk; // string
    @Column(columnDefinition = "varchar(30) comment '车轮'")
    private String vehicleWheel; // string
    @Column(columnDefinition = "varchar(30) comment '车轮印花纹'")
    private String wheelPrintedPattern; // string
    @Column(columnDefinition = "varchar(30) comment '车窗'")
    private String vehicleWindow; // string
    @Column(columnDefinition = "varchar(30) comment '车顶'")
    private String vehicleRoof; // string
    @Column(columnDefinition = "varchar(30) comment '车门'")
    private String vehicleDoor; // string
    @Column(columnDefinition = "varchar(30) comment '车侧'")
    private String sideOfVehicle; // string
    @Column(columnDefinition = "varchar(30) comment '车厢'")
    private String carOfVehicle; // string
    @Column(columnDefinition = "varchar(30) comment '后视镜'")
    private String rearviewMirror; // string
    @Column(columnDefinition = "varchar(30) comment '底盘'")
    private String vehicleChassis; // string
    @Column(columnDefinition = "varchar(30) comment '遮挡'")
    private String vehicleShielding; // string
    @Column(columnDefinition = "int(10) comment '贴膜颜色:0：深色，1：浅色，2：无'")
    private Integer filmColor; // int
    @Column(columnDefinition = "int(10) comment '改装标志:0：未改装，1：改装'")
    private Integer isModified; // int
}
