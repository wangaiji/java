package com.vince;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//集合的输出（迭代）
public class IteratorDemo {
    private static void iterator(Collection<Cat> c){
        Iterator<Cat> iter=c.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public static void main(String[] args) {
        List<Cat> list = new ArrayList<>();
        Cat c1 = new Cat("miaomiao", 5, 1);
        Cat c2 = new Cat("huahua", 7, 2);
        Cat c3 = new Cat("xiaoxiao", 7, 8);
        Cat c4 = new Cat("miaomiao", 5, 1);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        //iterator(list);
        foreach();
    }
    private static void foreach(){
        List<String> list =new ArrayList<>();
        list.add("tom");
        list.add("jack");
        list.add("job");
        list.add("lily");
        list.forEach(s->System.out.println(s));//Consumer接口
        list.forEach(System.out::println);
    }
}
