package com.fa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static Date convertString(String strDate) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date = df.parse(strDate);	
			return date;
	}
}
