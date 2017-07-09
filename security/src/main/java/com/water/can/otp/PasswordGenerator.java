package com.water.can.otp;

import org.apache.commons.lang.RandomStringUtils;

public class PasswordGenerator {
	
	/**
	 * This method generate  Alphanumeric String 
	 * @return  String
	 */
	public static String generatePassword(){
	return 	RandomStringUtils.randomAlphanumeric(6);
	}
}
