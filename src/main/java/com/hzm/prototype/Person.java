package com.hzm.prototype;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person implements Cloneable {

    private String name;

    private Dog dog;

    private Cat cat;


    /**
     * 注意深克隆跟浅克隆得区别以及影响
     * 浅克隆 : 对引用类型是共享引用得指针地址
     * 深克隆: 对引用类型属性是clone一个相同得对象
     * 参考: https://www.jianshu.com/p/b597f3e8269a
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person personClone = (Person) super.clone();
        personClone.dog = (Dog) this.dog.clone();
        personClone.cat = (Cat) this.cat.clone();
        return personClone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Dog dog = new Dog();
        dog.setColor("黑色");
        Cat cat = new Cat();
        cat.setSex("雌性");
        person.setDog(dog);
        person.setCat(cat);
        person.setName("小明");
        System.out.println(person);
        Person clone = (Person) person.clone();
        System.out.println(clone);
        System.out.println(person == clone);

        System.out.println(person.getDog() == clone.getDog());
        System.out.println(person.getCat() == clone.getCat());
    }
}


@Data
@ToString
class Dog implements Cloneable {


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String color;


}

@Data
@ToString
class Cat implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String sex;
}