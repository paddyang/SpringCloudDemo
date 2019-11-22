package com.panyang.springbootadminclient.pool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private int counter = 0;
    private String name;
    List<String> stats;

    MyThreadFactory(String name) {
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread-" + counter);
        counter++;
        String logInfo = String.format("Created thread %d with name %s on%s\n", t.getId(), t.getName(), new Date());
        stats.add(logInfo);
        System.out.println(logInfo);
        return t;
    }

    //这个方法的调用时机 就看你们具体业务上需求如何了，其实线程工厂真的很简单，主要就是根据你的环境
    //定制出你需要的信息 方便日后调试即可 不需要太纠结。
    public String getStats() {
        StringBuilder builder = new StringBuilder();
        for (String str : stats) {
            builder.append(str);
        }
        return builder.toString();
    }
}
