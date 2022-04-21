package com.thinkifylab.demo.exception;

public class NoRideFoundException extends RuntimeException implements AppException {

	private static final long serialVersionUID = 14564548713215L;

	public NoRideFoundException(String msg) {
		super(msg);
	}

}
