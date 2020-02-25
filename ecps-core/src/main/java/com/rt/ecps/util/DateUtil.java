package com.rt.ecps.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	
	public String dateToString(Date date){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
		String str=sdf.format(date);
		
		return str;
	}
	
	
	public String getUserId(){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date(); 
		String str=sdf.format(date);
		return str;
	}

}
