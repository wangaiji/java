package com.company;

import java.io.*;

public class DataStreamDemo {
    private static void write(){
        File file = new File("c:\\test\\vince.dat");
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeInt(10); //写入4个字节              读取的时候按着顺序 int num = dis.readInt()
            dos.writeByte(1); //写入1个字节
            dos.writeUTF("中");
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        write();
    }
}
