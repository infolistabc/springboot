package com.sun.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidAnalysisRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(41) comment '分析规则ID：1)系统唯一， 视图库 ID 20 位+" +
            "分析类型（2 位）+ 2 位子类型+ 14 位时间+2" +
            "位流水号" +
            "2)分析类型：与 EventType 取值一致，不足 2" +
            "位左边以 0 补齐" +
            "3)2 位子类型，01 表示视频，02 表示图像；" +
            "4)14 位时间格式“YYYY-MM-DD hh—mm-ss”'")
    private String analysisRuleId; // string
    @Column(columnDefinition = "varchar(41) comment '视频图像来源ID'")
    private String videoImageId; // string(41)
    @Column(columnDefinition = "varchar(20) comment '视频图像来源Url'")
    private String videoImageUrl; // string
    @Column(columnDefinition = "varchar(20) comment '摄像机ID'")
    private String cameraId; // string(20)
    @Column(columnDefinition = "int(20) comment '宽度'")
    private Integer width; // int
    @Column(columnDefinition = "int(20) comment '高度'")
    private Integer height; // int
    @Column(columnDefinition = "int comment '行为最小持续时间'")
    private Integer minDuration; // int
    @Column(columnDefinition = "int comment '绊线检测最小持续时间'")
    private Integer lineMinDuration; // int
    @Column(columnDefinition = "int comment '绊线检测最大持续时间'")
    private Integer lineMaxDuration; // int
    @Column(columnDefinition = "int comment '行为最大持续时间'")
    private Integer maxDuration; // int
    @Column(columnDefinition = "int comment '绊线条数'")
    private Integer lineNum; // int
    @Column(columnDefinition = "int comment '端点数量'")
    private Integer pointNum; // int
    @Column(columnDefinition = "int comment '端点ID'")
    private Integer pointId; // int
    @Column(columnDefinition = "int comment '方向:触发方向：" +
            "0：从左到右" +
            "1：从右到左" +
            "2：从上到下" +
            "3：从下到上" +
            "4：任意方向'")
    private Integer direction; // int
    @Column(columnDefinition = "int comment '入侵行为:0：进入区域" +
            "1：离开区域" +
            "2：区域内出现" +
            "3：区域内消失" +
            "4：在区域内" +
            "其余数值保留'")
    private Integer actionType; // int
    @Column(columnDefinition = "int comment '起点X坐标'")
    private Integer beginPointX; // int
    @Column(columnDefinition = "int comment '起点Y坐标'")
    private Integer beginPointY; // int
    @Column(columnDefinition = "int comment '终点X坐标'")
    private Integer endPointX; // int
    @Column(columnDefinition = "int comment '终点Y坐标'")
    private Integer endPointY; // int
    @Column(columnDefinition = "int comment '方向个数'")
    private Integer directionNum; // int
    @Column(columnDefinition = "int comment '密度检测数值单位，密度检测数值单位：0：密度等级 1：密度百分比 2:个数 其余数值保留'")
    private Integer densityUnit; // int
    @Column(columnDefinition = "int comment '目标的类型：" +
            "1：人员，2：人脸，3：机动车，4：非机动车，" +
            "5：物品，6：场景'")
    private Integer targetType;
    @Column(columnDefinition = "varchar(1000) comment '分析规则'")
    private String ruleBody;
    //private LineList lineSet; // LineList
    // private DirectionList directionSet; // DirectionList
    // private PointList pointSet; // PointList
}
