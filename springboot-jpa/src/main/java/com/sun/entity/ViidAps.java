package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidAps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '设备ID'")
    private String apsId; // string(20)
    @Column(columnDefinition = "varchar(100) comment '设备名称'")
    private String name; // string(0..100)
    @Column(columnDefinition = "varchar(20) comment 'ip地址'")
    private String ipAddr; // string(0..30)
    @Column(columnDefinition = "varchar(20) comment 'ipv6地址'")
    private String ipv6Addr; // string(64)
    @Column(columnDefinition = "int(10) comment '端口号'")
    private Integer port; // int
    @Column(columnDefinition = "varchar(5) comment '在线状态'")
    private String isOnline; // string(1)
}
