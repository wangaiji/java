package com.vince;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        Vector<UserThread> vector = new Vector<>();
        ExecutorService es = Executors.newFixedThreadPool(5);
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("服务器已启动，正在等待连接...");
            while(true){
                Socket socket = server.accept();
                System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"已连接");
                UserThread userThread = new UserThread(socket,vector);
                es.execute(userThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserThread implements Runnable{
    private String name;
    private Socket socket;
    private Vector<UserThread> vector;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean flag = true;
    public UserThread() {
    }

    public UserThread(Socket socket, Vector<UserThread> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this);
    }

    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            int n = 0;

            while(flag) {
                    Message message = (Message) ois.readObject();
                    name = message.getFrom();
                    switch (message.getType()) {
                        case MessageType.TYPE_LOGIN:
                            for(UserThread ut:vector){
                                if(ut.name!=null){
                                    n++;
                                }
                            }
                            oos.writeObject(new Message("","【系统通知】：已上线，此时线上"+n+"人",MessageType.TYPE_LOGIN));

                            for (int i = 0; i < vector.size(); i++) {
                                UserThread ut = vector.get(i);
                                if (ut != this&&ut.name!=null){
                                //若不判断名字为空，会给无名字的线程输出流，然后它等待下一个输入流
                                    message.setInfo("已上线，此时线上"+n+"人");
                                    ut.oos.writeObject(message);
                                }
                            }
                            break;
                        case MessageType.TYPE_SEND:
                            for (UserThread ut : vector) {
                                ut.oos.writeObject(message);
                            }
                            break;
                        case MessageType.TYPE_EXIT:
                            n=0;
                            for(UserThread ut:vector){
                                if(ut.name!=null){
                                    n++;
                                }
                            }
                            vector.remove(this);
                            n--;
                            for (UserThread ut : vector) {
                                message = new Message(name, "已下线,此时线上"+n+"人", MessageType.TYPE_EXIT);
                                if(ut.name!=null) {
                                    ut.oos.writeObject(message);
                                }
                            }
                            break;
                        default:
                            break;
                    }
            }
            ois.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
