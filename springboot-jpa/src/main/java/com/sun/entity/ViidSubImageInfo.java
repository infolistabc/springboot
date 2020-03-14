package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidSubImageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(41) comment '图像标识'")
    private String imageId; // string(41)
    @Column(columnDefinition = "bigInt(20) comment '人脸ID'")
    private Long faceId;
    @Column(columnDefinition = "bigInt(20) comment '人员ID'")
    private Long personId;
    @Column(columnDefinition = "bigInt(20) comment '机动车ID'")
    private Long motorVehicleId;
    @Column(columnDefinition = "bigInt(20) comment '非机动车ID'")
    private Long nomMotorVehicleId;
    @Column(columnDefinition = "bigInt(20) comment '物品ID'")
    private Long thingId;
    @Column(columnDefinition = "bigInt(20) comment '场景ID'")
    private Long sceneId;

}
