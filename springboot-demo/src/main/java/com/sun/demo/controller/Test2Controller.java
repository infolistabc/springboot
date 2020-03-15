package com.sun.demo.controller;

public class Test2Controller implements Runnable {

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
