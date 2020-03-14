package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidMotorVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(30) comment '车辆标识'")
    private String motorVehicleId; // string(48)
    @Column(columnDefinition = "int(10) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(30) comment '来源标识'")
    private String sourceId; // string(41)
    @Column(columnDefinition = "varchar(30) comment '关联卡口编号'")
    private String tollgateId; // string(20)
    @Column(columnDefinition = "varchar(30) comment '设备编码'")
    private String deviceId; // string
    @Column(columnDefinition = "varchar(30) comment '近景照片:卡口相机所拍照片，自动采集必选，图像访问路径，采用 URI 命名规则'")
    private String storageUrl1; // string
    @Column(columnDefinition = "varchar(30) comment '车牌照片'")
    private String storageUrl2; // string
    @Column(columnDefinition = "varchar(30) comment '远景照片'")
    private String storageUrl3; // string
    @Column(columnDefinition = "varchar(30) comment '合成图'")
    private String storageUrl4; // string
    @Column(columnDefinition = "varchar(30) comment '缩略图'")
    private String storageUrl5; // string
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
    @Column(columnDefinition = "int(11) comment '车道号:车辆行驶方向最左车道为 1，由左向右顺序编号'")
    private Integer laneNo; // int
    @Column(columnDefinition = "varchar(10) comment '有无车牌'")
    private String hasPlate; // string
    @Column(columnDefinition = "varchar(10) comment '号牌种类'")
    private String plateClass; // string(2)
    @Column(columnDefinition = "varchar(10) comment '车牌颜色:指号牌底色，取 ColorType 中部分值： 黑色，白色，黄色，蓝色，绿色'")
    private String plateColor; // string(2)
    @Column(columnDefinition = "varchar(30) comment '车牌号:各类机动车号牌编号车牌全部无法识别的以“无车牌”标识，部分未识别的每个字符以半角‘-’代替'")
    private String plateNo; // string(0..15)
    @Column(columnDefinition = "varchar(30) comment '挂车牌号：各类机动车挂车号牌编号'")
    private String plateNoAttach; // string(0..15)
    @Column(columnDefinition = "varchar(30) comment '车牌描述：车牌框广告信息，包括车行名称，联系电话等'")
    private String plateDescribe; // string
    @Column(columnDefinition = "varchar(5) comment '是否套牌'")
    private String isDecked; // string
    @Column(columnDefinition = "varchar(5) comment '是否涂改'")
    private String isAltered; // string
    @Column(columnDefinition = "varchar(5) comment '是否遮挡'")
    private String isCovered; // string
    @Column(columnDefinition = "varchar(10) comment '行驶速度：单位千米每小时（km/h）'")
    private Double speed; // double
    @Column(columnDefinition = "varchar(30) comment '行驶方向'")
    private String direction; // HDirectionType
    @Column(columnDefinition = "varchar(30) comment '行驶状态代码'")
    private String drivingStatusCode; // string(4)
    @Column(columnDefinition = "int(11) comment '车辆使用性质代码'")
    private Integer usingPropertiesCode; // int
    @Column(columnDefinition = "varchar(30) comment '车辆类型'")
    private String vehicleClass; // string(3)
    @Column(columnDefinition = "varchar(10) comment '车辆品牌'")
    private String vehicleBrand; // string(3)
    @Column(columnDefinition = "varchar(30) comment '车辆型号'")
    private String vehicleModel; // string(0..32)
    @Column(columnDefinition = "varchar(10) comment '车辆年款'")
    private String vehicleStyles; // string
    @Column(columnDefinition = "varchar(10) comment '车辆长度'")
    private Integer vehicleLength; // int
    @Column(columnDefinition = "varchar(10) comment '车辆宽度'")
    private Integer vehicleWidth; // int
    @Column(columnDefinition = "varchar(30) comment '车辆高度'")
    private Integer vehicleHeight; // int
    @Column(columnDefinition = "varchar(30) comment '车身颜色'")
    private String vehicleColor; // string(2)
    @Column(columnDefinition = "varchar(30) comment '颜色深浅'")
    private String vehicleColorDepth; // string
    @Column(columnDefinition = "varchar(64) comment '车前盖'")
    private String vehicleHood; // string
    @Column(columnDefinition = "varchar(64) comment '车后盖'")
    private String vehicleTrunk; // string
    @Column(columnDefinition = "varchar(64) comment '车轮'")
    private String vehicleWheel; // string
    @Column(columnDefinition = "varchar(64) comment '车轮印花纹'")
    private String wheelPrintedPattern; // string(2)
    @Column(columnDefinition = "varchar(64) comment '车窗'")
    private String vehicleWindow; // string
    @Column(columnDefinition = "varchar(64) comment '车顶'")
    private String vehicleRoof; // string
    @Column(columnDefinition = "varchar(64) comment '车门'")
    private String vehicleDoor; // string
    @Column(columnDefinition = "varchar(64) comment '车侧'")
    private String sideOfVehicle; // string
    @Column(columnDefinition = "varchar(64) comment '车厢'")
    private String carOfVehicle; // string
    @Column(columnDefinition = "varchar(64) comment '后视镜'")
    private String rearviewMirror; // string
    @Column(columnDefinition = "varchar(64) comment '底盘'")
    private String vehicleChassis; // string
    @Column(columnDefinition = "varchar(64) comment '遮挡'")
    private String vehicleShielding; // string
    @Column(columnDefinition = "varchar(30) comment '贴膜颜色'")
    private String filmColor; // string
    @Column(columnDefinition = "varchar(30) comment '改装标志'")
    private String isModified; // string
    @Column(columnDefinition = "varchar(30) comment '撞痕信息'")
    private String hitMarkInfo; // string
    @Column(columnDefinition = "varchar(30) comment '车身描述'")
    private String vehicleBodyDesc; // string
    @Column(columnDefinition = "varchar(30) comment '车前部物品，当有多个时可用英文半角逗号分隔'")
    private String vehicleFrontItem; // string(2)
    @Column(columnDefinition = "varchar(30) comment '车前部物品描述：对车前部物品数量、颜色、种类等信息的描述'")
    private String descOfFrontItem; // string
    @Column(columnDefinition = "varchar(30) comment '车后部物品，当有多个时可用英文半角逗号分隔'")
    private String vehicleRearItem; // string(2)
    @Column(columnDefinition = "varchar(30) comment '车后部物品描述：对车后部物品数量、颜色、种类等信息的描述'")
    private String descOfRearItem; // string
    @Column(columnDefinition = "varchar(30) comment '车内人数'")
    private Integer numOfPassenger; // int
    @Column(columnDefinition = "dateTime comment '经过时刻'")
    private Date passTime; // dateTime
    @Column(columnDefinition = "varchar(30) comment '车辆被标注时经过的道路名称'")
    private String nameOfPassedRoad; // string
    @Column(columnDefinition = "varchar(30) comment '是否可疑车'")
    private String isSuspicious; // string
    @Column(columnDefinition = "varchar(30) comment '遮阳板状态：0：收起；1：放下'")
    private Integer sunVisor; // int
    @Column(columnDefinition = "varchar(30) comment '安全带状态：0：未系；1：有系'")
    private Integer safetyBelt; // int
    @Column(columnDefinition = "varchar(30) comment '打电话状态：0：未打电话；1：打电话中'")
    private Integer calling; // int

}
