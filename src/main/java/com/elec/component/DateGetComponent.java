package com.elec.component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateGetComponent {
    public static String getCurrentDate(){
        Calendar calendar = Calendar.getInstance(); // get current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(calendar.getTime());
        return date;
    }
    public static String getYesterdayDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(new Date());

        calendar.add(calendar.DATE,-1);

        String date2= simpleDateFormat.format(calendar.getTime());
        return date2;
    }

}
