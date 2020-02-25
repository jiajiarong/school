package com.rt.ecps.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ECPSUtils {
	
	public static String getProp(String key) {
		String value= "";
		Properties p = new Properties();
		InputStream is = ECPSUtils.class.getClassLoader().getResourceAsStream("ecps_prop.properties");
		try {
			p.load(is);
			value = p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
