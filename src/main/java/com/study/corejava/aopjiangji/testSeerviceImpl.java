package com.study.corejava.aopjiangji;

import org.springframework.stereotype.Service;


@Service
public class testSeerviceImpl implements TestService{
    @AnnSelf(value = "clc", name = "name")
    @Override
    public void test() {
        System.out.println("iamtest");
    }
}
