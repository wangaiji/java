package com.company;
//接口应用之策略设计模式
public class Test6 {
    public static void main(String[] args){
        BaseService user=new UserService();
        user.setISave(new NetSave());//ISave isave=new FileSave()
        user.add("user");
    }
}

//把可变行为抽象出来，定义一系列的算法
interface ISave{
    public void save(String data);
}

class FileSave implements ISave{
    public void save(String data){
        System.out.println("把数据保存到文件中..."+data);
    }
}
class NetSave implements ISave{
    public void save(String data){
        System.out.println("把数据保存到网络上..."+data);
    }
}

abstract class BaseService{
    private ISave isave;//把接口作为类的一个属性；多用组合
    public void setISave(ISave isave){
        this.isave=isave;
    }
    public void add(String data){
        System.out.println("检查数据合法性");
        isave.save(data);//调用方法 多用组合
        System.out.println("数据保存完毕");
    }
  //  public abstract void eat();
}

class UserService extends BaseService{

}