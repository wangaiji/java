package com.company;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {
    private static void byteArray(){
        String s = "12345676dfghjhg(*$$%^&SDFGHJ";
        ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int curr = -1;//每次读取的字节
        while((curr=bais.read())!=-1){
            if((curr>=65&&curr<=90)||(curr>=97&&curr<=122)){
                baos.write(curr);
            }
        }
        //此时无需关闭，原因：字节数组流是基于内存的操作流，和文件无关
        System.out.println(baos.toString());
    }

    public static void main(String[] args){
        byteArray();
    }
}
