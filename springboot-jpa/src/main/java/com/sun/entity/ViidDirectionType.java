package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidDirectionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "int(20) comment '方向类型'")
    private Integer direction; // int
    @Column(columnDefinition = "int(20) comment '目标类型'")
    private Integer targetType; // int
}
