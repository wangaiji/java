package com.company;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class StringStreamDemo {
    private static void stringReader(){
        String info = "good good study day day up";
        StringReader sr = new StringReader(info);
        //流标记器(类)
        StreamTokenizer st = new StreamTokenizer(sr);
        int count = 0;
        while(st.ttype !=StreamTokenizer.TT_EOF){
            try {
                if(st.nextToken()==StreamTokenizer.TT_WORD){
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sr.close();
        System.out.println("count="+count);
    }

    public static void main(String[] args){
        stringReader();
    }
}
