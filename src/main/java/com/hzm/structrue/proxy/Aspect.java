package com.hzm.structrue.proxy;

public class Aspect {
    void preInvoke() {
        System.out.println("前置增强...");
    }

    void postInvoke() {
        System.out.println("后置增强...");
    }
}
