package com.sun.dao;

import com.sun.entity.UserSign;
import org.apache.ibatis.annotations.Param;

public interface IUserSignDao {
    /**
     * 签到
     * @param userSign  签单对象
     * @return
     */
    int doSign(UserSign userSign);

    UserSign checkSign(@Param("userKey") String userKey);

    /**
     * 更新签到数据
     * @param userSign
     * @return
     */
    int updateByUserKey(UserSign userSign);

}
