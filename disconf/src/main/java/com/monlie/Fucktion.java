package com.monlie;

import com.google.common.base.Function;

public class Fucktion implements Function<Integer, Long> {

    @Override
    public Long apply(Integer integer) {
        return Long.valueOf(integer);
    }

    public static void main(String[] args) {
        System.err.println(new Fucktion().apply(142));
    }
}
