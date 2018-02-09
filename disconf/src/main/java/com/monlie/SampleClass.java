package com.monlie;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;

public class SampleClass {

    public String test(String user) {
        return "hello --> " + user;
    }

    public static void main(String[] args) {
        testHelloWorld();
        testFixedValue();
    }

    static void testHelloWorld() {
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before method run...");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after method run...");
            return result;
        });

        SampleClass sampleClass = (SampleClass) enhancer.create();
        sampleClass.test("monlie");
    }

    public static void testFixedValue() {
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((FixedValue) () -> "hello cglib");
        SampleClass sampleClass = (SampleClass) enhancer.create();
        String s = sampleClass.test("monlie");
        System.err.println("result is " + s);
        System.out.println(sampleClass.toString());
        System.out.println(sampleClass.getClass());
        System.out.println(sampleClass.hashCode());
    }
}
