package com.Multithreading;

public class MyTest {

    public static void main(String[] args) {
        MyTreadPool myTreadPool = new MyTreadPool(2,4,20);
        for (int i = 0; i < 10; i++) {
            MyTask my = new MyTask(i);
            myTreadPool.submit(my);
        }
    }



}
