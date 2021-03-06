package com.monlie;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Accept.
 */
public final class Accept {

    /**
     * cannot construct.
     */
    private Accept() {
    }

    /**
     * main.
     *
     * @param args fsd.
     */
    public static void main(final String[] args) {
        try {
            ClassLoader c = Thread.currentThread().getContextClassLoader();
            System.err.println(c);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            serverSocketChannel.socket().setReuseAddress(true);
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 10000));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
