package com.danieleautizi.restapi.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.log4j.Logger;

public class DateUtil {

    private static final Logger logger = Logger.getLogger(DateUtil.class);

    public static String DATE_PATTERN = "dd/MM/yyyy";
    public static String DATE_PATTERN_EN = "MM/dd/yyyy";
    public static String DATE_TIME_PATTERN_SS = "dd/MM/yyyy HH:mm:ss";
    public static String DATE_TIME_PATTERN_W = "dd/MM/yyyy HH:mm";

    public static String DATE_TIME_PATTERN_EN_SS = "MM/dd/yyyy HH:mm:ss";
    public static String DATE_TIME_PATTERN_EN_MM = "MM/dd/yyyy HH:mm";
    public static String DATE_TIME_PATTERN_EN_DAY = "MM/dd/yyyy";

    public static String DATE_DB_PATTERN = "yyyyMMdd";
    public static String DATE_TIME_DB_PATTERN = "yyyyMMdd HH:mm:ss";

    public static String TIME_PATTERN = "HH:mm:ss";
    public static String TIME_PATTERN_HH_MM = "HH:mm";
    public static String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public static String DATE_ALL_PATTERN  = "EEE MMM dd HH:mm:ss ZZ yyyy";
    public static String DATE_CET_PATTERN  = "EEE MMM dd HH:mm:ss zzz yyyy";

    public static String DATE_PATTERN_MYSQL    = "yyyy-MM-dd";

    public static String DATE_PATTERN_M        = "yyyyMddHHmmss";
    public static String DATE_PATTERN_M_FORMAT = "yyyyMMddHHmmss";

    public static String MYSQL_DB_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String MYSQL_DB_DATE_PATTERN_DAY = "yyyy-MM-dd";

    public static String CALENDAR_DB_DATE_PATTERN = "yyyy-MM-dd HH:mm";

    public DateUtil() {}

    public static long getMillisFromString(String pattern, String date) {
        long millis = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date d = sdf.parse(date);
            millis = d.getTime();
        } catch (ParseException e) {
            logger.error(e);
            throw new RuntimeException("Failure in getting millis by date ["+date+"], with pattern ["+pattern+"]");
        }
        return millis;
    }

    public static String convertDateStringFormat(String viewFormattedDate, String outgoingPattern){
        String formattedDate = null;
        SimpleDateFormat outgoingDateFormat = new SimpleDateFormat(outgoingPattern);
        try {
            formattedDate = outgoingDateFormat.format(convertStringToDate(DATE_PATTERN,viewFormattedDate));
        } catch (ParseException e) {
            logger.error(e);
            throw new RuntimeException("Formato inatteso della data ["+viewFormattedDate+"]. Il formato atteso e' gg/mm/aaaa");
        }
        return formattedDate;
    }

    public static String convertDateStringFormat(String date, String inPattern, String outPattern){
        String formattedDate = null;
        SimpleDateFormat outgoingDateFormat = new SimpleDateFormat(outPattern);
        try {
            formattedDate = outgoingDateFormat.format(convertStringToDate(inPattern,date));
        } catch (ParseException e) {
            logger.error(e);
            throw new RuntimeException("Formato inatteso della data ["+date+"]. Il formato atteso e' "+inPattern);
        }
        return formattedDate;
    }

    public static String convertDateStringFormat(String date, String inPattern, String outPattern, Locale local){
        String formattedDate = null;
        SimpleDateFormat outgoingDateFormat = new SimpleDateFormat(outPattern,local);
        try {
            formattedDate = outgoingDateFormat.format(convertStringToDate(inPattern,date,local));
        } catch (ParseException e) {
        logger.error(e);
            throw new RuntimeException("Formato inatteso della data ["+date+"]. Il formato atteso e' "+inPattern);
        }
        return formattedDate;
    }

    public static Calendar convertStringToCalendar(String strDate, String pattern) {
        Calendar c = null;

        try {
            Date d = convertStringToDate(pattern, strDate);
            c = new GregorianCalendar();
            c.setTime(d);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return c;
    }

    /**
     * This method converts a String to a timestamp using the datePattern
     *
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     *
     * @throws ParseException
     */
    public static Timestamp convertStringToTimestamp(String strTs, String pattern) throws ParseException {
        Timestamp t = null;

        try {
            t = new Timestamp(convertStringToDate(pattern, strTs).getTime());
        } catch (ParseException pe) {
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return t;
    }

    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method generates a string representation of a date
     * in the format you specify on input
     *
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        if (aDate != null) {
            return getDateTime(DATE_PATTERN, aDate);
        } else {
            return "";
        }
    }

    public static final String convertDateToString(Date aDate, String pattern) {
        return getDateTime(pattern, aDate);
    }

    public static final String convertTimestampToString(Timestamp aTimestamp,
        String pattern) {
        if (aTimestamp != null) {
            return convertDateToString(new Date(aTimestamp.getTime()), pattern);
        } else {
            return "";
        }
    }

    public static final String convertTimestampToString(Timestamp aTimestamp) {
        if (aTimestamp != null) {
            return convertDateToString(new Date(aTimestamp.getTime()));
        } else {
            return "";
        }
    }

    public static final String convertCalendarToString(Calendar c,
        String pattern) {
        if (c != null) {
            return convertDateToString(c.getTime(), pattern);
        } else {
            return "";
        }
    }

    public static final String convertCalendarToString(Calendar c) {
        if (c != null) {
            return convertDateToString(c.getTime());
        } else {
            return "";
        }
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     *
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    // FUNZIONE PER LA CONVERSIONE DELLA DATA dal formato from al formato to
    public static String formatDate(String date, String fromPattern, String toPattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(fromPattern);
            Date d = sdf.parse(date);
            sdf = new SimpleDateFormat(toPattern);
            return sdf.format(d);
        } catch(Exception e) {
            return "";
        }
    }

    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate, Locale local)
        throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask,local);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    public static String formatBaseDate(Date date, String format) {
        String output = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            output = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static Integer getDaysInMonth(Calendar date, Integer year, Integer month) {
        Integer days = 0;
        if (null != date) {
            // Get the number of days in that month
            days = date.getActualMaximum(Calendar.DAY_OF_MONTH);
        } else {
            // Create a calendar object and set year and moth
            Calendar mycal = new GregorianCalendar(year, month, 1);
            // Get the number of days in that month
            days = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        return days;
    }


}
