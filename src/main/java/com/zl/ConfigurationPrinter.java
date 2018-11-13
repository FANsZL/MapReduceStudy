package com.zl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.Map;

public class ConfigurationPrinter extends Configured implements Tool {


    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = getConf();
        if(conf == null){
            System.out.println("conf is null");
        }else {
            System.out.println("conf is not null");
        }
        for(Map.Entry<String, String> entry : conf){
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        ToolRunner.run(new ConfigurationPrinter(), args);
    }
}
