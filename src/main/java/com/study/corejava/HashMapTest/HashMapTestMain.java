package com.study.corejava.HashMapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTestMain {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(4);
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.size());
        map.put(3, 3);
        map.put(4, 4);
        System.out.println(map.size());

        TestHashChongTu hashChongTu1 = new TestHashChongTu();
        TestHashChongTu hashChongTu2 = new TestHashChongTu();
        TestHashChongTu hashChongTu3 = new TestHashChongTu();
        TestHashChongTu hashChongTu4 = new TestHashChongTu();
        TestHashChongTu hashChongTu5 = new TestHashChongTu();
        TestHashChongTu hashChongTu6 = new TestHashChongTu();
        TestHashChongTu hashChongTu7 = new TestHashChongTu();
        TestHashChongTu hashChongTu8 = new TestHashChongTu();
        TestHashChongTu hashChongTu9 = new TestHashChongTu();
        TestHashChongTu hashChongTu0 = new TestHashChongTu();


        System.out.println(hashChongTu1.hashCode()+"   "+hashChongTu2.hashCode());
        HashMap<TestHashChongTu, TestHashChongTu> mapTestHash = new HashMap<>();
        mapTestHash.put(hashChongTu1,hashChongTu1);
        mapTestHash.put(hashChongTu2, hashChongTu2);
        mapTestHash.put(hashChongTu3, hashChongTu3);
        mapTestHash.put(hashChongTu4, hashChongTu4);
        mapTestHash.put(hashChongTu5, hashChongTu5);
        mapTestHash.put(hashChongTu6, hashChongTu6);
        mapTestHash.put(hashChongTu7, hashChongTu7);
        mapTestHash.put(hashChongTu8, hashChongTu8);
        mapTestHash.put(hashChongTu9, hashChongTu9);
        mapTestHash.put(hashChongTu0, hashChongTu0);

//        ConcurrentHashMap





        Object a=new Object();
        System.out.println(a.hashCode());

        // 16-1 二进制
        // 0000 0000 0000 0000 0000 0000 0000 1111
        // 0010 0011 1111 1100 0110 0010 0101 1110
        // 如果只是将哈希值直接使用并且与容量-1进行 与运算得到结果是
        // 0000 0000 0000 0000 0000 0000 0000 1110
        //这样其实就是直接把我们高位的信息直接丢了。
        //然而如果先进行无符号右移16位，再进行异或运算，就将高16和低16进行了混合
        //这样高16位的特征也会使用到，在两个哈希值非常接近的时候就会减少哈希碰撞

        // 我们如果可以设定17作为容量,那么17-1的二进制就是       16为初始容量
        // 0000 0000 0000 0000 0000 0000 0001 0000           0000 0000 0000 0000 0000 0000 0000 1111
        // hash1
        // 0010 0011 1111 1100 0100 0001 1010 0010           0010 0011 1111 1100 0100 0001 1010 0010
        // 0000 0000 0000 0000 0000 0000 0001 0000           0000 0000 0000 0000 0000 0000 0000 1111
        // hash1 & (17-1)
        // 0000 0000 0000 0000 0000 0000 0000 0000           0000 0000 0000 0000 0000 0000 0000 0010

        // hash2
        // 0010 1011 1111 1100 0100 0001 1010 0010           0010 1011 1111 1100 0100 0001 1010 0010
        // 0000 0000 0000 0000 0000 0000 0001 0000           0000 0000 0000 0000 0000 0000 0000 1111
        // hash2 & (17-1)
        // 0000 0000 0000 0000 0000 0000 0000 0000           0000 0000 0000 0000 0000 0000 0000 0010

        // hash3
        // 0010 1011 1111 1100 0100 0001 1010 1010           0010 1011 1111 1100 0100 0001 1010 1010
        // 0000 0000 0000 0000 0000 0000 0001 0000           0000 0000 0000 0000 0000 0000 0000 1111
        // hash3 & (17-1)
        // 0000 0000 0000 0000 0000 0000 0000 0000           0000 0000 0000 0000 0000 0000 0000 1010

    }
}
