package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressionAndDecompressionDemo {
    //压缩
    private static void compression(String zipFileName,File targetFile){
        System.out.println("正在压缩...");
        try {
            //要生成的压缩文件
            ZipOutputStream out =new ZipOutputStream(new FileOutputStream(zipFileName));
            BufferedOutputStream bos = new BufferedOutputStream(out);
            zip(out,targetFile,targetFile.getName(),bos);
            bos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) throws IOException {
        //如果是个目录
        if(targetFile.isDirectory()){
            File[] files = targetFile.listFiles();
            if(files.length==0){  //空文件夹
                zOut.putNextEntry(new ZipEntry(name+"/")); //处理空目录
            }
            for(File f:files){
                //递归处理
                zip(zOut,f,name+"/"+f.getName(),bos);
            }
        }else{
            zOut.putNextEntry(new ZipEntry(name));
            InputStream in = new FileInputStream(targetFile);
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            bis.close();
        }
    }

    //解压
    private static void decompression(String targetFileName,String parent) throws IOException {  //parent是父目录
        //构造解压输入流
         ZipInputStream zIn = new ZipInputStream(new FileInputStream(targetFileName));
         BufferedInputStream bis = new BufferedInputStream(zIn);
         ZipEntry entry = null;
         File file = null;
         while((entry = zIn.getNextEntry())!= null&& !entry.isDirectory()){
             file = new File(parent,entry.getName());
             if(!file.exists()){
                 new File(file.getParent()).mkdirs();//创建此文件的上级目录
             }
             OutputStream out = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(out);
             byte[] bytes = new byte[1024];
             int len = -1;
             while((len=bis.read(bytes))!=-1){
                 bos.write(bytes,0,len);
             }
             bos.close();
         //    bis.close();
         }
        bis.close();
    }

    public static void main(String[] args) throws IOException {
        //compression("e:/学生管理系统.zip", new File("e:/学生管理系统"));
        decompression("e:/学生管理系统.zip","e:/learngit");

    }
}
