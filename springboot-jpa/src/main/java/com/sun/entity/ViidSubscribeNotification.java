package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidSubscribeNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "bigInt(20) comment '通知标识'")
    private String notificationId; // string(33)
    @Column(columnDefinition = "bigInt(20) comment '订阅标识'")
    private String subscribeId; // string(33)
    @Column(columnDefinition = "bigInt(20) comment '标题'")
    private String title; // string
    @Column(columnDefinition = "bigInt(20) comment '触发时间'")
    private Date triggerTime; // dateTime
    @Column(columnDefinition = "bigInt(20) comment '订阅通知的详细信息(人、车、物、场景)标识集合'")
    private String infoIds; // string
    @Column(columnDefinition = "varchar(1000) comment '通知对象实体'")
    private String notificationBody;
//    private CaseList caseObjectList; // CaseList
//    private TollgateList tollgateObjectList; // TollgateList
//    private LaneList laneObjectList; // LaneList
//    private APEList deviceList; // APEList
//    private APEStatusList deviceStatusList; // APEStatusList
//    private APSList aPSObjectList; // APSList
//    private APSStatusList aPSStatusObjectList; // APSStatusList
//    private PersonList personObjectList; // PersonList
//    private MotorVehicleList motorVehicleObjectList; // MotorVehicleList
//    private NonMotorVehicleList nonMotorVehicleObjectList; // NonMotorVehicleList
//    private ThingList thingObjectList; // ThingList
//    private SceneList sceneObjectList; // SceneList
}
