package com.monlie;

import java.util.Random;

/**
 * ThreadLocalRandom类是JDK7在JUC包下新增的随机数生成器，它
 * 解决了Random类在多线程下多个线程竞争内部唯一的原子性种子变量而导致大量线程自旋重试的不足
 */
public class RandomTest {

    public static void main(String[] args) {
        //1.创建一个默认种子的随机数生成器
        final Random random = new Random();
        //2.输出10个在0-5之间的随机数
        for (int i = 0; i < 10; i++) {
            System.err.println(random.nextInt(5));
        }
    }
}
