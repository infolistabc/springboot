package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidSystemTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '服务器ID'")
    private String viidServerId; // string(20)
    @Column(columnDefinition = "dateTime comment '日期模式'")
    private Date timeMode; // dateTime
    @Column(columnDefinition = "varchar(20) comment '时区'")
    private String timeZone; // string
}
