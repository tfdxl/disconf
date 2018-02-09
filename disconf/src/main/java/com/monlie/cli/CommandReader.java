package com.monlie.cli;

import org.apache.commons.cli.*;
import org.junit.platform.commons.util.StringUtils;

public class CommandReader {

    public static void main(String[] args) throws Exception {

        //首先声明一些选项
        final Options options = new Options();
        final Option option = new Option("f", true, "configuration file path");
        options.addOption(option);

        //声明一个命令行参数
        final CommandLineParser parser = new PosixParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {

        }

        String configFilePath = null;
        if (cmd.hasOption("f")) {
            configFilePath = cmd.getOptionValue("f");
            System.err.println("the configuration file path is---> " + configFilePath);
        } else {
            System.err.println("please input the configuration file path by -f option");
            System.exit(1);
        }

        if (StringUtils.isBlank(configFilePath)) {
            throw new Exception("Blank file path");
        }
    }
}
