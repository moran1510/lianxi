package com.demo;

import java.util.Random;
import java.util.concurrent.*;

public class DuoXianCheng {
//    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        MyThread myThread3 = new MyThread();
//        myThread1.start();
//        myThread2.start();
//        myThread1.join();
//        myThread3.start();
//
//    }


    //线程池第一种方法
//public static void main(String[] args) {
//
//    // Array  Arrays(辅助工具类)
//    // Collection Collections(辅助工具类)
//    // Executor Executors(辅助工具类)
//
//
//    // 一池5个处理线程（用池化技术，一定要记得关闭）
//    ExecutorService threadPool = Executors.newFixedThreadPool(5);
//
//    // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
//    try {
//
//        // 循环十次，模拟业务办理，让5个线程处理这10个请求
//        for (int i = 0; i < 10; i++) {
//            final int tempInt = i;
//            threadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
//                }
//            });
//
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        threadPool.shutdown();
//    }
//
//}


    public static void main(String[] args) {

        //创建线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        //声明执行结果
        ScheduledFuture<Integer> furture=null;

        try {
            for (int i = 0; i <20; i++) {
                ScheduledFuture result = service.schedule(new Callable(){
                    @Override
                    public Object call() throws Exception {
                        System.out.println(Thread.currentThread().getName());
                        return new Random().nextInt(100);
                    }

                }, 3, TimeUnit.MILLISECONDS);
                //每执行一次就打印一次结果，此结果就是线程的执行结果
                System.err.println(result.get());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭线程池
            service.shutdown();
        }
    }
}
class MyThread extends Thread{
    static int sum = 100;
    @Override
    public void run() {
        synchronized (this){
            while (sum>0){
                System.out.println("第"+sum);
                sum--;
            }
        }

    }
}
