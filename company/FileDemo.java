package com.company;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args){
        File f1 = new File("c:"+File.separator+"test"+File.separator+"vince.txt");
        if(!f1.exists()){
            try{
                f1.createNewFile();
                System.out.println("文件创建成功");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("是否为文件夹："+f1.isDirectory());


    }
}
