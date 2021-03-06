package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileDemo {

    private static void randomAccessFileCopy() throws Exception {
        RandomAccessFile in = new RandomAccessFile("c:\\test\\vince.txt","r");
        RandomAccessFile out = new RandomAccessFile("c:\\TXT\\vince.txt","rw");

        FileChannel fcIn = in.getChannel();
        FileChannel fcOut = out.getChannel();

        long size = fcIn.size();//输入流的字节大小
        //输入流的缓冲区
        MappedByteBuffer inBuf = fcIn.map(FileChannel.MapMode.READ_ONLY,0,size);
        //输出流的缓冲区
        MappedByteBuffer outBuf = fcOut.map(FileChannel.MapMode.READ_WRITE,0,size);
        for(int i=0;i<size;i++){
            outBuf.put(inBuf.get());
        }
        //关闭通道时会写入数据块
        fcIn.close();
        fcOut.close();
        in.close();
        out.close();

    }

    //通过文件通道实现文件的复制
    private static void copyFile() throws Exception{
        //创建一个输入文件的通道
        FileChannel fcIn = new FileInputStream("c:\\test\\vince.txt").getChannel();
        //创建一个输出文件的通道
        FileChannel fcOut = new FileOutputStream("c:\\TXT\\vince.txt").getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while(fcIn.read(buf)!=-1){
            buf.flip();
            fcOut.write(buf);
            buf.clear();
        }
        fcIn.close();
        fcOut.close();
        System.out.println("copy success.");
    }

    public static void main(String[] args) throws Exception {
       // copyFile();
        randomAccessFileCopy();
    }
}
