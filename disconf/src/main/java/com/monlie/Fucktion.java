package com.monlie;

import com.google.common.base.Function;

public class Fucktion implements Function<Integer, Long> {

    @Override
    public Long apply(Integer integer) {
        return Long.valueOf(integer);
    }
}
