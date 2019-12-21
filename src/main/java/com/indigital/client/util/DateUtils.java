package com.indigital.client.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtils {

    public static Date formatDate(String pattern, String dateString) {
        try {
            return new SimpleDateFormat(pattern).parse(dateString);
        } catch (ParseException e) {
            log.error("can't convert string to date : " + e.getMessage(), e);
            return null;
        }
    }


    public static String getStringFromDate(String pattern, Date date) {
        return new SimpleDateFormat(pattern).format(date);
    }


}
