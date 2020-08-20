package com.fa.utils;

import org.apache.log4j.Logger;

public class LogFactory {
	public static Logger getLogger() {
		return Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
}
