package com.vince;

public class ThreadDemo4 {
        public static void main(String[] args){
            MyRunnable3 mr = new MyRunnable3();
            Thread t = new Thread(mr);
            t.start();
            for(int i=0;i<=30;i++){
                System.out.println(Thread.currentThread().getName()+"--"+i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i==20){
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
    class MyRunnable3 implements Runnable{
        @Override
        public void run() {

            for(int i=0;i<=30;i++){
                System.out.println(Thread.currentThread().getName()+"--"+i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


