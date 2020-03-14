package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidSubscribeNotificationRel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "bigInt(20) comment '通知标识'")
    private String notificationId; // string(33)
    @Column(columnDefinition = "bigInt(20) comment '订阅标识'")
    private String subscribeId; // string(33)
}
