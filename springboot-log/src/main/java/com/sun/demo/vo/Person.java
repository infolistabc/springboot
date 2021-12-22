package com.sun.demo.vo;

import java.util.HashMap;

/**
 * @author wilson
 */
public class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        Person p1 = new Person(1L, "zhansan");
        Person p2 = new Person(1L, "zhansan");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
    }

}
