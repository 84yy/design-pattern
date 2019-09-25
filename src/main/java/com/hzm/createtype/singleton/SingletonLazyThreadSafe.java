package com.hzm.createtype.singleton;

/**
 * 线程安全得懒汉模式
 */
public class SingletonLazyThreadSafe {

    private static SingletonLazyThreadSafe instan = null;

    private String name;

    /**
     * 私有化构造方法
     */
    private SingletonLazyThreadSafe() {
    }

    public String getName() {
        return name;
    }

    public static SingletonLazyThreadSafe getInstance(String name) {
        if (instan == null) {
            synchronized (SingletonLazyThreadSafe.class) {
                if (instan == null) {
                    instan = new SingletonLazyThreadSafe();
                    instan.name = name;
                }
            }
            return instan;
        }
        return instan;
    }


    public static void main(String[] args) {
        SingletonLazyThreadSafe singletonLazy = SingletonLazyThreadSafe.getInstance("懒汉单例");
        System.out.println(singletonLazy.getName());
    }

}
