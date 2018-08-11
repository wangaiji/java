package com.vince;

import java.util.concurrent.*;

public class ThreadDemo5 {
    public static void main(String[] args) {
        //创建线程池（4种）
        //1 创建一个单线程的线程池
      //  ExecutorService es = Executors.newSingleThreadExecutor();
        //2 创建固定大小的线程池
       ExecutorService es = Executors.newFixedThreadPool(2);//交替执行
        //3 创建一个可缓存的线程池，如果线程池的大小超过了处理任务所需的线程
        //那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时
        //此线程池又可以智能的添加新线程来处理任务，此线程池不会对线程池大小做限制
        //线程池的大小完全依赖于操作系统（JVM）能够创建的最大线程大小
        //ExecutorService es = Executors.newCachedThreadPool();
        //创建一个大小无限的线程池，此线程池支持定时以及周期性执行任务的需求
     //   ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
        es.execute(new MyRunable4());//执行完一个任务再执行下一个任务
        es.execute(new MyRunable4());
    //    es.schedule(new MyRunable4(),3000,TimeUnit.MILLISECONDS);//3000是延时

        es.shutdown();//结束
    }
}

    class MyRunable4 implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"--"+i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

