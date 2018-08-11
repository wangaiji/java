package com.company;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;


public class FileDivisionMergeDemo {
    //文件分割
    private static void division(File targetFile,long cutSize){
        if(targetFile==null) return;
        //计算总分割的文件数
        int num = targetFile.length()%cutSize==0?(int)(targetFile.length()/cutSize):(int)(targetFile.length()/cutSize+1);
        try{
            //构造一个文件输入流
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile));
            BufferedOutputStream out = null;

            byte[] bytes = null;//每次要读取的字节数
            int len = -1;//每次实际读取的长度
            int count = 0;//每一个文件要读取的次数

            //循环次数为生成文件的个数
            for(int i=0;i<num;i++){
                out = new BufferedOutputStream(new FileOutputStream(new File("c:\\test\\"+(i+1)+"-temp-"+targetFile.getName())));
                if(cutSize<=1024){
                    bytes = new byte[(int)cutSize];
                }else{
                    bytes = new byte[1024];
                    count = (int)cutSize/1024;
                }
                while(count>0&&(len=in.read(bytes))!=-1){   //避免多读count必须放前面
                    out.write(bytes,0,len);
                    out.flush();
                    count--;
                }
                //计算每个文件大小除以1024的余数，决定是否要再读取一次
                if(cutSize%1024!=0){
                    bytes = new byte[(int)cutSize%1024];
                    len = in.read(bytes);
                    out.flush();
                    out.close();
                }
            }
            in.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //文件合并
    private static void merge(Enumeration<InputStream> es){
        //构造一个合并流
        SequenceInputStream sis = new SequenceInputStream(es);//合并流
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c:\\test\\14.30_day14总结.avi"));//括号里本应new File，但是这样也可以
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len=sis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            bos.close();
            sis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
       // File file = new File("d:\\14.30_day14总结.avi");
      //  division(file,1024*1024*20);

        try {
            InputStream in1 = new FileInputStream(new File("c:\\test\\1-temp-14.30_day14总结.avi"));
            InputStream in2 = new FileInputStream(new File("c:\\test\\2-temp-14.30_day14总结.avi"));

            //集合工具类，内部实现使用了数组
            Vector<InputStream> v = new Vector();
            v.add(in1);
            v.add(in2);

            Enumeration<InputStream> es = v.elements();//枚举集合
            merge(es);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
