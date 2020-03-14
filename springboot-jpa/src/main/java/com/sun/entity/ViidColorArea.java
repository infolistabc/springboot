package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidColorArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "int(11) comment '主色区域X坐标'")
    private Integer areaPosX; // int
    @Column(columnDefinition = "int(11) comment '主色区域X坐标'")
    private Integer areaPosY; // int
    @Column(columnDefinition = "int(11) comment '主色区域宽度'")
    private Integer areaWidth; // int
    @Column(columnDefinition = "int(11) comment '主色区域高度'")
    private Integer areaHeight; // int
}
