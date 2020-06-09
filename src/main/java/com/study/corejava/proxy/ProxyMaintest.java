package com.study.corejava.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMaintest {
    public static void main(String[] args) {

//        Class c=Proxy.getProxyClass(HelloWorldService.class.getClassLoader(), HelloWorldService.class);
//
//        System.out.println(c.getName());
//        Method[] ms=c.getMethods();
//        for (int i = 0; i < ms.length; i++) {
//            System.out.println(ms[i].getName());
//        }
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        HelloWorldService helloWorldService1 = new HelloServiceImpl();
        HelloWorldService helloWorldService = (HelloWorldService) Proxy.newProxyInstance(HelloWorldService.class.getClassLoader(), new Class[]{HelloWorldService.class},
                new MyHandler(helloWorldService1));
        helloWorldService.sayHello("123");
    }

}