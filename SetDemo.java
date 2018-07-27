package com.vince;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        hashSet();
        treeSet();
    }
    public static void hashSet() {
        Cat c1 = new Cat("miaomiao", 5, 1);
        Cat c2 = new Cat("huahua", 4, 3);
        Cat c3 = new Cat("shasha", 3, 2);
        Cat c4 = new Cat("miaomiao", 5, 1);
        Set<Cat> cats = new HashSet<>();//自定义对象
        cats.add(c1);
        cats.add(c2);
        cats.add(c3);
        cats.add(c4);
        System.out.println(cats.size());
        for (Cat c : cats) {
            System.out.println(c);//重写了hashCode和equals方法 没有重写hashCode的话，哈希值不同;重写了hashCode没重写equals的话还是可以添加成功
        }
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());//c1和c4的哈希值相同
        System.out.println(c1 == c4);

        String v1 = "苍老师";
        String v2 = "白老师";
        String v3 = "薛老师";
        String v4 = "苍老师";

        Set<String> v = new HashSet<>();
        v.add(v1);
        v.add(v2);
        v.add(v3);
        v.add(v4);
      //  v.add("苍老师");
     //   for (String s : v) {
      //      System.out.println(s.hashCode());
     //   }
        System.out.println(v1.hashCode());
        System.out.println(v2.hashCode());
        System.out.println(v3.hashCode());
        System.out.println(v4.hashCode());//哈希值相同
        System.out.println(v1 == v4);//地址值相同
    }
    private static void treeSet(){
        TreeSet<Cat> tree=new TreeSet<>(new CatComparator());//括号里是Comparator<Cat> comparator
        Cat c1=new Cat("miaomiao",5,1);
        Cat c2=new Cat("huahua",7,2);
        Cat c3=new Cat("xiaoxiao",7,8);
        Cat c4=new Cat("miaomiao",5,1);
        tree.add(c1);
        tree.add(c2);
        tree.add(c3);
        tree.add(c4);
        for(Cat cats:tree){
            System.out.println(cats);
        }
    }
}
