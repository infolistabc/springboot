/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseEncode.java
 * Date: 2020-03-26
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *  加解密工具类
 */
class LicenseEncode {
    private static final int MAX_DATA_LENGTH = 64;
    private static final int MIN_DATA_LENGTH = 32;

    /**
     * 加密工具类
     * @param entity 加密实体
     * @param privateKey 私钥
     * @return
     * @throws IOException
     */
    public byte[] encode(LicenseEntity entity, byte[] privateKey) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(LicenseEntity.MAGIC_NUM);
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(entity);
        outputStream.write(entity.getSplitFlag());
        outputStream.writeLong(entity.getApplyTime());
        outputStream.writeLong(entity.getExpireTime());
        outputStream.write(entity.getSplitFlag());

        outputStream.write(entity.getPublicKeys().length);
        outputStream.write(entity.getPublicKeys());
        outputStream.write(entity.getSplitFlag());

        int offset = 0;
        int step = nextStep();
        byte[] data = entity.getData();
        if (data.length < step) {
            step = data.length;
        }
        while (offset < data.length) {
            byte[] encryptData = RasUtil.encryptByPrivateKey(data, privateKey, offset, step);
            outputStream.write(encryptData.length);
            outputStream.write(encryptData);
            outputStream.write(entity.getSplitFlag());
            outputStream.writeLong(entity.getExpireTime() % step);
            outputStream.flush();
            offset += step;
            int nextStep = nextStep();
            step = Math.min(data.length - offset, nextStep);
        }
        outputStream.write(0);
        outputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private int nextStep() {
        int step = (int) (System.nanoTime() % MAX_DATA_LENGTH);
        if (step < MIN_DATA_LENGTH) {
            step = MIN_DATA_LENGTH;
        }
        return step;
    }
}
