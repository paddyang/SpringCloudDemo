package com.panyang.springbootadminclient.pool;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class PoolTest {

    /**
     * 核心线程池的大小
     */
    private static final int CORE_POOL_SIZE = 1;

    /**
     * 最大线程池的大小
     */
    private static final int MAXIMUM_POOL_SIZE = 2;

    /**
     * 超过核心线程池的大小哪些线程 最多可以存活时间
     */
    private static final long KEEP_ALIVE_TIME = 1000;

    /**
     * 创建线程的线程工厂。这里的自己重写的 增加一些关键信息 方便出问题的时候dump或者看日志能定位到问题
     */
    private static MyThreadFactory threadFactory;

    /**
     * 阻塞队列
     */
    private static BlockingQueue<Runnable> workQueue;

    /**
     * 拒绝策略 当提交任务数超过MAXIMUM_POOL_SIZE+workQueue之和时，任务会交给RejectedExecutionHandler来处理
     */
    private static RejectedExecutionHandler rejectedExecutionHandler;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        threadFactory = new MyThreadFactory("testFactory");
        workQueue = new ArrayBlockingQueue<>(1);
        //rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        rejectedExecutionHandler = new MyReject();

        List<String> list = readTxt();
        List<String> success=new ArrayList<>();
        List<String> fail=new ArrayList<>();
        List<String> exception=new ArrayList<>();
        //List<Future<String>> phoneResult=new ArrayList<>();

        ExecutorService executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, workQueue, threadFactory, rejectedExecutionHandler);

        for (String phoneNo:list){
            //execute无返回值
            //executorService.execute(new Task(phoneNo));

            Future<String> result = executorService.submit(new DealPhoneNoTask(phoneNo));
            try {
                if (null ==result.get()){
                    fail.add(phoneNo);
                }else{
                    success.add(phoneNo);
                }
            } catch (Exception e) {
                System.out.println("处理"+phoneNo+"异常了"+e.getMessage());
                exception.add(phoneNo);
            }

        }
        //在调用 shutdown() 方法之前提交到 ExecutorService 的任务都会执行
        executorService.shutdown();
        wrieText(success,"D:\\test\\success.txt");
        wrieText(fail,"D:\\test\\fail.txt");
        wrieText(exception,"D:\\test\\exception.txt");
        //System.out.println(threadFactory.getStats());
        long end = System.currentTimeMillis();
        System.out.println("结束---耗时"+(end-start));
    }

    /**
     * 写文件
     * @param list
     * @param txtPath
     */
    public static void wrieText(List<String> list,String txtPath){
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        String newLine = System.getProperty("line.separator");
        try {
            if (file.exists()) {
                //判断文件是否存在，如果不存在就新建一个txt
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            for (String s:list){
                fileOutputStream.write(s.getBytes());
                fileOutputStream.write(newLine.getBytes());
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件
     * @return
     */
    public static List<String> readTxt(){
        List<String> list=new ArrayList<>();
        String path="D:\\test\\hebei_pt_cring_201908.zip";
        String path2="D:\\test\\";
        try {
            File file = new File(path);
            if (!file.exists()){
                System.out.println("文件不存在");
                return list;
            }

            ZipUtil zipUtil = new ZipUtil();
            List<String> unzip = zipUtil.unzip(path, path2);

            FileInputStream fileInputStream = new FileInputStream(path2+unzip.get(0));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (null != line){
                list.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
