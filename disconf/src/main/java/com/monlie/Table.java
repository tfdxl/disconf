package com.monlie;

import org.apache.kafka.clients.admin.ConfigEntry;

public class Table<T> {

    private Object[] values;
    //元素的个数
    private int size;

    public void insert(T value) {
        if (values == null) {
            values = new Object[1];
        }

        //扩张
        if (size == values.length) {
            Object[] newValues = new Object[size * 2];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }

        values[size] = value;
        size++;
    }

    public static void main(String[] args) {
        Table<String> table = new Table<>();
        table.insert("test");

        ConfigEntry configEntry = new ConfigEntry("tianfeng", "monlie");
        System.err.println(configEntry.isDefault());
        System.err.println(configEntry);
    }
}
