package com.monlie.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandReader {

    public static void main(String[] args) {
        final Options options = new Options();
        final Option option = new Option("f",true,"configuration file path");
    }
}
