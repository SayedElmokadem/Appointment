package com.stc.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Util {

	public String convertDateToDateString(Date date) {

	    return new SimpleDateFormat("yyyy-M-d").format(date);

	}

	public String convertDateStringToSpecificFormat(String date) {

		//String strDate = new SimpleDateFormat("yyyy-mm-dd").format(date);

		return date;

	}
}
