package com.sun.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Account implements Serializable {
    private Long id;
    private String name;
    private Integer balance;
    private Long orderId;
}
