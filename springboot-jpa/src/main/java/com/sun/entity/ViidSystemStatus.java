package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidSystemStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "bigInt(20) comment '服务器ID'")
    private String viidServerId; // string(20)
    @Column(columnDefinition = "bigInt(20) comment '在线状态'")
    private String isOnline; // string(1)
    @Column(columnDefinition = "dateTime comment '创建时间'")
    private Date createTime; // dateTime
}
