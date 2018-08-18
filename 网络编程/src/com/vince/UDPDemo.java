package com.vince;

import java.io.IOException;
import java.net.*;

public class UDPDemo {
    public static void main(String[] args) {
        String info = "good good study";
        byte[] bytes = info.getBytes();
        try {
            //封装一个数据报包
            //buf - 数据包数据
            //offset - 分组数据偏移量
            //length - 分组数据长度
            //address - 目的地址
            //port - 目的端口号(我发给别人)
            DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length,InetAddress.getByName("127.0.0.1"),8000);
            //本程序的端口
            DatagramSocket socket = new DatagramSocket(9000);//别人发给我
            socket.send(dp);
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
