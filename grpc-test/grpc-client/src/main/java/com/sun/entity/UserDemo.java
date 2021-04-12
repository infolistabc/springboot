package com.sun.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDemo implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private String address;

    private Integer age;



}