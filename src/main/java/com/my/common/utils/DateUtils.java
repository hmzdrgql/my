package com.my.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static final String CurrentTime = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取当前的时间
	 * @return 2016-05-09 17:33:36
	 */
	public static String getCurrentTime(){
		return new SimpleDateFormat(CurrentTime).format(new Date());
	}
	
	/**
	 * 将当前日期格式化为字符串
	 * return String date  yyyy-MM-dd 00:00:00
	 */
	public static String getDayBegin(){
		return new SimpleDateFormat("yyyy-MM-dd ").format(new Date())+"00:00:00";
	}
	
	/**
	 * 将当前日期格式化为字符串
	 * return String date  yyyy-MM-dd 23:59:59
	 */
	public static String getDayEnd(){
		return new SimpleDateFormat("yyyy-MM-dd ").format(new Date())+"23:59:59";
	}
	
	/**
	 * 返回日期
	 * @param data
	 * @return
	 */
	public static Date stringToData(String data){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
	/**
	 * 计算日期/日
	 * @param time
	 * @param days
	 * @return
	 */
	public static String addDay(String data,int days){
		if(data!=null&&!data.trim().isEmpty()){
			Calendar c = Calendar.getInstance();
			c.setTime(stringToData(data));
			c.add(Calendar.DAY_OF_MONTH, days);
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
		}else{
			return "";
		}
	}
	
	/**
	 * 计算日期/月
	 * @param data
	 * @param month
	 * @return
	 */
	public static String getDealTime(String data,int month){
		if(data!=null&&!data.trim().isEmpty()){
			Calendar c = Calendar.getInstance();
			c.setTime(stringToData(data));
			c.add(Calendar.MONTH, month);
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
		}else{
			return "";
		}
	}
	
	/**
	 * 比较d1是否在d2之前
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean compareDate(String d1,String d2){
		return stringToData(d1).before(stringToData(d2));
	}
	
	public static String getNextMonDayEnd(int i){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		c.add(Calendar.DATE, -1);
		return new SimpleDateFormat("yyyy-MM-dd ").format(c.getTime())+"23:59:59";
	}
	
}
