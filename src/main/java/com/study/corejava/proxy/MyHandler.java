package com.study.corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {




    private final Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("zai fun :"+method.getName()+" zhiqian  rini"+ args[0]);

        return method.invoke(target,args);
    }
}
