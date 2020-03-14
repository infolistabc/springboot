package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "int comment '端点X坐标'")
    private Integer  PointX ; // int
    @Column(columnDefinition = "int comment '端点Y坐标'")
    private Integer  PointY ; // int
}
