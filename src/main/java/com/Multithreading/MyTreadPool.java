package com.Multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyTreadPool {
    //任务队列
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
    //当前线程数量
    private int nums;
    //核心线程数量
    private int corePoolSize;
    //最大线程数
    private int maxSize;
    //任务队列最大长度
    private int workSize;

    public MyTreadPool(int corePoolSize, int maxSize, int workSize) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.workSize = workSize;
    }

    public void submit(Runnable r){
        if (tasks.size()>=workSize){
            System.out.println("任务"+r+"被丢弃");
        }else {
            tasks.add(r);
            //执行任务
            execTask(r);
        }
    }

    private void execTask(Runnable r) {
        if (nums<corePoolSize){
            new MyWorker(tasks,"核心线程" + nums).start();
            nums++;
        }else if(nums<maxSize){
            new MyWorker(tasks,"非核心线程" + nums).start();
            nums++;
        }else {
            System.out.println("任务"+r+"被缓存");
        }
    }
}
