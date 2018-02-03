package com.monlie;

/**
 * java虚拟机会为每一个类型维护一个常量池
 */
public class App {
    public static void main(String[] args) {

        Object o = new Object();
        System.err.println(o);
        boolean e = ("a" + "b" + "c").intern() == "abc";
        System.err.println(e);
        System.out.println("Hello World!");
    }
}
