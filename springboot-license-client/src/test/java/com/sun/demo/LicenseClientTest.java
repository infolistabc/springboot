/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseTest.java
 * Date: 2020-03-22
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo;

import com.sun.demo.util.License;
import com.sun.demo.util.LicenseEntity;

import java.io.InputStream;
import java.util.Base64;

/**
 * 解密测试
 */
public class LicenseClientTest {
    public static void main(String[] args) {
        InputStream inputStream = LicenseClientTest.class.getClassLoader().getResourceAsStream("license.txt");
        License license = new License();

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGjCoLWpiYbciP7tYuooJt25sdq+b3CaJb5VHyIXUODGn7kkCn7YC/sjZYeVxLW7U63q973EjcBww+LQ8EnhvL5NRTNojZR/RjaTEeGB3XOIAfnwf9Brk1X/ziFYjzZFUMjjoMEI8cGWBMKnt/KHCoEUZv3MIqMuK3+MuPTLmvsQIDAQAB";

        LicenseEntity licenseData = license.loadLicense(inputStream, Base64.getDecoder().decode(publicKey));


        System.out.println(new String(licenseData.getData()));
        System.out.println(licenseData.getExpireTime());
    }
}
