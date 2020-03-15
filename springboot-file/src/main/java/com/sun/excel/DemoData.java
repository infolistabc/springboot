package com.sun.excel;

public class DemoData {
	private String name;
	private int age;
	private double num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "DemoData [name=" + name + ", age=" + age + ", num=" + num + "]";
	}
	
}
