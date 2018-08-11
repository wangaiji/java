package com.company;

import java.io.*;

public class ObjectStreamDemo {
    private static void writeObject() {
        Dog dog = new Dog("wangwang",2,"nan");
        File file = new File("c:/test/dog.obj");
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);//ObjectInputStream ois
            oos.writeObject(dog);//Dog dog = (Dog)ois.readObject();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args){
        writeObject();
    }
}
