package com.sun.entity;
import javax.persistence.*;

import lombok.Data;
/**
 * @author wilson
 */
@Data
@Entity
public class ViidLane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(30) comment '卡口编号'")
    private String tollgateId;
    @Column(columnDefinition = "varchar(30) comment '车道 ID'")
    private String laneId;
    @Column(columnDefinition = "varchar(30) comment '车道编号,车辆行驶方向最左车道为 1，由左向右顺序编号'")
    private String laneNo;
    @Column(columnDefinition = "varchar(30) comment '名称'")
    private String name;
    @Column(columnDefinition = "varchar(30) comment '车道方向'")
    private String direction;
    @Column(columnDefinition = "varchar(30) comment '车道描述'")
    private String description;
    @Column(columnDefinition = "varchar(10) comment '限速'")
    private String maxSpeed;
    @Column(columnDefinition = "varchar(100) comment '车道出入城:1 进城、2 出城、3 非进出城、4 进出城混合'")
    private String cityPass;
    @Column(columnDefinition = "varchar(30) comment '设备 ID'")
    private String appId;
}
