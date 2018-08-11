package com.company;

import javax.imageio.IIOException;
import java.io.*;

public class ByteStreamDemo {
    private static void in(){
        File file = new File("c:/test/vince.txt");
        try {
            InputStream in = new FileInputStream(file);
            byte[] bytes = new byte[12]; // char[]字符输入流
            StringBuilder buf = new StringBuilder();
            int len = -1; // 表示每次读取的字节长度
            // 把数据读入到数组中，并返回读取的字节数，当不等于-1时，表示读取到数据，等于-1表示文件已读完
            while((len = in.read(bytes))!=-1){
                // 根据读取到的字节数组，再转换为字符串内容，添加到StringBuilder中
                buf.append(new String(bytes,0,len));//避免后面的重复出现
            }
            System.out.println(buf);
            // 关闭输入流
            in.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        in();
    }
}
