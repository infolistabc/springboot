package com.sun.demo.controller;

public class Test3Controller implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("3333");
				Thread.sleep(1000);
				throw new Exception("AAAA");
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
