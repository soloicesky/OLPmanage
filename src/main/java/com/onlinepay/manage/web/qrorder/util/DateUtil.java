package com.onlinepay.manage.web.qrorder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期时间工具类
 * 
 * @author magenm
 * 
 */
public class DateUtil {
	private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private static final SimpleDateFormat dateFormatzh = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
	private static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");

	
	public static String currentyyyyMMddHHmmss(){
		return yyyyMMddHHmmss.format(now());
	}
	/**
	 * 获得当前日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentDatetime() {
		return datetimeFormat.format(now());
	}

	/**
	 * 格式化日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatDatetime(Date date) {
		return datetimeFormat.format(date);
	}

	/**
	 * 格式化日期时间
	 * 
	 * @param date
	 * @param pattern
	 *            格式化模式，详见{@link SimpleDateFormat}构造器
	 *            <code>SimpleDateFormat(String pattern)</code>
	 * @return
	 */
	public static String formatDatetime(Date date, String pattern) {
		SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat.clone();
		customFormat.applyPattern(pattern);
		return customFormat.format(date);
	}

	/**
	 * 获得当前日期
	 * <p>
	 * 日期格式yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String currentDate() {
		return dateFormat.format(now());
	}

	/**
	 * 格式化日期
	 * <p>
	 * 日期格式yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 格式化日期
	 * <p>
	 * 日期格式yyyy年MM月dd日 hh时mm分
	 * 
	 * @return
	 */
	public static String formatDateZh(Date date) {
		return dateFormatzh.format(date);
	}

	/**
	 * 获得当前时间
	 * <p>
	 * 时间格式HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTime() {
		return timeFormat.format(now());
	}

	/**
	 * 格式化时间
	 * <p>
	 * 时间格式HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatTime(Date date) {
		return timeFormat.format(date);
	}

	/**
	 * 获得当前时间的<code>java.util.Date</code>对象
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	public static Calendar calendar() {
		Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		return cal;
	}

	public static Date dateAdd(String dateTimeStr, int timeField, int v) {
		try {
			Date d = parseDatetime(dateTimeStr);
			Calendar c = calendar();
			c.setTime(d);
			c.add(timeField, v);

			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获得当前时间的毫秒数
	 * <p>
	 * 详见{@link System#currentTimeMillis()}
	 * 
	 * @return
	 */
	public static long millis() {
		return System.currentTimeMillis();
	}

	/**
	 * 
	 * 获得当前Chinese月份
	 * 
	 * @return
	 */
	public static int month() {
		return calendar().get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得月份中的第几天
	 * 
	 * @return
	 */
	public static int dayOfMonth() {
		return calendar().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 今天是星期的第几天
	 * 
	 * @return
	 */
	public static int dayOfWeek() {
		return calendar().get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 今天是年中的第几天
	 * 
	 * @return
	 */
	public static int dayOfYear() {
		return calendar().get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 判断原日期是否在目标日期之前
	 * 
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isBefore(Date src, Date dst) {
		return src.before(dst);
	}

	/**
	 * 判断原日期是否在目标日期之后
	 * 
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isAfter(Date src, Date dst) {
		return src.after(dst);
	}

	/**
	 * 判断两日期是否相同
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isEqual(Date date1, Date date2) {
		return date1.compareTo(date2) == 0;
	}

	/**
	 * 判断某个日期是否在某个日期范围
	 * 
	 * @param beginDate
	 *            日期范围开始
	 * @param endDate
	 *            日期范围结束
	 * @param src
	 *            需要判断的日期
	 * @return
	 */
	public static boolean between(Date beginDate, Date endDate, Date src) {
		return beginDate.before(src) && endDate.after(src);
	}

	/**
	 * 获得当前月的最后一天
	 * <p>
	 * HH:mm:ss为0，毫秒为999
	 * 
	 * @return
	 */
	public static Date lastDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
		cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
		return cal.getTime();
	}

	/**
	 * 获得当前月的第一天
	 * <p>
	 * HH:mm:ss SS为零
	 * 
	 * @return
	 */
	public static Date firstDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		return cal.getTime();
	}

	private static Date weekDay(int week) {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_WEEK, week);
		return cal.getTime();
	}

	/**
	 * 获得周五日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 * 
	 * @return
	 */
	public static Date friday() {
		return weekDay(Calendar.FRIDAY);
	}

	/**
	 * 获得周六日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 * 
	 * @return
	 */
	public static Date saturday() {
		return weekDay(Calendar.SATURDAY);
	}

	/**
	 * 获得周日日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 * 
	 * @return
	 */
	public static Date sunday() {
		return weekDay(Calendar.SUNDAY);
	}

	/**
	 * 将字符串日期时间转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param datetime
	 * @return
	 */
	public static Date parseDatetime(String datetime) throws ParseException {
		return datetimeFormat.parse(datetime);
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 时间格式 HH:mm:ss
	 * 
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTime(String time) throws ParseException {
		return timeFormat.parse(time);
	}

	/**
	 * 根据自定义pattern将字符串日期转换成java.util.Date类型
	 * 
	 * @param datetime
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDatetime(String datetime, String pattern) throws ParseException {
		SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
		format.applyPattern(pattern);
		return format.parse(datetime);
	}

	/**
	 * 获取当前系统时间
	 * <p>
	 * 自定义格式
	 * 
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static String currDate(String pattern) {
		return formatDatetime(new Date(), pattern);
	}

	/**
	 * 获取当前系统时间
	 * <p>
	 * 简单格式 yyyy-MM-dd
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static String currDate() throws ParseException {
		return formatDatetime(new Date(), "yyyy-MM-dd");
	}

	public static String fromatRFC1123(Date date) {
		String RFC1123_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss zzz";
		SimpleDateFormat dateFormat = new SimpleDateFormat(RFC1123_DATE_PATTERN, Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return dateFormat.format(date);
	}

	/**
	 * 获得当前系统的后一天，格式为 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getNextDay() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获得当前系统的后n天，格式为 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getNextDay(int n) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, n);
		date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获得当前系统的后n天，格式为 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getNextDay(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, n);
		date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获得当前系统的前一天，格式为 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getPrevDay() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获得当前系统的前n天，格式为 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getPrevDay(int n) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -n);
		date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获取两个日期之间的每一天
	 * 
	 * @author maomao
	 * @date 2015年7月15日 下午3:31:24
	 * @param start
	 * @param end
	 * @param calendarType
	 * @return
	 */
	public static Date[] getDateArrays(Date start, Date end, int calendarType) {
		ArrayList<Date> ret = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		Date tmpDate = calendar.getTime();
		long endTime = end.getTime();
		while (tmpDate.before(end) || tmpDate.getTime() == endTime) {
			ret.add(calendar.getTime());
			calendar.add(calendarType, 1);
			tmpDate = calendar.getTime();
		}

		Date[] dates = new Date[ret.size()];
		return ret.toArray(dates);
	}

	/**
	 * 获取本周第一天
	 * 
	 * @date 2016年4月13日 下午3:06:17
	 * @return
	 */
	public static Date getFirstDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return calendar.getTime();
	}

	/**
	 * 查询日期星期几，注意：周日：返回0
	 * 
	 * @date 2016年4月13日 下午3:06:17
	 * @return
	 */
	public static int getWeekOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}
}
