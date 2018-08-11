package com.vince;
//装饰者模式
public class Test {
    public static void main(String[] args){
        Drink drink = new SoyaBeanMilk();
        SugarDecorator sugar = new SugarDecorator(drink);
        BlackBeanDecorator blackbean = new BlackBeanDecorator(sugar);
        System.out.println("你点的豆浆是："+blackbean.description());
        System.out.println("花了："+blackbean.cost());

    }
}
