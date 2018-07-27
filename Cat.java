package com.vince;
import java.util.Objects;
public class Cat implements Comparable<Cat> {
    private String name;
    private int age;
    private int id;

    @Override
    public int compareTo(Cat o) {
        return this.id-o.id;C
    }

    public Cat(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age &&
                id == cat.id &&
                Objects.equals(name, cat.name);
    }

  /* @Override
   public int hashCode() {
       final int prime=31;
        int result=1;
        result=prime*result+age;
        result=prime*result+id;
        result=prime*result+((name==null)?0:name.hashCode());
        return  result;
    }

*/
   @Override
   public int hashCode() {

      return Objects.hash(name, age, id);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
