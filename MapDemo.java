package com.vince;

import javax.swing.*;
import java.util.*;

public class MapDemo {
    private static void hashMap(){
        Map<Integer ,String> map=new HashMap<>();
        map.put(1,"Tom");
        map.put(2,"Jack");
        map.put(3,"Lisa");
        map.put(4,"Bin");
        System.out.println("size="+map.size());
        map.get(1);//通过key取value
        //map的遍历
        Set<Map.Entry<Integer,String>> entrySet=map.entrySet();
        for(Map.Entry e:entrySet){
            System.out.println(e.getKey()+"->"+e.getValue());
        }
       //遍历键
        Set<Integer> keys=map.keySet();
        for(Integer i:keys){
            String value=map.get(i);
            System.out.println(i+"->"+value);
        }
        //遍历值
        Collection<String> values=map.values();
        for(String value:values){
            System.out.println(value);
        }
        map.forEach((key,value)->System.out.println(key+"->"+value));
    }
    private static void treeMap(){
        Map<Cat,String> cats=new TreeMap<>();
        cats.put(new Cat("2ha",1,1),"cat1");
        cats.put(new Cat("hhh",3,3),"cat2");
        cats.put(new Cat("www",2,2),"cat3");
        cats.forEach((key,value)->System.out.println(key+"->"+value));
    }
    public static void main(String[] args){
        //hashMap();
        treeMap();
    }
}
