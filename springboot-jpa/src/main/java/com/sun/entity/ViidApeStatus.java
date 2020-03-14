package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidApeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '设备ID'")
    private String apeId;   // string(20)
    @Column(columnDefinition = "varchar(5) comment '在线状态'")
    private String isOnline; // string(1)
    @Column(columnDefinition = "dateTime comment '当前时间'")
    private Date createTime; // dateTime
}
