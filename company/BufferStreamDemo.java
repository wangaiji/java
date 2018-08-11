package com.company;

import java.io.*;

public class BufferStreamDemo {
    public static void main(String[] args){

    }

    private static void byteWriter(){
        File file = new File("c://test//vince.txt");
        try {
            OutputStream out = new FileOutputStream(file);
            //构造一个字节缓冲流
            BufferedOutputStream bos = new BufferedOutputStream(out);
            String info = "小河还是流水哗啦啦";
            bos.write(info.getBytes());

            bos.close(); //会自动关闭out
        //    out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
