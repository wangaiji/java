package com.company;
//继承
public class Test {
    public static void main(String[] args) {
        HomeDog homedog = new HomeDog("xiaoxiao");
       homedog.print();
       // HomeDog homedog1=new HomeDog();
       homedog.eat();

    }
}
class Dog {
    protected String name;
    protected String sex;
    public  Dog()
    {
        System.out.println("我是dog的构造方法");
    }
    public  Dog(String name,String sex)
    {
        this.name=name;
        this.sex=sex;
        System.out.println("我是dog1的构造方法");
    }
    public void eat()
    {
        System.out.println("吃饭");
    }
}
class HomeDog extends Dog {
    public  HomeDog(String name){
        super(name,"公");
        System.out.println("我是HomeDog的构造方法");
    }
    public void print()
    {
        System.out.println(name + sex+"我是一只家狗");
    }
    public void eat(){
        super.eat();
        System.out.println("我是家狗，我吃骨头");
    }
}

class HuskyDog extends Dog {
    //public  HuskyDog(String name){
    //    super(name,"公");
        //System.out.println("我是HomeDog的构造方法");
   // }
    public void show()
    {
        System.out.println(name + "我能跳舞");
    }
}



