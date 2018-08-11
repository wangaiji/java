package com.vince;

public class ThreadDemo2 {
    public static void main(String[] args){
        MyRunnable mr = new MyRunnable();
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
                mr.flag=false;
            }
        }
    }

}

class MyRunnable implements Runnable{
    public boolean flag = true;
    public MyRunnable(){
        flag = true;
    }

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"--"+(i++));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
