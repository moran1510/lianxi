package com.Multithreading;

import java.util.List;

public class MyWorker extends Thread{
    private String name;
    private List<Runnable> tasks;

    public MyWorker(List<Runnable> tasks, String name) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (tasks.size()>0){
            Runnable r = tasks.remove(0);
            r.run();
        }
    }
}
