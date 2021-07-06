/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseException.java
 * Date: 2020-03-26
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo.util;

/**
 * @author 三刀
 * @version V1.0 , 2020/3/21
 */
public class LicenseException extends RuntimeException {
    public LicenseException(String message) {
        super(message);
    }

    public LicenseException(String message, Throwable cause) {
        super(message, cause);
    }
}
