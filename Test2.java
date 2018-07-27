package com.company;
//继承
public class Test2 {
    public static void main(String[] args){
        ImportCosmeticManager cm=new ImportCosmeticManager();
        cm.add(new Cosmetic("香奈儿","进口",1000));
        cm.add(new Cosmetic("大宝","国产",20));
        cm.add(new Cosmetic("圣罗兰","进口",2000));
        cm.add(new Cosmetic("水密码","国产",200));
        cm.add(new Cosmetic("理肤泉","进口",300));
        cm.printInfo();
      //  System.out.println(ImportCosmeticManager.);
    }
}
//进口输出
class ImportCosmeticManager extends CosmeticManager{
    public  final int DAY_NUMBER;
    public ImportCosmeticManager(){
        DAY_NUMBER=22;
        System.out.println(DAY_NUMBER);

   }
    public void printInfo(){
        for(int i=0;i<count;i++){
            if("进口".equals(cs[i].getType())){
                  System.out.println(cs[i].getInfo());
            }
        }
    }
}
//排序输出
class SortCosmeticManager extends CosmeticManager{
    public void printInfo(){
        //为了不打乱原有数据，创建一个新数组
        Cosmetic[] temp=java.util.Arrays.copyOf(cs,count);
        Cosmetic c=null;//未做实例化
        //表示未申请任何内存资源，即些语句表示声明了一个引用变量并初始化引用,但是该引用没有指向任何对象.但可以把它作为参数传递或其它使用,但是不能调用它作为对象的方法
        for(int i=0;i<temp.length-1;i++)
            for(int j=0;j<temp.length-i-1;j++){
                 if(temp[j].getPrice()>temp[j+1].getPrice()){
                     c=temp[j];
                     temp[j]=temp[j+1];
                     temp[j+1]=c;
                 }
            }
         for(Cosmetic cosmetic: temp){
            System.out.println(cosmetic.getInfo());
         }
    }
}
class CosmeticManager{
    protected Cosmetic[] cs=new Cosmetic[4];
    protected int count=0;

    //进货功能
    public void add(Cosmetic c){
        if(count>=cs.length){
            int newLen=cs.length*2;
            cs=java.util.Arrays.copyOf(cs,newLen);
        }
        cs[count++]=c;
    }

    //输出所有产品
    public void printInfo(){
        for(int i=0;i<count;i++){
            System.out.println(cs[i].getInfo());
        }
    }
}

class Cosmetic{
    private String name;
    private String type;
    private int price;
    public Cosmetic(){}
    public Cosmetic(String name,String type,int price){
        this.name=name;
        this.type=type;
        this.price=price;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public void setprice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
    public String getInfo(){
        return "name:"+name+" type:"+type+" price:"+price;
    }
}