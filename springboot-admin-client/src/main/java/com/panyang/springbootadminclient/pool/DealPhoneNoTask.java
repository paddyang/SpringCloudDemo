package com.panyang.springbootadminclient.pool;

import java.util.concurrent.Callable;

public class DealPhoneNoTask implements Callable<String> {

    private String phoneNo;

    public DealPhoneNoTask(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String call() throws Exception {
        //System.out.println("当前线程id"+Thread.currentThread().getId()+"name"+Thread.currentThread().getName());
        //Thread.sleep(1000);
        if (11 == phoneNo.length()){
            String substring = phoneNo.substring(0, 3);
            if ("136".equals(substring)){
                return phoneNo;
            }
        }
        return null;
    }
}
