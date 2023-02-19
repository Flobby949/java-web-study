package top.flobby.book.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-19 10:27
 **/

public class DateUtil {

    /**
     * LocalDateTime转换时间字符串
     * @param date date
     * @return string
     */
    public static String dateFormat(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(date);
    }
}
