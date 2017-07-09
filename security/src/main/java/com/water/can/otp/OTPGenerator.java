/*
 * Copyright (c) 2016, 2017, Water-Can and/or its affiliates. All rights reserved.
 * HppayBus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.water.can.otp;

import java.util.Random;

/**
 * This class is Generating the integer number OTP
 * @author Srinu R
 * @version 1.0
 */
public class OTPGenerator {
	public static Integer generateOTP(){
		
		/*int randomPIN = (int)(Math.random()*9000)+1000;
		return randomPIN; (OR)*/
		Random generator = new Random();
		int randomNumber = generator.nextInt(8999)+ 1000;
	return randomNumber;
	}

}
