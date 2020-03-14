package com.sun.utils;

import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * @author wilson
 */
public class ToBeanUtil {
    public static <T> T mapToBean(Map<String, Object> map, T bean){
        BeanMap beanMap=BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
