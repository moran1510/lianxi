package com.Multithreading;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPoolTest {
    public static void main(String[] args) {

        extracted2();
    }

    private static void extracted() {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.submit(new MtRunnable(i));
        }
    }

    private static void extracted1() {
        //每次都会创建一个线程
        ExecutorService es = Executors.newCachedThreadPool(new ThreadFactory() {
            int n = 1 ;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义线程"+(n++));
            }
        });
        for (int i = 0; i < 10; i++) {
            es.submit(new MtRunnable(i));
        }
    }
    private static void extracted2() {
         //指定线程数量
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            es.submit(new MtRunnable(i));
        }
    }
    private static void extracted3() {
        //只有一个线程
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            es.submit(new MtRunnable(i));
        }
    }
}

class MtRunnable implements Runnable{

    private int id;

    public MtRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行了任务。。。"+id);
    }
}
