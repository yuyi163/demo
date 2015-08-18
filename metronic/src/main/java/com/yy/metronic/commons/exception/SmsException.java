package com.yy.metronic.commons.exception;

public class SmsException extends Exception {
	private static final long serialVersionUID = 1L;

	public SmsException() {
	}

	public SmsException(String message) {
		super(message);
	}

	public SmsException(String message, Throwable rootCause) {
		super(message, rootCause);
	}

	public SmsException(Throwable rootCause) {
		super(rootCause);
	}
}