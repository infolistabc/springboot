package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidVideoSliceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(41) comment '视频标识'")
    private String videoId; // string(41)
    @Column(columnDefinition = "int(10) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(10) comment '视频来源'")
    private String videoSource; // string(2)
    @Column(columnDefinition = "varchar(5) comment 'True=摘要视频，false=原始视频，缺少该字段或缺省为 false'")
    private String isAbstractVideo; // string
    @Column(columnDefinition = "varchar(41) comment '原始视频Id'")
    private String originVideoId; // string(41)
    @Column(columnDefinition = "varchar(41) comment '原始视频Url'")
    private String originVideoUrl; // string
    @Column(columnDefinition = "varchar(41) comment '事件分类，自动分析事件类型，设备采集必选'")
    private Integer eventSort; // int
    @Column(columnDefinition = "varchar(20) comment '设备编码'")
    private String deviceId; // string(20)
    @Column(columnDefinition = "varchar(41) comment '存储路径，视频文件的存储路径，采用 URI 命名规则'")
    private String storagePath; // string
    @Column(columnDefinition = "varchar(100) comment '视频缩略图文件的存储路径，采用 URI 命名规则'")
    private String thumbnailStoragePath; // string
    @Column(columnDefinition = "varchar(100) comment '视频文件哈希值，使用 MD5 算法'")
    private String fileHash; // string
    @Column(columnDefinition = "varchar(6) comment '视频文件格式'")
    private String fileFormat; // string(6)
    @Column(columnDefinition = "varchar(5) comment '视频编码格式'")
    private String codedFormat; // string(2)
    @Column(columnDefinition = "int(10) comment '音频标识:0:无音频，1:含音频'")
    private Integer audioFlag; // int
    @Column(columnDefinition = "varchar(100) comment '音频编码格式'")
    private String audioCodedFormat; // string(2)
    @Column(columnDefinition = "varchar(100) comment '视频标题'")
    private String title; // string
    @Column(columnDefinition = "varchar(100) comment '副标题'")
    private String titleNote; // string
    @Column(columnDefinition = "varchar(100) comment '视频资料所属的专项名称'")
    private String specialName; // string
    @Column(columnDefinition = "varchar(200) comment '关键字'")
    private String keyword; // string(0..200)
    @Column(columnDefinition = "varchar(200) comment '内容描述'")
    private String contentDescription; // string
    @Column(columnDefinition = "varchar(50) comment '主题人物,描述视频资料内出现的主要人物的中文姓名全称， 当有多个时用英文半角分号”;”分隔'")
    private String mainCharacter; // string
    @Column(columnDefinition = "varchar(10) comment '拍摄地点行政区划代码'")
    private String shotPlaceCode; // string(6)
    @Column(columnDefinition = "varchar(200) comment '拍摄地点详细地址'")
    private String shotPlaceFullAddress; // string(100)
    @Column(columnDefinition = "double(10,5) comment '经度'")
    private Double shotPlaceLongitude; // double
    @Column(columnDefinition = "double(10,5)  comment '纬度'")
    private Double shoPlaceLatitude; // double
    @Column(columnDefinition = "varchar(50) comment '水平拍摄方向'")
    private String horizontalShotDirection; // string
    @Column(columnDefinition = "varchar(50) comment '垂直拍摄方向'")
    private String verticalShotDirection; // string
    @Column(columnDefinition = "varchar(50) comment '密级代码'")
    private String securityLevel; // string
    @Column(columnDefinition = "double(10,5) comment '视频长度,单位为秒（s）'")
    private Double videoLen; // double
    @Column(columnDefinition = "dateTime comment '视频开始时间'")
    private Date beginTime; // dateTime
    @Column(columnDefinition = "dateTime comment '视频结束时间'")
    private Date endTime; // dateTime
    @Column(columnDefinition = "int(10) comment '时间差,视频标识时间减去实际北京时间的值，单位为秒（s）'")
    private Integer timeErr; // int
    @Column(columnDefinition = "int(200) comment '宽度'")
    private Integer width; // int
    @Column(columnDefinition = "int(200) comment '高度'")
    private Integer height; // int
    @Column(columnDefinition = "varchar(10) comment '质量等级'")
    private String qualityGrade; // string
    @Column(columnDefinition = "varchar(10) comment '采集人'")
    private String collectorName; // string(0..50)
    @Column(columnDefinition = "varchar(100) comment '采集人单位名称'")
    private String collectorOrg; // string(0..100)
    @Column(columnDefinition = "varchar(10) comment '采集人证件类型'")
    private String collectorIdType; // string(3)
    @Column(columnDefinition = "varchar(20) comment '采集人证件号码'")
    private String collectorId; // string(0..30)
    @Column(columnDefinition = "varchar(10) comment '入库人'")
    private String entryClerk; // string(0..50)
    @Column(columnDefinition = "varchar(100) comment '入库单位'")
    private String entryClerkOrg; // string(0..100)
    @Column(columnDefinition = "varchar(20) comment '入库人证件类型'")
    private String entryClerkIdType; // string(3)
    @Column(columnDefinition = "varchar(30) comment '入库人证件号码'")
    private String entryClerkId; // string(0..30)
    @Column(columnDefinition = "dateTime comment '入库时间'")
    private Date entryTime; // dateTime
    @Column(columnDefinition = "int(200) comment '视频处理标识:0：未处理，1：视频经过处理'")
    private Integer videoProcFlag; // int
    @Column(columnDefinition = "bigInt(20) comment '文件大小:单位 byte'")
    private Long fileSize; // long
    @Column(columnDefinition = "varchar(30) comment '标识产生该图像的任务ID'")
    private String taskId;
}
