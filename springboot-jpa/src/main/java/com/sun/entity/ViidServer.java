package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidServer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '设备ID'")
    private String viidServerId; // string(20)
    @Column(columnDefinition = "varchar(20) comment '名称'")
    private String serverName; // string(0..100)
    @Column(columnDefinition = "varchar(20) comment 'IP地址'")
    private String ipAddr; // string(0..30)
    @Column(columnDefinition = "varchar(20) comment 'IPV6地址'")
    private String ipv6Addr; // string(64)
    @Column(columnDefinition = "int(11) comment '端口号'")
    private Integer port; // int
    @Column(columnDefinition = "varchar(20) comment '上级服务器标识'")
    private String upServerId; // string(20)
    @Column(columnDefinition = "varchar(20) comment '下级服务器标识'")
    private String subServerId; // string(20)
    @Column(columnDefinition = "varchar(5) comment '在线状态'")
    private String isOnline; // string(1)
    @Column(columnDefinition = "dateTime comment '在线时间'")
    private Date lastOnlineTime; // dateTime
}
