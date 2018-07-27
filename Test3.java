package com.company;
//抽象类  参数式匿名内部类
public class Test3 {
    public static void main(String[] args){
        Man man=new Man();
        //参数式匿名内部类
        man.print3(new Eat(){
            public void eat(){
                System.out.println("吃饭");
            }
        });
    }
}
abstract class Animal{
    public abstract void move();
}

abstract class Person extends Animal{
    public abstract void eat();
    public void sleep(){
        System.out.println("睡觉");
    }
}
interface Eat{
    public abstract void eat();
}
class Man extends Person{
    public void print3(Eat eat){
        eat.eat();
    }
    public void move(){
        System.out.println("我爱跑步");
    }
    public void eat(){
        System.out.println("我爱吃肉");
    }
}