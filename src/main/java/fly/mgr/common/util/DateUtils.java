package fly.mgr.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @date 2019年9月1日
 */
public class DateUtils {

    /** 时间格式 */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /** 数字时间格式 */
    public final static String DATE_TIME_DIGIT_PATTERN = "yyyyMMddHHmmss";

    private DateUtils() { }

    /**
     * 获取当前时间<br>
     * 格式：yyyy-MM-dd HH:mm:ss
     * 
     * @return String
     */
    public static String getCurrentDate() {
        return getCurrentDate(DATE_TIME_PATTERN);
    }
    
    /**
     * 获取当前时间<br>
     * 格式：yyyyMMddHHmmss
     * 
     * @return String
     */
    public static String getCurrentDateDigit() {
        return getCurrentDate(DATE_TIME_DIGIT_PATTERN);
    }

    /**
     * 获取当前时间
     * 
     * @param format 日期格式
     * @return String
     */
    public static String getCurrentDate(final String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }
    

    /**
     * 字符串转日期
     * 
     * @param dateStr       日期字符串
     * @param pattern       日期格式
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(final String dateStr, final String pattern) throws ParseException {
        SimpleDateFormat simple = new SimpleDateFormat(pattern);
        simple.setLenient(false);  
        return simple.parse(dateStr);  
    }
    
    /**
     * 获取小时后的时间
     * @param date
     * @param hour
     * @return
     */
    public static Date getDateAddHour(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        return cal.getTime();
    }
    
    /**
     * 获取天后的时间
     * @param date
     * @param hour
     * @return
     */
    public static Date getDateAddDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

}
