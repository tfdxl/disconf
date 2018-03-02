package com.monlie;

import org.apache.kafka.common.utils.Java;

public class JavaTest {
    public static void main(String[] args) {
        System.err.println(Java.isIbmJdk());
        System.err.println(System.getProperty("java.vendor"));
    }
}
