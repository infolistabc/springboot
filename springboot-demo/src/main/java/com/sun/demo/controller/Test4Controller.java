package com.sun.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class Test4Controller implements Runnable {

	@PostConstruct
	public void init() {

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1100);
				System.out.println("4444");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} // TODO Auto-generated method stub

	}

}
