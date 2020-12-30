package com.sun.service.impl;

import com.sun.dao.IUserSignDao;
import com.sun.entity.UserSign;
import com.sun.service.IUserSignService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
/**
 * 使用一个32位的int型整数表示签到状态，每个bit位代表月份中的一天，当天签到了则置1
 * 只需使用4byte就能保存一个月的签到状态信息
 * redis有相同实现
 */
@Service
public class UserSignServiceImpl implements IUserSignService {

    @Resource
    IUserSignDao iUserSignDao;

    @Override
    public boolean doSign(Long uid, LocalDate date) {
        int offset = date.getDayOfMonth() - 1;
        UserSign userSignTemp = iUserSignDao.checkSign(buildSignKey(uid,date));
        int element = 0;
        //签到或更新签到
        UserSign userSign = new UserSign();
        userSign.setUserKey(buildSignKey(uid,date));
        if (userSignTemp==null){
            element |= 1 << (offset);
            userSign.setSignMark(element);
            userSign.setCrtTime(date);
            iUserSignDao.doSign(userSign);
        }else {
            //判断当天是否已签到
            if ((userSignTemp.getSignMark() & (1 << (date.getDayOfMonth() - 1))) != 0){
                return false;
            }
            element = userSignTemp.getSignMark();
            element |= 1 << (offset);
            userSign.setSignMark(element);
            userSign.setUpdTime(date);
            iUserSignDao.updateByUserKey(userSign);
        }
        return true;
    }

    @Override
    public int getSignDays(Long uid,LocalDate date) {
        UserSign userSignTemp = iUserSignDao.checkSign(buildSignKey(uid,date));
        if (userSignTemp!=null){
            return Integer.bitCount(userSignTemp.getSignMark());
        }else {
            return 0;
        }
    }

    @Override
    public boolean checkSign(Long uid,LocalDate date) {
        UserSign userSignTemp = iUserSignDao.checkSign(buildSignKey(uid,date));
        if (userSignTemp!=null){
            return (userSignTemp.getSignMark() & (1 << (date.getDayOfMonth()-1))) != 0;
        }
        return false;
    }

    @Override
    public LocalDate getFirstSignDate(Long uid,LocalDate date) {
        UserSign userSignTemp = iUserSignDao.checkSign(buildSignKey(uid,date));
        if (userSignTemp!=null){
            String result = new StringBuilder(intToBinary32(userSignTemp.getSignMark(),32)).reverse().toString();
            int pos = result.indexOf('1');
            return pos < 0 ? null : date.withDayOfMonth((pos + 1));
        }
        return null;
    }

    @Override
    public Map<String, Boolean> getSignInfo(Long uid, LocalDate date) {
        Map<String, Boolean> signMap = new HashMap<>(date.getDayOfMonth());
        UserSign userSignTemp = iUserSignDao.checkSign(buildSignKey(uid,date));
        if (userSignTemp!=null){
            String result = new StringBuilder(intToBinary32(userSignTemp.getSignMark(),32)).reverse().toString();
            for (int i =date.lengthOfMonth();i>0;i--){
                LocalDate d = date.withDayOfMonth(i);
                signMap.put(formatDate(d,"yyyy-MM-dd"),result.charAt(i-1)=='1');
            }
            return signMap;
        }
        return null;
    }

    @Override
    public long getContinuousSignCount(Long uid, LocalDate date) {
        UserSign userSignTemp = iUserSignDao.checkSign(buildSignKey(uid,date));
        if (userSignTemp==null){
            return 0;
        }
        String result = new StringBuilder(intToBinary32(userSignTemp.getSignMark(),32)).reverse().toString();
        System.out.println(result);
        int count = 0;
        for (int i =date.lengthOfMonth();i>0;i--){
            if(result.charAt(i-1)=='1'){
                count++;
                if (result.charAt(i-2)=='0'){
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 返回签名的key
     * @param uid
     * @param date
     * @return
     */
    private static String buildSignKey(Long uid, LocalDate date) {
        return String.format("u:sign:%d:%s", uid, formatDate(date));
    }

    private static String formatDate(LocalDate date) {
        return formatDate(date, "yyyyMM");
    }

    private static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public  String intToBinary32(int i, int bitNum){
        StringBuilder binaryStr = new StringBuilder(Integer.toBinaryString(i));
        while(binaryStr.length() < bitNum){
            binaryStr.insert(0, "0");
        }
        return binaryStr.toString();
    }
}
