package com.sun;

/**
 * @author wilson
 */
public class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread1");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread1());
        thread.start();

    }
}
