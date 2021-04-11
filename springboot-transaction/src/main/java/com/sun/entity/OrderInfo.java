package com.sun.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderInfo implements Serializable {
    private Long id;
    private Long userId;
    private String productName;
    private String productor;
}
