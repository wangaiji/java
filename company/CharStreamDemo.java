package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharStreamDemo {
    private static void out()  {
        File file = new File("c:\\test\\vince.txt");
        Writer out = null;
        try {
            out = new FileWriter(file,true);
            out.write(",村花到我家");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        out();
    }
}

