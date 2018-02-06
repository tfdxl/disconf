package com.monlie;

import java.nio.ByteBuffer;

public final class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocate(1024);
        System.err.println(b);
        b.put("abc".getBytes());
        System.err.println(b);
        b.flip();
        System.err.println(b);
        b.rewind();
        System.err.println(b);
    }
}
