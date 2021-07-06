/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: RasUtil.java
 * Date: 2020-03-22
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo.util;


import javax.crypto.Cipher;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


/**
 *加密工具类
 */
public class RasUtil {
    private static final String KEY_ALGORITHM = "RSA";

    private static final int KEY_SIZE = 1024;

    public static KeyPair initKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        return keyPairGenerator.generateKeyPair();
    }


    /**
     * 私钥加密
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key) {
        return encryptByPrivateKey(data, key, 0, data.length);
    }

    /**
     * 非对称加密数据
     * @param data 待加密数据
     * @param key  私钥
     * @param start
     * @param length 加密长度
     * @return
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key, int start, int length) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return cipher.doFinal(data, start, length);
        } catch (Exception e) {
            throw new LicenseException("encrypt exception", e);
        }
    }

    public static byte[] getPrivateKey(KeyPair keyPair) {
        return keyPair.getPrivate().getEncoded();
    }


    public static byte[] getPublicKey(KeyPair keyPair) {
        return keyPair.getPublic().getEncoded();
    }

    public static void main(String[] args) throws Exception{
        KeyPair keyPair = RasUtil.initKey();
        String publicKey = "publicKey: " + Base64.getEncoder().encodeToString(RasUtil.getPublicKey(keyPair));
        String privateKey = "privateKey: " + Base64.getEncoder().encodeToString(RasUtil.getPrivateKey(keyPair));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--------- ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append(" ---------");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(publicKey);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(privateKey);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("--------- END ---------");
        stringBuilder.append(System.lineSeparator());
        System.out.println(stringBuilder);
        FileOutputStream fileOutputStream = new FileOutputStream("keystore", true);
        fileOutputStream.write(stringBuilder.toString().getBytes());
        fileOutputStream.close();
    }
}