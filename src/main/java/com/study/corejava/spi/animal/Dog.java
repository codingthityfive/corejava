package com.study.corejava.spi.animal;

import com.study.corejava.spi.Ishout;

public class Dog implements Ishout {

    @Override
    public void shout() {
        System.out.println("wangwang");
    }
}
