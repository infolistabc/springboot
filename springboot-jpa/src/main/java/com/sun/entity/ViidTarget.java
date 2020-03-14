package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "int(11) comment '运动目标X坐标'")
    private Integer posX; // int
    @Column(columnDefinition = "int(11) comment '运动目标坐标'")
    private Integer posY; // int
    @Column(columnDefinition = "int(11) comment '运动目标宽度'")
    private Integer width; // int
    @Column(columnDefinition = "int(11) comment '运动目标高度'")
    private Integer height; // int
    @Column(columnDefinition = "int(11) comment '运动目标状态'")
    private Integer status; // int
    @Column(columnDefinition = "int(11) comment '运动目标运动速度'")
    private Integer speedVal; // int
    @Column(columnDefinition = "int(11) comment '运动目标运动方向'")
    private Integer speedRad; // int
}
