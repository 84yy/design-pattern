package com.hzm.singleton;

/**
 * 懒汉模式
 * 存在弊端 : 非线程安全
 */
public class SingletonLazy {

    private static  SingletonLazy instan = null;

    private String name;

    /**
     * 私有化构造方法
     */
    private SingletonLazy() {
    }

    public String getName() {
        return name;
    }

    public static SingletonLazy getInstance(String name) {
        if (instan == null) {
            SingletonLazy singletonLazy = new SingletonLazy();
            singletonLazy.name = name;
            return singletonLazy;
        }
        return instan;
    }


    public static void main(String[] args) {
        SingletonLazy singletonLazy = SingletonLazy.getInstance("懒汉单例");
        System.out.println(singletonLazy.getName());
    }

}
