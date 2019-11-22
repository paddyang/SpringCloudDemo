package com.panyang.springbootadminclient.pool;


public class Task implements Runnable{

    private String phoneNo;

    public Task(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public void run() {
        System.out.println("开始");
    }
}
