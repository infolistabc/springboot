package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(41) comment '文件ID'")
    private String fileId; // string(41)
    @Column(columnDefinition = "int(10) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(10) comment '文件来源'")
    private String source; // string(2)
    @Column(columnDefinition = "varchar(255) comment '文件名称'")
    private String fileName; // string(0..256)
    @Column(columnDefinition = "varchar(100) comment '存储路径'")
    private String storagePath; // string
    @Column(columnDefinition = "varchar(20) comment '文件哈希值'")
    private String fileHash; // string
    @Column(columnDefinition = "varchar(20) comment '文件格式'")
    private String fileFormat; // string
    @Column(columnDefinition = "varchar(20) comment '标题'")
    private String title; // string
    @Column(columnDefinition = "varchar(20) comment '密级代码'")
    private String securityLevel; // string
    @Column(columnDefinition = "varchar(50) comment '入库人'")
    private String submitName; // string(0..50)
    @Column(columnDefinition = "varchar(100) comment '入库人单位'")
    private String submitOrg; // string
    @Column(columnDefinition = "dateTime comment '入库时间'")
    private Date entryTime; // dateTime
    @Column(columnDefinition = "int(20) comment '文件大小:单位 byte'")
    private Integer fileSize; // int
}
