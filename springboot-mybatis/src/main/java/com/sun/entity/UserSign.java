package com.sun.entity;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserSign {
    private Long id;
    private String userKey;
    private Integer signMark;
    private LocalDate crtTime;
    private LocalDate updTime;
}
