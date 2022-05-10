package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.exception;

import java.io.ByteArrayOutputStream;

public class GlobalExceptionHandler {
	// Stack information is printed as follows
	public static String getThrowableStackInfo(Throwable e) {
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		e.printStackTrace(new java.io.PrintWriter(buf, true));
		String msg = buf.toString();
		try {
			buf.close();
		} catch (Exception t) {
			return e.getMessage();
		}
		return msg;
	}
}
