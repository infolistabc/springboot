package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidFace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(30) comment '人脸标识'")
    private String faceId; // string(48)
    @Column(columnDefinition = "int(30) comment '信息分类'")
    private Integer infoKind; // int
    @Column(columnDefinition = "varchar(30) comment '来源标识'")
    private String sourceId; // string(41)
    @Column(columnDefinition = "varchar(30) comment '设备编码'")
    private String deviceId; // string
    @Column(columnDefinition = "int(11) comment '左上角 X 坐标'")
    private Integer leftTopX; // int
    @Column(columnDefinition = "int(11) comment '左上角 Y 坐标'")
    private Integer leftTopY; // int
    @Column(columnDefinition = "int(11) comment '右上角 X 坐标'")
    private Integer rightBtmX; // int
    @Column(columnDefinition = "int(11) comment '右上角 Y 坐标'")
    private Integer rightBtmY; // int
    @Column(columnDefinition = "dateTime comment '标记时间'")
    private Date locationMarkTime; // dateTime
    @Column(columnDefinition = "dateTime comment '出现时间'")
    private Date faceAppearTime; // dateTime
    @Column(columnDefinition = "dateTime comment '消失时间'")
    private Date faceDisAppearTime; // dateTime
    @Column(columnDefinition = "varchar(10) comment '证件类型'")
    private String idType; // string(3)
    @Column(columnDefinition = "varchar(30) comment '证件号码'")
    private String idNumber; // string(0..30)
    @Column(columnDefinition = "varchar(30) comment '姓名'")
    private String name; // string(0..50)
    @Column(columnDefinition = "varchar(30) comment '曾用名'")
    private String usedName; // string(0..50)
    @Column(columnDefinition = "varchar(30) comment '绰号'")
    private String alias; // string(0..50)
    @Column(columnDefinition = "varchar(30) comment '性别'")
    private String genderCode; // string
    @Column(columnDefinition = "varchar(30) comment '年龄上限'")
    private Integer ageUpLimit; // int
    @Column(columnDefinition = "varchar(30) comment '年龄下限'")
    private Integer ageLowerLimit; // int
    @Column(columnDefinition = "varchar(30) comment '民族'")
    private String ethicCode; // string(2)
    @Column(columnDefinition = "varchar(30) comment '国籍代码'")
    private String nationalityCode; // string(3)
    @Column(columnDefinition = "varchar(30) comment '籍贯省市县'")
    private String nativeCityCode; // string(6)
    @Column(columnDefinition = "varchar(30) comment '居住地行政区划'")
    private String residenceAdminDivision; // string(6)
    @Column(columnDefinition = "varchar(10) comment '汉语口音代码'")
    private String chineseAccentCode; // String(6)
    @Column(columnDefinition = "varchar(10) comment '职业类别代码'")
    private String jobCategory; // String(3)
    @Column(columnDefinition = "varchar(30) comment '同行人脸数'")
    private Integer accompanyNumber; // int
    @Column(columnDefinition = "varchar(10) comment '肤色'")
    private String skinColor; // string
    @Column(columnDefinition = "varchar(30) comment '发型'")
    private String hairStyle; // string(2)
    @Column(columnDefinition = "varchar(30) comment '发色'")
    private String hairColor; // string(2)
    @Column(columnDefinition = "varchar(30) comment '脸型'")
    private String faceStyle; // string(4)
    @Column(columnDefinition = "varchar(30) comment '脸部特征'")
    private String facialFeature; // string(40)
    @Column(columnDefinition = "varchar(30) comment '体貌特征'")
    private String physicalFeature; // string(200)
    @Column(columnDefinition = "varchar(30) comment '口罩颜色'")
    private String respiratorColor; // string(2)
    @Column(columnDefinition = "varchar(30) comment '帽子款式'")
    private String capStyle; // string(2)
    @Column(columnDefinition = "varchar(30) comment '帽子颜色'")
    private String capColor; // string(2)
    @Column(columnDefinition = "varchar(30) comment '眼镜款式'")
    private String glassStyle; // string(2)
    @Column(columnDefinition = "varchar(30) comment '眼镜颜色'")
    private String glassColor; // string(2)
    @Column(columnDefinition = "int(11) comment '是否驾驶员:0：否；1：是；2：不确定'")
    private Integer isDriver; // int
    @Column(columnDefinition = "int(30) comment '是否涉外人员:0：否；1：是；2：不确定'")
    private Integer isForeigner; // int
    @Column(columnDefinition = "varchar(30) comment '护照证件种类'")
    private String passportType; // string(2)
    @Column(columnDefinition = "varchar(30) comment '出入境人员分类代码'")
    private String immigrantTypeCode; // string(2)
    @Column(columnDefinition = "varchar(30) comment '是否涉恐人员:0：否；1：是；2：不确定'")
    private Integer isSuspectedTerrorist; // int
    @Column(columnDefinition = "varchar(30) comment '涉恐人员编号'")
    private String suspectedTerroristNumber; // string(19)
    @Column(columnDefinition = "int(11) comment '是否涉案人员:0：否；1：是；2：不确定'")
    private Integer isCriminalInvolved; // int
    @Column(columnDefinition = "varchar(30) comment '涉案人员专长代码'")
    private String criminalInvolvedSpecialisationCode; // string(2)
    @Column(columnDefinition = "varchar(30) comment '体表特殊标记'")
    private String bodySpecialMark; // string(7)
    @Column(columnDefinition = "varchar(30) comment '作案手段'")
    private String crimeMethod; // string(4)
    @Column(columnDefinition = "varchar(30) comment '作案特点代码'")
    private String crimeCharacterCode; // string(3)
    @Column(columnDefinition = "varchar(30) comment '在逃人员编号'")
    private String escapedCriminalNumber; // string(23)
    @Column(columnDefinition = "varchar(30) comment '是否在押人员:0：否；1：是；2：不确定，人工采集必填'")
    private Integer isDetainees; // int
    @Column(columnDefinition = "varchar(30) comment '看守所编码'")
    private String detentionHouseCode; // string(9)
    @Column(columnDefinition = "varchar(30) comment '在押人员身份'")
    private String detaineesIdentity; // string(2)
    @Column(columnDefinition = "varchar(30) comment '在押人员特殊身份'")
    private String  detaineesSpecialIdentity; // DetaineesSpecialIdentityType
    @Column(columnDefinition = "varchar(30) comment '成员类型代码'")
    private String memberTypeCode; // string(2)
    @Column(columnDefinition = "int(30) comment '是否被害人:0：否；1：是；2：不确定'")
    private Integer isVictim; // int
    @Column(columnDefinition = "varchar(30) comment '被害人种类'")
    private String victimType; // string(3)
    @Column(columnDefinition = "varchar(30) comment '受伤害程度'")
    private String injuredDegree; // string
    @Column(columnDefinition = "varchar(30) comment '尸体状况代码'")
    private String corpseConditionCode; // string(2)
    @Column(columnDefinition = "varchar(30) comment '是否可疑人:0：否；1：是；2：不确定'")
    private Integer isSuspiciousPerson; // int
    @Column(columnDefinition = "int(30) comment '姿态分布:1：平视；2：微仰；3：微俯；4：左微侧脸；5：左斜侧脸；6：左全侧脸；7：右微侧脸；8：右斜侧脸；9：右全侧脸'")
    private Integer attitude ; // int
    @Column(columnDefinition = "varchar(30) comment '相似度:人脸相似度，[0，1]'")
    private Double similarityDegree ; // Double
    @Column(columnDefinition = "varchar(30) comment '眉型:1：上扬眉；2：一字眉；3：八字眉；4：淡眉毛 5：浓眉毛；6：弯眉；7：细眉；8：短眉毛；9：特殊眉； 有多个特征时用英文半角分 号”;”分隔'")
    private String eyebrowStyle ; // string
    @Column(columnDefinition = "varchar(30) comment '鼻型:1：普通鼻；2：扁鼻子；3：尖鼻子；4：朝天" +
            "鼻；5：鹰钩鼻；6：蒜头鼻；7：宽鼻子；8" +
            "小鼻子；9：露孔鼻；10：特殊鼻； 有多个特" +
            "征时用英文半角分号”;”分隔'")
    private String noseStyle ; // string
    @Column(columnDefinition = "varchar(30) comment '胡型:1：一字胡；2：八字胡；3：淡胡子；4：络腮" +
            "胡；5：山羊胡；6：花白胡；7：一点胡'")
    private String mustacheStyle ; // string
    @Column(columnDefinition = "varchar(30) comment '嘴唇:1：常见嘴；2：厚嘴唇；3：薄嘴唇；4：厚嘴" +
            "巴；5：上翘嘴；6：下撇嘴；7：凸嘴；8：凹" +
            "嘴；9：露齿嘴；10：小嘴； 有多个特征时用" +
            "英文半角分号”;”分隔'")
    private String lipStyle ; // string
    @Column(columnDefinition = "varchar(30) comment '皱纹眼袋:1：抬头纹；2：左眼角纹；3：右眼角纹；4：" +
            "眉间纹；5：左眼纹；6：右眼纹；7：眼袋；8：" +
            "左笑纹；9：右笑纹；10：鼻间纹；11：左瘦纹；" +
            "12：右瘦纹； 有多个特征时用英文半角分" +
            "号”;”分隔'")
    private String wrinklePouch ; // string
    @Column(columnDefinition = "varchar(30) comment '痤疮色斑:1：痤疮（单）；2：痤疮（少）；3：痤疮（多）；" +
            "4：雀斑（稀）；5：雀斑（少）；6：雀斑（多）；" +
            "7：色斑； 有多个特征时用英文半角分号”;”" +
            "分隔'")
    private String acneStain ; // string
    @Column(columnDefinition = "varchar(30) comment '黑痣胎记:1：痣（小）；2：痣（中）；3：痣（大）；4：黑" +
            "痣（小）；5：黑痣（中）；6：黑痣（大）；7：" +
            "胎记； 有多个特征时用英文半角分号”;”分 隔'")
    private String freckleBirthmark ; // string
    @Column(columnDefinition = "varchar(30) comment '疤痕酒窝:1：疤痕；2：酒窝左；3：酒窝右； 有多个特" +
            "征时用英文半角分号”;”分隔'")
    private String scarDimple ; // string
    @Column(columnDefinition = "varchar(30) comment '其他特征:1：酒渣鼻（小）；2：酒渣鼻（大）；3：酒渣鼻" +
            "（重）；4：招风耳左；5：招风耳右；6：大耳'")
    private String otherFeature ; // string
}
