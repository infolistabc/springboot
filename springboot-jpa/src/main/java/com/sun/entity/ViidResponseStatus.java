package com.sun.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wilson
 */
@Data
@Entity
public class ViidResponseStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigInt(20) comment '主键自增长'")
    private Long id;
    @Column(columnDefinition = "varchar(20) comment '请求资源Url'")
    private String requestUrl; // string
    @Column(columnDefinition = "bigInt(20) comment '状态码，O-OK， 正常 1-OtherError，其他未知错误，2-Device Busy，设备忙，3-Device Error，设备错，4-Invalid Operation，无效操作，5-Invalid XML Format，XML 格式无效，6-Invalid XML Content，XML 内容无效，7-Invalid JSON Format，JSON 格式无效，8-Invalid JSON Content，JSON 内容无效，9-Reboot，系统重启中，以附录 B 中类型定义为准'")
    private Integer statusCode; // int
    @Column(columnDefinition = "varchar(20) comment '状态描述'")
    private String statusString; // string
    //private String id; // string
    @Column(columnDefinition = "dateTime comment '日期'")
    private Date localTime; // dateTime
}
