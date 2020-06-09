package com.study.corejava.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clzz= String.class;
        Method[] methods=clzz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
//        TestClass str =  Class.forName("com.study.corejava.reflect.TestClass");
    }
}
