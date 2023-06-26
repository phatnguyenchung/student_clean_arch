package com.example.studentcleanarch.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateTimeUtils {
    public static final String DATE_FORMAT_dd_MM_yyyy = "dd/MM/yyyy";
    public static final String yyyyMMd = "yyyyMMdd";
    public static final String DATETIME_FORMAT_WITH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static Date current() {
        return new Date();
    }

    public static Calendar getCurrentDate() {
        return Calendar.getInstance();
    }

    public static Date timestampAdd(Date timestamp, long interval) {
        return new Date(timestamp.getTime() + interval);
    }

    public static Date toDate(LocalDate localDate) {
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        return Date.from(zonedDateTime.toInstant());
    }

    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date parseDate(String dateString) {
        return parseDate(dateString, DATE_FORMAT_dd_MM_yyyy);
    }

    public static Date parseDate(String dateString, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            log.warn("Cannot parse {} with format {}", dateString, format);
        }
        return null;
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(date.getTime()));
        return cal.get(Calendar.YEAR);
    }

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static Date plusYear(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(date.getTime()));
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    public static int getDiffYears(Date date1, Date date2) {
        return getYear(date2) - getYear(date1);
    }
}
