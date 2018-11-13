package com.zl;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.net.URI;


public class SequenceFileWriteDemo {
    private static final String[] DATA = {
            "one, two, buckle my shoe",
            "three, four, shut the door",
            "five, six, pick up sticks",
            "seven, eight, lay them straight",
            "nine, ten, a big fat hen"
    };
    public static void main(String[] args) throws IOException {
        String uri = "hdfs://localhost/numbers.seq";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        Path path = new Path(uri);
        SequenceFile.Writer writer = null;

        IntWritable key = new IntWritable();
        Text value = new Text();
        //fs.create(path);
        try {
            writer = SequenceFile.createWriter(fs, conf, path, key.getClass(), value.getClass());
            for(int i=0; i<100; i++){
                key.set(100-i);
                value.set(DATA[i % DATA.length]);
                writer.append(key, value);
            }

        }finally {
            IOUtils.closeStream(writer);
        }
    }
}
