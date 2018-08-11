package com.vince;

import java.util.concurrent.locks.ReentrantLock;

//共享数据会发生线程不安全的问题
//共享数据必须使用同步（线程锁）//排队轮流 --线程安全
public class ThreadDemo3 {
    public static void main(String[] args) {
        MyRunnable2 mr = new MyRunnable2();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.start();
        t2.start();
    }
}
class MyRunnable2 implements Runnable{
    private int ticket = 10;
    private Object obj = new Object();//什么类型对象都行，只要是同一个对象（同步锁）
    @Override
    public void run() {
        for(int i=0;i<300;i++){
        //    if (ticket>0){
            synchronized (obj) { //同一把锁，括号里也可以是this  代码块结束以后才会释放锁
                if (ticket > 0) {
                    ticket--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("您购买的票剩余" + ticket + "张");
                }
            }

        }
    }

//    //互斥锁
//    ReentrantLock lock = new ReentrantLock();
//    private void method(){
//        lock.lock();//锁
//        try {
//            if (ticket > 0) {
//                ticket--;
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("您购买的票剩余" + ticket + "张");
//            }
//        }finally {
//            lock.unlock();//释放锁 加finally为了确保它一定会释放，要不然就是死锁
//        }
//
//    }
}