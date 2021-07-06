/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseServer.java
 * Date: 2020-03-22
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo.util;

import org.apache.commons.cli.*;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * 生成License工具类
 */
public class LicenseServer {

    private final File sourceFile;
    private final File licenseFile;

    public LicenseServer(File sourceFile, File licenseFile) {
        this.sourceFile = sourceFile;
        this.licenseFile = licenseFile;
    }

    /**
     * 采用非对称加密对data作预处理
     * @param data  加密数据
     * @param expireDate 有效期
     * @param privateKey 私钥
     * @throws Exception
     */
    public void createLicense(byte[] data, Date expireDate, byte[] privateKey) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int offset = 0;
        int step = 64;
        if (step > data.length) {
            step = data.length;
        }
        //使用私钥对数据进行加密
        while (offset < data.length) {
            byte[] encryptData = RasUtil.encryptByPrivateKey(data, privateKey, offset, step);
            byteArrayOutputStream.write(encryptData.length);
            byteArrayOutputStream.write(encryptData);
            offset += step;
            step = Math.min(data.length - offset, step);
        }
        createLicense(byteArrayOutputStream.toByteArray(), expireDate);
    }

    /**
     * 生成License
     *
     * @param data       license内容
     * @param expireDate 过期时间
     */
    public void createLicense(byte[] data, Date expireDate) throws Exception {
        if (expireDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);
            expireDate = calendar.getTime();
        }
        //初始化密钥
        //生成密钥对
        KeyPair keyPair = RasUtil.initKey();
        LicenseEntity entity = new LicenseEntity(expireDate.getTime(), RasUtil.getPublicKey(keyPair), Md5.md5(data));
        entity.setData(data);
        //生成license文件
        createLicense(entity, keyPair);
        //生成License源文件
        createSourceLicense(entity, keyPair);
    }

    private void createLicense(LicenseEntity entity, KeyPair keyPair) throws Exception {
        //生成License
        try (FileOutputStream fileOutputStream = new FileOutputStream(licenseFile)) {
            LicenseEncode licenseEncode = new LicenseEncode();
            fileOutputStream.write(Base64.getEncoder().encodeToString(licenseEncode.encode(entity, RasUtil.getPrivateKey(keyPair))).getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * 生成License源文件
     */
    private void createSourceLicense(LicenseEntity entity, KeyPair keyPair) throws IOException {
        SourceLicense sourceLicense = new SourceLicense(entity, keyPair);
        //生成License源文件
        try (FileWriter fileWriter = new FileWriter(sourceFile)) {
            Properties properties = new Properties();
            properties.setProperty(SourceLicense.PROPERTY_APPLY_DATE, sourceLicense.getApplyDate());
            properties.setProperty(SourceLicense.PROPERTY_EXPIRE_DATE, sourceLicense.getExpireDate());
            properties.setProperty(SourceLicense.PROPERTY_BASE64_CONTENT, sourceLicense.getBase64Content());
            properties.setProperty(SourceLicense.PROPERTY_PUBLIC_KEY, sourceLicense.getPublicKey());
            properties.put(SourceLicense.PROPERTY_PRIVATE_KEY, sourceLicense.getPrivateKey());
            properties.store(fileWriter, null);
        }
        System.out.println("Expire Date:" + sourceLicense.getExpireDate());
    }
}
