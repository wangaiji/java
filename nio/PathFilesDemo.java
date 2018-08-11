package com.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class PathFilesDemo {
    public static void main(String[] args){
        File file = new File("c:\\test\\vince.txt");

        //path
        Path p1 = Paths.get("c:\\test","vince.txt");//paths是path的工具类  获得path
        Path p2 = file.toPath();
        Path p3 = FileSystems.getDefault().getPath("c:\\test","vince.txt");

        //Files工具类
        Path p4 = Paths.get("c:\\test\\vince.txt");
        String info = "村花到我家";
        try {
            Files.write(p4,info.getBytes("GBK"),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //复制文件
        try{
            Files.copy(p3,Paths.get("c:\\vince.txt"),StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
