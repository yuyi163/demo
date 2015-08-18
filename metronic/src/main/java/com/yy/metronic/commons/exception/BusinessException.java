package com.yy.metronic.commons.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 6631653622620471284L;
	private HttpStatus status = HttpStatus.BAD_REQUEST;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(HttpStatus status) {
		super();
		this.status = status;
	}

	public BusinessException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public BusinessException(HttpStatus status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}

	public BusinessException(HttpStatus status, Throwable cause) {
		super(cause);
		this.status = status;
	}

}
