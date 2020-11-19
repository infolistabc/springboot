package com.sun.demo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ObjectUtil {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        HashMap map = new HashMap();
        map.put("a","a");
        map.put("b","b");
        map.get("a");
        System.out.println(map.toString());
    }
}
