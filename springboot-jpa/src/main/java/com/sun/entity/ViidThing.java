package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidThing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(48) comment '物品标识'")
    private String thingId; // string(48)
    @Column(columnDefinition = "int(11) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(30) comment '来源图像标识'")
    private String sourceId; // string(41)
    @Column(columnDefinition = "varchar(30) comment '设备编码，自动采集必选'")
    private String deviceId; // string
    @Column(columnDefinition = "int(11) comment '左上角 X 坐标'")
    private Integer leftTopX; // int
    @Column(columnDefinition = "int(11) comment '左上角 Y 坐标'")
    private Integer leftTopY; // int
    @Column(columnDefinition = "int(11) comment '右下角 X 坐标'")
    private Integer rightBtmX; // int
    @Column(columnDefinition = "int(11) comment '右下角 Y 坐标'")
    private Integer rightBtmY; // int
    @Column(columnDefinition = "dateTime comment '位置标记时间'")
    private Date locationMarkTime; // dateTime
    @Column(columnDefinition = "dateTime comment '出现时间'")
    private Date appearTime; // dateTime
    @Column(columnDefinition = "dateTime comment '消失时间'")
    private Date disappearTime; // dateTime
    @Column(columnDefinition = "varchar(30) comment '物品名称'")
    private String name; // string
    @Column(columnDefinition = "varchar(30) comment '物品形状'")
    private String shape; // string
    @Column(columnDefinition = "varchar(10) comment '物品颜色'")
    private String color; // string(2)
    @Column(columnDefinition = "varchar(10) comment '物品大小'")
    private String size; // string
    @Column(columnDefinition = "varchar(10) comment '物品材质'")
    private String material; // string
    @Column(columnDefinition = "varchar(30) comment '物品特征'")
    private String characteristic; // string
    @Column(columnDefinition = "varchar(10) comment '物品性质'")
    private String propertiy; // string(2)
    @Column(columnDefinition = "varchar(30) comment '涉案物品类型'")
    private String involvedObjType; // string(5)
    @Column(columnDefinition = "varchar(10) comment '枪支弹药类别'")
    private String firearmsAmmunitionType; // string(2)
    @Column(columnDefinition = "varchar(10) comment '工具痕迹代码'")
    private String toolTraceType; // string(2)
    @Column(columnDefinition = "varchar(10) comment '物证类别'")
    private String evidenceType; // string(5)
    @Column(columnDefinition = "varchar(30) comment '案(事)件物证形态代码'")
    private String caseEvidenceType; // string(2)
    //private SubImageInfoList subImageList; // SubImageInfoList
}
