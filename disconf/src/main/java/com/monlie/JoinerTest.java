package com.monlie;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class JoinerTest {

    public static void main(String[] args) {

        //------------Joiner---------
        final Joiner j = Joiner.on(',').skipNulls();
        String joined = j.join("tianfeng", null, "monlie");
        System.err.println(joined);

        //----------splitter----------
        Iterable<String> it = Splitter.on(";").trimResults().omitEmptyStrings().split("tianfeng;null;;   monlie");
        it.forEach(s -> System.err.println(s));
    }
}
