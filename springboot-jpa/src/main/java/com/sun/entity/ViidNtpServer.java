package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidNtpServer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "int(20) comment '时钟服务器ID'")
    private Integer ntpServerId; // int
    @Column(columnDefinition = "varchar(20) comment '服务器名称'")
    private String serverName; // string
    @Column(columnDefinition = "varchar(20) comment 'IP地址'")
    private String ipAddr; // string(0..30)
    @Column(columnDefinition = "varchar(20) comment 'ipv6地址'")
    private String ipv6Addr; // string(64)
    @Column(columnDefinition = "int(11) comment '端口号'")
    private Integer port; // int
}
