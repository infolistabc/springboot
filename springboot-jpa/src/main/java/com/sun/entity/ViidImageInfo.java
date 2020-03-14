package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
@Table
public class ViidImageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(41) comment '图像标识'")
    private String imageId; // string(41)
    @Column(columnDefinition = "int(11) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(10) comment '图像来源'")
    private String imageSource; // string(2)
    @Column(columnDefinition = "varchar(41) comment '来源视频标识'")
    private String sourceVideoId; // string(41)
    @Column(columnDefinition = "varchar(41) comment '原始图像标识'")
    private String originImageId; // string(41)
    @Column(columnDefinition = "int(11) comment '事件分类'")
    private Integer eventSort; // int
    @Column(columnDefinition = "varchar(20) comment '设备编码'")
    private String deviceId; // string(20)
    @Column(columnDefinition = "varchar(50) comment '存储路径'")
    private String storagePath; // string
    @Column(columnDefinition = "varchar(41) comment '图像文件哈希值'")
    private String fileHash; // string
    @Column(columnDefinition = "varchar(41) comment '文件格式'")
    private String fileFormat; // string(6)
    @Column(columnDefinition = "dateTime comment '拍摄时间'")
    private Date shotTime; // dateTime
    @Column(columnDefinition = "varchar(30) comment '标题'")
    private String title; // string
    @Column(columnDefinition = "varchar(30) comment '副标题'")
    private String titleNote; // string
    @Column(columnDefinition = "varchar(41) comment '专项名'")
    private String specialName; // string
    @Column(columnDefinition = "varchar(200) comment '关键字'")
    private String keyword; // string(0..200)
    @Column(columnDefinition = "varchar(41) comment '内容描述'")
    private String contentDescription; // string
    @Column(columnDefinition = "varchar(30) comment '主题人物'")
    private String subjectCharacter; // string
    @Column(columnDefinition = "varchar(30) comment '拍摄地点行政区划代码'")
    private String shotPlaceCode; // string(6)
    @Column(columnDefinition = "varchar(41) comment '拍摄地点行政区地址'")
    private String shotPlaceFullAddress; // string(100)
    @Column(columnDefinition = "double(10,5) comment '经度'")
    private Double shotPlaceLongitude; // double
    @Column(columnDefinition = "double(10,5) comment '纬度'")
    private Double shotPlaceLatitude; // double
    @Column(columnDefinition = "double(10,5) comment '水平拍摄方向'")
    private Double horizontalShotDirection; // string
    @Column(columnDefinition = "double(10,5) comment '垂直拍摄方向'")
    private Double verticalShotDirection; // double
    @Column(columnDefinition = "varchar(30) comment '密级代码'")
    private String securityLevel; // string
    @Column(columnDefinition = "int(11) comment '宽度'")
    private Integer width; // int
    @Column(columnDefinition = "int(11) comment '高度'")
    private Integer height; // int
    @Column(columnDefinition = "varchar(30) comment '照相机制造商'")
    private String cameraManufacturer; // string(0..100)
    @Column(columnDefinition = "varchar(100) comment '照相机制造型号'")
    private String cameraVersion; // string(0..100)
    @Column(columnDefinition = "int(41) comment '光圈值'")
    private Integer apertureValue; // int
    @Column(columnDefinition = "int(41) comment 'ISO 感光值'")
    private Integer isoSensitivity; // int
    @Column(columnDefinition = "int(41) comment '焦距'")
    private Integer focalLength; // int
    @Column(columnDefinition = "varchar(30) comment '质量等级'")
    private String qualityGrade; // string
    @Column(columnDefinition = "varchar(41) comment '采集人名称'")
    private String collectorName; // string(0..50)
    @Column(columnDefinition = "varchar(41) comment '采集单位名称'")
    private String collectorOrg; // string(0..100)
    @Column(columnDefinition = "varchar(41) comment '采集单位证件类型'")
    private String collectorIdType; // string(3)
    @Column(columnDefinition = "varchar(41) comment '采集单位证件号码'")
    private String collectorId; // string(0..30)
    @Column(columnDefinition = "varchar(41) comment '入库人'")
    private String entryClerk; // string(0..50)
    @Column(columnDefinition = "varchar(41) comment '入库人单位'")
    private String entryClerkOrg; // string(0..100)
    @Column(columnDefinition = "varchar(41) comment '入库人证件类型'")
    private String entryClerkIdType; // string(3)
    @Column(columnDefinition = "varchar(41) comment '入库人证件号码'")
    private String entryClerkId; // string(0..30)
    @Column(columnDefinition = "dateTime comment '入库时间'")
    private Date entryTime; // dateTime
    @Column(columnDefinition = "varchar(30) comment '图像处理标志'")
    private String imgProcFlag; // string
    @Column(columnDefinition = "int(11) comment '文件大小'")
    private Integer fileSize; // int
    @Column(columnDefinition = "varchar(30) comment '标识产生该图像的任务ID，'")
    private String taskId;
    @Column(columnDefinition = "varchar(50) comment '图片类型'")
    private String type; // ImageType
    @Column(columnDefinition = "varchar(50) comment '特征数据厂家路径'")
    private String featureFilePath;
    @Column(columnDefinition = "varchar(50) comment '特征数据厂家类型，不同厂家根据不同的特征算法比对算法做以图搜索'")
    private String featureFileType;

}
