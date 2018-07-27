package com.vince;
//ArrayList
//import java.util.ArrayList;
//import java.util.List;
import java.util.*;
import java.util.Objects;

public class ListDemo {
    private static void arrayList(){
        List<String> list=new ArrayList<>();
        list.add("苍老师");
        list.add("李老师");
        list.add("王老师");
        list.add("毕老师");
        list.add("毕老师");
        int size=list.size();
        for(int i=0;i<size;i++){
            System.out.println(list.get(i));
        }

        String[] array=list.toArray(new String[]{});
        for(String s:array){
            System.out.println(s);
        }
    }
    private static void vector(){
        Vector<String> v=new Vector<>();
        v.add("苍老师");
        v.add("李老师");
        v.add("王老师");
        v.add("毕老师");
        v.add("苍老师");
        int size=v.size();
        for(int i=0;i<size;i++){
            System.out.println(v.get(i));
        }

       String[] array=v .toArray(new String[]{});
       for(String s:array){
          System.out.println(s);
      }

    }
    public static void main(String[] args){
        arrayList();
        vector();//linkedList
    }
}
//链表的实现
/*
    void linkLast(E e){
        final Node<E> l=last;
        final Node<E> newNode=new Node<>(1,e,null);
        last=newNode;
        if(l==null)
        first=newNode;
        else
        l.next=newNode;
        size++;
        modCount++;
 */

