package com.sun.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wilson
 * 签到请求参数
 */
@Data
public class SignReqParam {
    @ApiModelProperty(value = "用户ID",required = true,example = "1000")
    private Long uid;
    @ApiModelProperty(value = "签到日期",required = true,example = "2020-12-30")
    private String date;
}
