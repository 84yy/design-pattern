package com.hzm.createtype.prototype;

public class Realizetype implements Cloneable {

    Realizetype() {
        System.out.println("具体原型创建成功...");
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("具体对象克隆成功");
        return (Realizetype) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype1 = new Realizetype();
        Realizetype realizetype2 = (Realizetype) realizetype1.clone();
        System.out.println("re1 == re2 " + (realizetype1 == realizetype2));
    }
}
