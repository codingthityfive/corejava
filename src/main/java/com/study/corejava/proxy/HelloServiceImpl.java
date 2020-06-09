package com.study.corejava.proxy;

public class HelloServiceImpl implements HelloWorldService {

    @Override
    public void sayHello(String name) {
        System.out.println("hello "+name);
    }
}
