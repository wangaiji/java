package com.company;
//模板方法模式
public class Test5 {
    public static void main(String[] args){
        UserManager um=new UserManager();
        um.action("poor","add");
    }
}

abstract class BaseManager{
    public void action(String name,String method){
        if("admin".equals(name)){
            execute(method);
        }else{
            System.out.println("你没有权限");
        }
    }
    public abstract void execute(String method);
}
class UserManager extends BaseManager{
    public void execute(String method){
        if("add".equals(method)){
            System.out.println("执行了添加操作");
        }else if("del".equals(method)){
            System.out.println("执行了删除操作");
        }
    }
}