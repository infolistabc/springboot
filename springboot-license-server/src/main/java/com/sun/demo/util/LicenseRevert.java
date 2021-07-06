/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseRevert.java
 * Date: 2020-04-14
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo.util;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Properties;

/**
 * 还原License
 *
 * @author 三刀
 * @version V1.0 , 2020/4/14
 */
public class LicenseRevert {
    public static void main(String[] args) throws IOException, ParseException {
        if (args.length == 0) {
            System.err.println("file path is null");
            return;
        }
        File file = new File(args[0]);
        if (file.isFile()) {
            createLicense(new FileInputStream(file));
        } else {
            System.err.println("file " + file.getAbsolutePath() + " is not exists");
        }
    }

    private static void createLicense(InputStream inputStream) throws IOException, ParseException {
        Properties properties = new Properties();
        properties.load(inputStream);
        String expireTime = properties.getProperty(SourceLicense.PROPERTY_EXPIRE_DATE);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] content = decoder.decode(properties.getProperty(SourceLicense.PROPERTY_BASE64_CONTENT));
        byte[] publicKey = decoder.decode(properties.getProperty(SourceLicense.PROPERTY_PUBLIC_KEY));
        byte[] privateKey = decoder.decode(properties.getProperty(SourceLicense.PROPERTY_PRIVATE_KEY));
        SimpleDateFormat sdf = new SimpleDateFormat(SourceLicense.DATE_FORMAT);
        LicenseEntity licenseEntity = new LicenseEntity(sdf.parse(expireTime).getTime(), publicKey, Md5.md5(content));
        licenseEntity.setData(content);

        //生成License
        File file = new File("license_revert.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            LicenseEncode licenseEncode = new LicenseEncode();
            fileOutputStream.write(Base64.getEncoder().encodeToString(licenseEncode.encode(licenseEntity, privateKey)).getBytes(StandardCharsets.UTF_8));
        }
    }
}
