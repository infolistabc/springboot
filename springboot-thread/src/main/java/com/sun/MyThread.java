package com.sun;

/**
 * @author wilson
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("myThread");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
