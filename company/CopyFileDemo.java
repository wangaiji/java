package com.company;

import java.io.*;

public class CopyFileDemo {
    public static void main(String[] args){
        copy("c:\\test\\vince.txt","c:\\TXT\\iii.txt");
    }
    private static void copy(String src,String target){
        File srcFile = new File(src);
        File targetFile = new File(target);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(targetFile);
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len=in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
