package com.monlie.cglib;

import net.sf.cglib.reflect.MulticastDelegate;

public class SimpleMulticastBean implements DelegationProvider {

    private String value;

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        MulticastDelegate multicastDelegate = MulticastDelegate.create(DelegationProvider.class);
        SimpleMulticastBean first = new SimpleMulticastBean();
        SimpleMulticastBean second = new SimpleMulticastBean();

        multicastDelegate = multicastDelegate.add(first);
        multicastDelegate = multicastDelegate.add(second);
        DelegationProvider provider = (DelegationProvider) multicastDelegate;
        provider.setValue("tianfeng");

        System.err.println(first.getValue());
        System.err.println(second.getValue());
    }
}
