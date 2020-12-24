package com.stg.elap.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

public class Constants {

	public static final String SECRETS_PROPS_PATH = "/secrets.properties";
	public static final int STRENGTH = 10;
	public final static class SecureConst {
		public static final String VENDOR_SIGNUP = "/register";
		public static final String VENDOR_LOGIN = "/login";
		public static final String PASSWORD_RESET_REQUEST_URL = "/users/forgotPwd";
		public static final String PASSWORD_RESET_URL = "/users/resetPwd";
		public static final int EXPIRATION_TIME = 7200000;
		public static final String TOKEN_PREFIX = "token_prefix";
		public static final String HEADER_STRING = "token_header";
		public static final String TOKEN_SECRET = "token_secret";
		public static final int PWD_EXPIRATION_TIME = 36000000; //1 day
		public static final String RESET_PWD_TOKEN_SECRET = "token_reset_pwd";
		
		
		
	}



}
