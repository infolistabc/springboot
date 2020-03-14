package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidApe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '设备ID'")
    private String apeId; // string(20)
    @Column(columnDefinition = "varchar(100) comment '设备名称'")
    private String name; // string(0..100)
    @Column(columnDefinition = "varchar(30) comment '型号'")
    private String model; // string(0..100)
    @Column(columnDefinition = "varchar(30) comment 'IP地址'")
    private String ipAddr; // string(0..30)
    @Column(columnDefinition = "varchar(30) comment 'IPV6地址'")
    private String ipv6Addr; // string(64)
    @Column(columnDefinition = "int(10) comment '端口号'")
    private Integer port; // int
    @Column(columnDefinition = "double(10,5) comment '经度'")
    private Double longitude; // double
    @Column(columnDefinition = "double(10,5) comment '纬度'")
    private Double latitude; // double
    @Column(columnDefinition = "varchar(10) comment '安装地点行政区划代码'")
    private String placeCode; // string(6)
    @Column(columnDefinition = "varchar(100) comment '具体到摄像机位置或街道门牌号,由 (乡镇街道)+ (街路巷)+ (门楼牌号)+(门楼详细地址)构成'")
    private String place; // string
    @Column(columnDefinition = "varchar(12) comment '安装地点行政区划代码'")
    private String orgCode; // string(12)
    @Column(columnDefinition = "int(10) comment '车辆抓拍方向：0：拍车头；1：拍车尾，兼容无视频卡口信息设备'")
    private Integer capDirection; // int
    @Column(columnDefinition = "varchar(20) comment '监视方向'")
    private String monitorDirection; // HDirectionType
    @Column(columnDefinition = "varchar(50) comment '监视区域说明'")
    private String monitorAreaDesc; // string
    @Column(columnDefinition = "varchar(5) comment '在线状态'")
    private String isOnline; // string(1)
    @Column(columnDefinition = "varchar(32) comment '所属采集系统设备编号'")
    private String ownerApsId; // string(20)
    @Column(columnDefinition = "varchar(32) comment '用户账号'")
    private String userId; // string
    @Column(columnDefinition = "varchar(32) comment '密码'")
    private String password; // string(00..32)
    @Column(columnDefinition = "varchar(32) comment '播放路径访问路径'")
    private String rtspUrl;
}
