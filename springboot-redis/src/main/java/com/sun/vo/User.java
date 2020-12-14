package com.sun.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Zheng Jie
 * @date 2018-11-22
 */
@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String email;

    private String phone;

    private Boolean enabled;

    private String password;

}