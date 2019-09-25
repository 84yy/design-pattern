package com.hzm.createtype.singleton;

/**
 * 饿汉模式
 * 弊端: 无法根据需要指定个别属性
 */
public class SingletonHungry {


    private static final SingletonHungry SINGLETON_LAZY = new SingletonHungry("饿汉单例");

    private String name;


    public String getName() {
        return name;
    }

    private SingletonHungry(String name) {
        this.name = name;
    }

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return SINGLETON_LAZY;
    }


    public static void main(String[] args) {
        SingletonHungry singletonHungry = SingletonHungry.getInstance();
        System.out.println(singletonHungry.getName());
    }

}
