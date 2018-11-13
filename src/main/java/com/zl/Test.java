package com.zl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        dateFormat.format(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.MONTH, -3);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        System.out.println(dateFormat.format(calendar.getTime()));

    }
}
