package com.vince;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            Socket socket = new Socket("localhost",8888);
            System.out.println("服务器已连接成功");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//输出流要在前
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("请输入姓名:");
            String name = input.nextLine();
            Message message =new Message(name,null,MessageType.TYPE_LOGIN);
            oos.writeObject(message);
            message = (Message)ois.readObject();
            System.out.println(message.getFrom() + message.getInfo());

            es.execute(new ReadThread(ois,name));

            boolean flag = true;
            while (flag){
                message = new Message();
                System.out.println("Info:");
                String info = input.nextLine();
                String a ="exit";
                if(info.equals(a)){
                    message.setFrom(name);
                    message.setType(MessageType.TYPE_EXIT);
                    oos.writeObject(message);
                    System.exit(0);
                }else{
                    message.setInfo(info);
                    message.setFrom(name);
                    message.setType(MessageType.TYPE_SEND);
                    oos.writeObject(message);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ReadThread implements Runnable{
    private ObjectInputStream ois;
    private  String name;
    private boolean flag = true;
    public ReadThread() {
    }

    public ReadThread(ObjectInputStream ois,String name) {
        this.ois = ois;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while(flag) {
                Message message = (Message) ois.readObject();
                if(message.getType()==MessageType.TYPE_LOGIN){
                    System.out.println("【系统通知】：["+message.getFrom()+"]"+message.getInfo());
                }else if(message.getType()==MessageType.TYPE_SEND&&!(message.getFrom().equals(name))) {
                    System.out.println("[" + message.getFrom() + "]" + ":" + message.getInfo());
                }else if(message.getType()==MessageType.TYPE_SEND&&(message.getFrom().equals(name))) {
                    System.out.println("我:"+message.getInfo());
                }else if(message.getType()==MessageType.TYPE_EXIT){
                        System.out.println("【系统通知】：["+message.getFrom()+"]"+message.getInfo());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
