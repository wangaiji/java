package com.nio;

import java.nio.ByteBuffer;

public class NIODemo {
    public static void main(String[] args){

        //创建一个字节缓冲区，申请内存空间为8字节
        ByteBuffer buf = ByteBuffer.allocate(8);
        System.out.println("position="+buf.position());
        System.out.println("limit="+buf.limit());
        System.out.println("capacity="+buf.capacity());

        buf.put((byte)10);
        buf.put((byte)20);
        buf.put((byte)30);
        buf.put((byte)40);
        System.out.println("position="+buf.position());
        System.out.println("limit="+buf.limit());
        System.out.println("capacity="+buf.capacity());

        //缓冲区反转
        buf.flip();
        System.out.println("position="+buf.position());//position=0
        System.out.println("limit="+buf.limit());//limit=position=4
        System.out.println("capacity="+buf.capacity());
        //告知在当前位置和限制之间是否有元素
        if(buf.hasRemaining()){
            //返回当前位置与限制之间的元素数
            for(int i=0;i<buf.remaining();i++){
                byte b = buf.get(i);
                System.out.println(b);
            }
        }

    }
}
