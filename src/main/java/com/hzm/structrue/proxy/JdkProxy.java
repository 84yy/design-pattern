package com.hzm.structrue.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk+反射实现的动态代理
 */
public class JdkProxy {

    public static CustomerDao getInstance() {
        final CustomerDaoImpl customerDao = new CustomerDaoImpl();
        final Aspect aspect = new Aspect();
        return (CustomerDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), new Class[]{CustomerDao.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                aspect.preInvoke();
                method.invoke(customerDao, args);
                aspect.postInvoke();
                return null;
            }
        });
    }

    public static void main(String[] args) {
        CustomerDao customerDao = JdkProxy.getInstance();
        customerDao.add();
        customerDao.delete();
        customerDao.select();
    }
}
