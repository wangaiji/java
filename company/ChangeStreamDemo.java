package com.company;

import java.io.*;
import java.nio.charset.Charset;

public class ChangeStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
     //   InputStream in = new FileInputStream("c:\\test\\vince.txt");
     //   read(in);
        OutputStream out = new FileOutputStream("c:/test/vince.txt");
        write(out);
    }

    private static void write(OutputStream out){
        Writer writer = new OutputStreamWriter(out,Charset.defaultCharset());// 得看传输方向
        try {
            writer.write("开开心心来玩耍\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void read(InputStream in){
        Reader reader = new InputStreamReader(in,Charset.forName("UTF-8")); // Charset.defaultCharset()
        char[] cs = new char[1024];
        int len = -1;
        try{
            while((len=reader.read(cs))!=-1){
                System.out.println(new String(cs,0,len));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
