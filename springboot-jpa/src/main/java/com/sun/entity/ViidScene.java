package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidScene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '场景标识'")
    private String sceneId; // string(48)
    @Column(columnDefinition = "int(11) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(30) comment '来源标识'")
    private String sourceId; // string(41)
    @Column(columnDefinition = "varchar(20) comment '设备编码'")
    private String deviceId; // string
    @Column(columnDefinition = "dateTime comment '出现时间'")
    private Date beginTime; // dateTime
    @Column(columnDefinition = "varchar(20) comment '选择处所代码'")
    private String placeType; // string(4)
    @Column(columnDefinition = "varchar(10) comment '天气情况分类'")
    private String weatherType; // string(2)
    @Column(columnDefinition = "varchar(30) comment '场景描述'")
    private String sceneDescribe; // string
    @Column(columnDefinition = "varchar(20) comment '道路类型代码'")
    private String sceneType; // string(2)
    @Column(columnDefinition = "varchar(20) comment '道路线形代码'")
    private String roadAlignmentType; // string(2)
    @Column(columnDefinition = "int(11) comment '道路地形分类'")
    private Integer roadTerrainType; // int
    @Column(columnDefinition = "varchar(20) comment '道路路面类型代码'")
    private String roadSurfaceType; // string(1)
    @Column(columnDefinition = "varchar(20) comment '道路路面状况代码'")
    private String roadConditionType; // string(1)
    @Column(columnDefinition = "varchar(20) comment '道路路面类型代码'")
    private String roadJunctionSectionType; // string(2)
    @Column(columnDefinition = "varchar(20) comment '道路照明条件代码'")
    private String roadLightingType; // string(1)
    @Column(columnDefinition = "varchar(20) comment '现场图示'")
    private String illustration; // string(2)
    @Column(columnDefinition = "varchar(20) comment '现场风向'")
    private String windDirection; // string(2)
    @Column(columnDefinition = "varchar(20) comment '现场光线'")
    private String illumination; // string
    @Column(columnDefinition = "varchar(20) comment '现场条件'")
    private String fieldCondition; // string
    @Column(columnDefinition = "varchar(20) comment '现场温度，单位为摄氏度（℃）'")
    private Double temperature; // double
    @Column(columnDefinition = "varchar(20) comment '现场湿度'")
    private String humidity; // string
    @Column(columnDefinition = "varchar(20) comment '人群聚集程度'")
    private String populationDensity; // string
    @Column(columnDefinition = "varchar(20) comment '物品密度'")
    private String denseDegree; // string
    @Column(columnDefinition = "varchar(20) comment '场景重要程度，取值为 1～5，数值越大表示越重要'")
    private Integer importance; // int
}
