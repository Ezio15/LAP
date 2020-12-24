package com.stg.elap.utils;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	public static boolean checkFileExtension(String fullName,String type) {
	    if(checkNotNull(fullName)) {
	    String fileName = new File(fullName).getName();
	    int dotIndex = fileName.lastIndexOf('.');
	    return (dotIndex == -1) ? false : fileName.substring(dotIndex + 1).equals(type);
	    }
	    return false;
	    }

	public static boolean  checkNotNull(String value) {
		
		if(value!=null)
			return true;
		return false;
		
	}
}
