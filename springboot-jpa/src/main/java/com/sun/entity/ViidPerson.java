package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(30) comment '人员标识'")
    private String personId; // string(48)
    @Column(columnDefinition = "int(11) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(30) comment '来源标识'")
    private String sourceId; // string(41)
    @Column(columnDefinition = "varchar(30) comment '设备编码'")
    private String deviceId; // string
    @Column(columnDefinition = "int(11) comment '左上角 X 坐标'")
    private Integer leftTopX; // int
    @Column(columnDefinition = "int(11) comment '左上角 Y 坐标'")
    private Integer leftTopY; // int
    @Column(columnDefinition = "int(11) comment '右下角 X 坐标'")
    private Integer rightBtmX; // int
    @Column(columnDefinition = "int(11) comment '右下角  坐标'")
    private Integer rightBtmY; // int
    @Column(columnDefinition = "dateTime comment '位置标记时间'")
    private Date locationMarkTime; // dateTime
    @Column(columnDefinition = "dateTime comment '人员出现时间'")
    private Date personAppearTime; // dateTime
    @Column(columnDefinition = "dateTime comment '人员消失时间'")
    private Date personDisAppearTime; // dateTime
    @Column(columnDefinition = "varchar(10) comment '证件种类'")
    private String idType; // string(3)
    @Column(columnDefinition = "varchar(41) comment '证件号码'")
    private String idNumber; // string(0..30)
    @Column(columnDefinition = "varchar(50) comment '姓名'")
    private String name; // string(0..50)
    @Column(columnDefinition = "varchar(50) comment '曾用名'")
    private String usedName; // string(0..50)
    @Column(columnDefinition = "varchar(50) comment '绰号'")
    private String alias; // string(0..50)
    @Column(columnDefinition = "varchar(10) comment '性别'")
    private String genderCode; // string
    @Column(columnDefinition = "int(41) comment '年龄上限'")
    private Integer ageUpLimit; // int
    @Column(columnDefinition = "int(41) comment '年龄下限'")
    private Integer ageLowerLimit; // int
    @Column(columnDefinition = "varchar(10) comment '民族代码'")
    private String ethicCode; // string(2)
    @Column(columnDefinition = "varchar(10) comment '国籍代码'")
    private String nationalityCode; // string(3)
    @Column(columnDefinition = "varchar(10) comment '籍贯省市县代码'")
    private String nativeCityCode; // string(6)
    @Column(columnDefinition = "varchar(10) comment '居住地行政区划'")
    private String residenceAdminDivision; // string(6)
    @Column(columnDefinition = "varchar(10) comment '汉语口音代码'")
    private String chineseAccentCode; // String(6)
    @Column(columnDefinition = "varchar(100) comment '单位名称'")
    private String personOrg; // string(0..100)
    @Column(columnDefinition = "varchar(10) comment '职业类别代码'")
    private String jobCategory; // String(3)
    @Column(columnDefinition = "int(11) comment '同行人数'")
    private Integer accompanyNumber; // int
    @Column(columnDefinition = "int(11) comment '身高上限'")
    private Integer heightUpLimit; // int
    @Column(columnDefinition = "int(11) comment '身高下限'")
    private Integer heightLowerLimit; // int
    @Column(columnDefinition = "varchar(30) comment '体型'")
    private String bodyType; // string
    @Column(columnDefinition = "varchar(30) comment '肤色'")
    private String skinColor; // string
    @Column(columnDefinition = "varchar(30) comment '发型'")
    private String hairStyle; // string(2)
    @Column(columnDefinition = "varchar(30) comment '发色'")
    private String hairColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '姿态'")
    private String gesture; // string(2)
    @Column(columnDefinition = "varchar(5) comment '状态'")
    private String status; // string(2)
    @Column(columnDefinition = "varchar(10) comment '脸型'")
    private String faceStyle; // string(4)
    @Column(columnDefinition = "varchar(30) comment '脸部特征'")
    private String facialFeature; // string(40)
    @Column(columnDefinition = "varchar(30) comment '体貌特征'")
    private String physicalFeature; // string(200)
    @Column(columnDefinition = "varchar(30) comment '体表特征'")
    private String bodyFeature; // string(70)
    @Column(columnDefinition = "varchar(30) comment '习惯动作'")
    private String habitualMovement; // string(2)
    @Column(columnDefinition = "varchar(10) comment '行为'")
    private String behavior; // string(2)
    @Column(columnDefinition = "varchar(10) comment '行为描述'")
    private String behaviorDescription; // string
    @Column(columnDefinition = "varchar(30) comment '附属物'")
    private String appendAnt; // string(2)
    @Column(columnDefinition = "varchar(30) comment '附属物描述'")
    private String appendAntDescription; // string
    @Column(columnDefinition = "varchar(10) comment '伞颜色'")
    private String umbrellaColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '口罩颜色'")
    private String respiratorColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '帽子款式'")
    private String capStyle; // string(2)
    @Column(columnDefinition = "varchar(10) comment '帽子颜色'")
    private String capColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '眼镜款式'")
    private String glassStyle; // string(2)
    @Column(columnDefinition = "varchar(10) comment '眼镜颜色'")
    private String glassColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '围巾颜色'")
    private String scarfColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '包款式'")
    private String bagStyle; // string(2)
    @Column(columnDefinition = "varchar(41) comment '包款颜色'")
    private String bagColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '上衣款式'")
    private String coatStyle; // string(2)
    @Column(columnDefinition = "varchar(10) comment '上衣长度'")
    private String coatLength; // string
    @Column(columnDefinition = "varchar(10) comment '上衣颜色'")
    private String coatColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '裤子款式'")
    private String trousersStyle; // string(2)
    @Column(columnDefinition = "varchar(10) comment '裤子颜色'")
    private String trousersColor; // string(2)
    @Column(columnDefinition = "varchar(10) comment '裤子长度'")
    private String trousersLen; // string
    @Column(columnDefinition = "varchar(10) comment '鞋子款式'")
    private String shoesStyle; // string(2)
    @Column(columnDefinition = "varchar(10) comment '鞋子颜色'")
    private String shoesColor; // string(2)
    @Column(columnDefinition = "int(11) comment '是否驾驶员：0：否；1：是；2：不确定'")
    private Integer isDriver; // int
    @Column(columnDefinition = "int(41) comment '是否涉外人员：0：否；1：是；2：不确定'")
    private Integer isForeigner; // int
    @Column(columnDefinition = "varchar(10) comment '护照证件种类'")
    private String passportType; // string(2)
    @Column(columnDefinition = "varchar(30) comment '出入境人员分类代码'")
    private String immigrantTypeCode; // string(2)
    @Column(columnDefinition = "int(11) comment '是否涉恐人员：0：否；1：是；2：不确定'")
    private Integer isSuspectedTerrorist; // int
    @Column(columnDefinition = "varchar(41) comment '涉恐人员编号'")
    private String suspectedTerroristNumber; // string(19)
    @Column(columnDefinition = "int(11) comment '是否涉案人员：0：否；1：是；2：不确定'")
    private Integer isCriminalInvolved; // int
    @Column(columnDefinition = "varchar(10) comment '涉案人员专长代码'")
    private String criminalInvolvedSpecialisationCode; // string(2)
    @Column(columnDefinition = "varchar(41) comment '体表特殊标记'")
    private String bodySpecialMark; // string(7)
    @Column(columnDefinition = "varchar(30) comment '作案手段'")
    private String crimeMethod; // string(4)
    @Column(columnDefinition = "varchar(10) comment '作案特点代码'")
    private String crimeCharacterCode; // string(3)
    @Column(columnDefinition = "varchar(33) comment '在逃人员编号'")
    private String escapedCriminalNumber; // string(23)
    @Column(columnDefinition = "int(11) comment '是否在押人员：0：否；1：是；2：不确定，人工采集必填'")
    private Integer isDetainees; // int
    @Column(columnDefinition = "varchar(10) comment '看守所编码'")
    private String detentionHouseCode; // string(9)
    @Column(columnDefinition = "varchar(41) comment '在押人员身份'")
    private String detaineesIdentity; // string(2)
    @Column(columnDefinition = "varchar(41) comment '在押人员特殊身份'")
    private String detaineesSpecialIdentity; // DetaineesSpecialIdentityType
    @Column(columnDefinition = "varchar(41) comment '成员类型代码'")
    private String memberTypeCode; // string(2)
    @Column(columnDefinition = "int(11) comment '是否被害人：0：否；1：是；2：不确定'")
    private Integer isVictim; // int
    @Column(columnDefinition = "varchar(30) comment '被害人种类'")
    private String victimType; // string(3)
    @Column(columnDefinition = "varchar(41) comment '受伤害程度'")
    private String injuredDegree; // string
    @Column(columnDefinition = "varchar(41) comment '尸体状况代码'")
    private String corpseConditionCode; // string(2)
    @Column(columnDefinition = "int(11) comment '是否可疑人：0：否；1：是；2：不确定'")
    private Integer isSuspiciousPerson; // int
}
