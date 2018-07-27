package com.company;
//继承抽象类
public class Test4 {
    public static void main(String[] args){
        Chicken hc=new HomeChicken("doudou");
        Chicken yc=new YeChicken("fangfang");

        eat(hc);
        eat(yc);//野鸡和家鸡是同一级
     }
      //面对抽象编程
     public static void eat(Chicken c){
        System.out.println("鸡吃饭");
        c.eat();

        if(c instanceof HomeChicken){ //成立的条件：对象本身及对象的父类型，都可以通过检查
            HomeChicken hc=(HomeChicken)c;
            hc.eat();
        }
     }
}



abstract class Chicken{
    private String name;
    public Chicken(){}
    public Chicken(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public abstract void eat();
}


class HomeChicken extends Chicken{
    public HomeChicken(String name){
        super(name);//
    }
    public void eat(){
        System.out.println(this.getName()+"我爱吃米");
    }
}

class YeChicken extends Chicken{
    public YeChicken(String name){
       super(name);//this.name=name
    }
    public void eat(){
        System.out.println(this.getName()+"我爱吃虫");
    }
}