/*
 * Copyright (c) 2016, 2017, HappyBus and/or its affiliates. All rights reserved.
 * HppayBus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.water.can.token;

import java.util.Random;

/**
 * This class is Generate the Token using the userId.
 * @author Srinu R
 * @version 1.0
 */
public class TokenGenerator {

	/**
	 * this method generate token string
	 * @param userId
	 * @return token
	 */
	public static final String getToken(Long userId)
	{
		return "Happy"+userId+new Random().nextInt(1000000);
	}

	public static String getToken(Integer userId) {
		return "Happy"+userId+new Random().nextInt(1000000);
	}
	
}
