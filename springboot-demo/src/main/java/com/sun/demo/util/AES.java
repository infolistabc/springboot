package com.sun.demo.util;

import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
/**
 * [简要描述]: AES的加密和解密
 * [创建人员]: YuBinhe
 * [当前版本]: V1.0
 * [创建时间]: 2020年3月30日 上午10:50:25
 */
@SuppressWarnings("restriction")
public class AES {
    //密钥 (需要前端和后端保持一致)
    public static final String secretKey = "ping$123#456@An!";
    //算法
    private static final String ALGORITHMSTR = "AES/CBC/PKCS5Padding";

    private static final String initVector="encryptionIntVec";

    /**
     * aes解密
     * @param encrypt   内容
     * @return
     * @throws Exception
     */
    public static String aesDecrypt(String encrypt) {
        try {
            return aesDecrypt(encrypt, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * aes加密
     * @param content
     * @return
     * @throws Exception
     */
    public static String aesEncrypt(String content) {
        try {
            return aesEncrypt(content, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将byte[]转为各种进制的字符串
     * @param bytes byte[]
     * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix){
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }

    /**
     * base 64 encode
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes){
        return Base64.encodeBase64String(bytes);
    }

    /**
     * base 64 decode
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode(String base64Code) throws Exception{
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }


    /**
     * AES加密
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"),iv);

        return cipher.doFinal(content.getBytes("utf-8"));
    }


    /**
     * AES加密为base 64 code
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES解密
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey 解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"),iv);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }


    /**
     * 将base 64 code AES解密
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    /**
     * 处理有可能的由于url传参带来的+号变空格的问题
     * @Title:        aesDecryptConverted
     * @Description:  TODO
     * @param:        @param encryptStr
     * @param:        @param decryptKey
     * @param:        @return
     * @param:        @throws Exception
     * @return:       String
     * @throws
     * @author        LIYIZHENG419
     * @Date          2020年9月19日 下午2:08:20
     */
    public static String aesDecryptConverted(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null :
                aesDecryptByBytes(base64Decode(encryptStr.replace(" ", "+")), decryptKey);
    }

    /**
     * 测试
     */
    public static void main(String[] args) throws Exception {
        String str = "aR6CxyUazJPmzvMr9EiRN7KEDl5cmEwqxWpDp9B7VsDkyhZ2vm6CtPG2NXBDK0Lp9W825t5FF5stBGatYmhOVpgV+ES3wxFfDbNKIXdZJnupRRWDAu93ZiL4/FUZC1eKThcqyoTxJ/xycKdunopmGL+PJw9sDRNN0s4/3G9qX9m59OWZM5LPMFxTxX5xl+E/m5kjVaLR+Tq5sKQ9GSCkU2iXbKgSPY2DFfsEZGfAimQ=";
        System.out.println("解密后：" + aesDecrypt(str));
    }
}
