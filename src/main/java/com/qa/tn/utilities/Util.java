package com.qa.tn.utilities;

import java.util.Date;

public class Util {

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String emailDateTimeStamp = date.toString().replace(" ", ":").replace(":", "_");
		return "seleniumpanda" + emailDateTimeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 20;
	public static final int SCRIPT_TIME = 1000;
}
