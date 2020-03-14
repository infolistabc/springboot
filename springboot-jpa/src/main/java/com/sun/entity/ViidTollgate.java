package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidTollgate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '卡口ID'")
    private String tollgateId; // string(20)
    @Column(columnDefinition = "varchar(100) comment '卡口名称'")
    private String name; // string(0..100)
    @Column(columnDefinition = "double(10,5) comment '经度'")
    private Double longitude; // double
    @Column(columnDefinition = "double(10,5) comment '纬度'")
    private Double latitude; // double
    @Column(columnDefinition = "varchar(10) comment '安装地点行政区划代码'")
    private String placeCode; // string(6)
    @Column(columnDefinition = "varchar(100) comment '具体到位置或街道门牌号，由 (乡镇街道)+ (街路巷)+ (门楼牌号)+ (门楼详细地址)构成'")
    private String place; // string(6)
    @Column(columnDefinition = "varchar(10) comment '卡口状态：1 正常， 2 停用， 9 其他'")
    private String status; // string(1)
    @Column(columnDefinition = "varchar(5) comment '卡口类型'")
    private String tollgateCat; // string(2)
    @Column(columnDefinition = "int(10) comment '卡口用途：80 治安卡口，81 交通卡口，82 其他'")
    private Integer tollgateCat2; // int
    @Column(columnDefinition = "int(10) comment '卡口车道数'")
    private Integer laneNum; // int
    @Column(columnDefinition = "varchar(12) comment '管辖单位代码'")
    private String orgCode; // string(12)
    @Column(columnDefinition = "dateTime comment '卡口启用时间'")
    private Date activeTime; // dateTime
}
