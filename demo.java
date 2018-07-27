package com.company;

public class demo {

        public static void main(String[] args) {
            Student student=new Student("xiaoxiao",3);
            System.out.println(Student.name+" "+student.getAge());
            Score score=new Score(78,89);

            student.setScore(score);
            score.setStudent(student);

            String name=student.getName();
            int age=student.getAge();
            Score s=student.getScore();
            System.out.println("我是"+name+" 年龄"+age+" 分数："+s.getYuwen()+" "+s.getShuxue());
          //  int result=d.sum(10,20);
            // System.out.println(result);
        }
}
class Student{
    static String name;
    private int age;
    private Score score;
    public void setScore(Score score){
        this.score=score;
    }
    public Score getScore(){
        return score;
    }
    public Student(){}
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

}

class Score{
    private int yuwen ;
    private int shuxue;
    private Student student;
    public void setStudent(Student student){
        this.student=student;
    }
    public Student getStudent(){
        return student;
    }
    public Score(){}
    public Score(int yuwen,int shuxue){
        this.yuwen=yuwen;
        this.shuxue=shuxue;
    }
    public int getYuwen(){
        return yuwen;
    }
    public int getShuxue(){
        return shuxue;
    }

}