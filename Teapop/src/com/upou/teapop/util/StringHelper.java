package com.upou.teapop.util;

public class StringHelper {
	
	public static int stringToInt(String val) {
		if(val.equalsIgnoreCase("")){
			return 0;
		} else {
			return Integer.parseInt(val);
		}
	}

}
