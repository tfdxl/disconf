package com.monlie;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MySerializer implements Serializer<MySerializer.Student> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Student data) {
        return new byte[0];
    }

    @Override
    public void close() {

    }

    static class Student {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
