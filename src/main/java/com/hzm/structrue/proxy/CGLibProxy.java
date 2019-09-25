package com.hzm.structrue.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用spring 的cglib实现的动态代理
 */
public class CGLibProxy {

    public static CustomerDao getInstance() {
        final CustomerDaoImpl customerDao = new CustomerDaoImpl();
        final Aspect aspect = new Aspect();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(customerDao.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                aspect.preInvoke();
                Object invoke = method.invoke(customerDao, objects);
                aspect.postInvoke();
                return invoke;
            }
        });
        return (CustomerDao) enhancer.create();
    }

    public static void main(String[] args) {
        CustomerDao instance = getInstance();
        instance.select();
    }
}
