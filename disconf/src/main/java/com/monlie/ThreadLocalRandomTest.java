package com.monlie;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    public static void main(String[] args) {

        //获取一个随机数发生器
       final  ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.err.println(threadLocalRandom.nextInt(5));
        }
    }
}
