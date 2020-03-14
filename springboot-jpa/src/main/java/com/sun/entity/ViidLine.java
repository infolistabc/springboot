package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "bigInt(20) comment '方向'")
    private Integer direction ; // int
    @Column(columnDefinition = "bigInt(20) comment '点位id'")
    private Long pointId;
    //private PointList pointObjectList ; // PointList
}
