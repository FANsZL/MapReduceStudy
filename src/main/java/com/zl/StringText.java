package com.zl;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class StringText {

    public static byte[] serialize(Writable writable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        writable.write(dataOutputStream);
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) throws IOException {
//        BytesWritable b = new BytesWritable(new byte[]{3,5});
//        byte[] bytes = serialize(b);
//        System.out.println(StringUtils.byteToHexString(bytes));

        System.out.println();
    }
}
