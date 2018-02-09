package com.monlie;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    //测试规模
    private static final int TEST_SIZE = 10000000;

    //客户线程数目
    private static final int THREAD_COUNT = 10;

    private int n = 0;

    private AtomicInteger ai = new AtomicInteger(0);

    private long startTime;

    private static CountDownLatch cdl = new CountDownLatch(THREAD_COUNT + 1);

    /**
     * 使用AtomicInteger.getAndIncrement，测试结果为1.8比1.7有明显性能提升*
     *
     * @return
     */
    private final synchronized int getAndIncrementA() {
        int res = ai.getAndIncrement();
        System.err.println("now is " + res);
        if (res == TEST_SIZE) {
            System.err.println(System.nanoTime() - startTime);
            System.exit(0);
        }
        return res;
    }

    private final int getAndIncrementB() {
        int res;
        synchronized (this) {
            res = n++;
        }
        if (res == TEST_SIZE) {
            System.err.println(System.nanoTime() - startTime);
            System.exit(0);
        }
        return res;
    }

    private final int getAndIncrementC() {
        int res;
        do {
            res = ai.get();
        } while (!ai.compareAndSet(res, res + 1));
        if (res == TEST_SIZE) {
            System.err.println(System.nanoTime() - startTime);
            System.exit(0);
        }
        return res;
    }

    public class MyTask implements Runnable {

        @Override
        public void run() {
            cdl.countDown();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true)
                AtomicTest.this.getAndIncrementA();
        }
    }

    public void init() {
        startTime = System.nanoTime();
    }

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(atomicTest.new MyTask()).start();
        }
        System.err.println("start ... ");
        atomicTest.init();
        cdl.countDown();
    }
}
