/*
 * Created on Oct 12, 2014
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author Vichrak
 *
 */
public class DateUtils {

    public static String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    public static String FORMDATE_TIME = "dd/MM/yyyy HH:mm";

    /**
     * @param dateString
     * @return {@link Date}
     */
    public static Date getDate(final String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        else {
            final DateTimeFormatter formatter = DateTimeFormat.forPattern(DEFAULT_DATE_FORMAT);
            final DateTime dt = formatter.parseDateTime(dateString);
            return dt.toDate();
        }
    }

    public static Date getDate(final String dateString, final String format) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        else {
            final DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
            final DateTime dt = formatter.parseDateTime(dateString);
            return dt.toDate();
        }
    }

    @SuppressWarnings("deprecation")
    public static Date getDateTime(final String dateString, final String format) {
        final Date date = getDate(dateString, format);
        if (date == null) {
            return null;
        }
        final Date currDate = new Date();
        date.setHours(currDate.getHours());
        date.setMinutes(currDate.getMinutes());
        date.setSeconds(currDate.getSeconds());
        return date;
    }

    /**
     * @param date
     * @return {@link String}
     */
    public static String getDateLabel(final Date date) {
        if (date != null) {
            final DateTimeFormatter formatter = DateTimeFormat.forPattern(DEFAULT_DATE_FORMAT);
            final DateTime dt = new DateTime(date);
            return formatter.print(dt);
        }
        else {
            return StringUtils.EMPTY;
        }
    }

    public static String getDateCurrenceLabel() {
        final DateTimeFormatter formatter = DateTimeFormat.forPattern(FORMDATE_TIME);
        final Date currentDate = new Date();
        final DateTime dt = new DateTime(currentDate);
        return formatter.print(dt);
    }

    public static String getDateTimeLabel(final Date date) {
        final DateTimeFormatter formatter = DateTimeFormat.forPattern(FORMDATE_TIME);
        final DateTime dt = new DateTime(date);
        return formatter.print(dt);
    }

    /**
     * @return {@link String}
     */
    public static String getShortCurrentYear() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yy");
        return sdf.format(Calendar.getInstance().getTime());
    }

    public static String getDefaultTargetDateLabel(final String date) {
        final String[] splitValue = date.split("/");
        String targetDateLabel = "";
        for (int index = splitValue.length - 1; index >= 0; index--) {
            targetDateLabel = targetDateLabel + splitValue[index];
            if (index > 0) {
                targetDateLabel = targetDateLabel + "-";
            }
        }
        return targetDateLabel;
    }

    /**
     * get date beginning of day (dd/mm/yyyy 00:00:00)
     * @param date
     * @return {@link Date}
     */
    public static Date getDateAtBeginningOfDay(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * get date end of day (dd/mm/yyyy 23:59:59)
     * @param date
     * @return {@link Date}
     */
    public static Date getDateAtEndOfDay(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(getDateAtBeginningOfDay(date));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime();
    }
}
