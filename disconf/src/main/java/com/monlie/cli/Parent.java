package com.monlie.cli;

public abstract class Parent {

    static {
        System.err.println("This is in parent");
    }

    public Parent() {
        System.err.println("This is parent constructor");
    }
}
