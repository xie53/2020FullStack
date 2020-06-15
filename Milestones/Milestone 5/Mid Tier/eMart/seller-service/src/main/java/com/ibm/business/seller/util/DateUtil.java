package com.ibm.business.seller.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
    public static Timestamp getCurrentTimestap() {
        return new Timestamp(System.currentTimeMillis());
    }
    
	public static String getDateDescriptionWithKanji(Date date) {	
		Calendar c = Calendar.getInstance(Locale.JAPAN);
		c.setTime(date);
		
		StringBuilder sb = new StringBuilder();
		sb.append(c.get(Calendar.YEAR));
		sb.append("年");
		sb.append(c.get(Calendar.MONTH) + 1);
		sb.append("月");
		sb.append(c.get(Calendar.DATE));
		sb.append("日　");
		sb.append(c.get(Calendar.HOUR_OF_DAY));
		sb.append("時");
		sb.append(c.get(Calendar.MINUTE));
		sb.append("分");
		
		return sb.toString();
	}
	
	public static String getYYYYMMDD(Date date) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyyMMdd");
		return yyyyMMddSdf.format(date);
	}
}
