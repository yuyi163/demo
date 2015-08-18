package com.yy.metronic.commons.exception;

import org.springframework.http.HttpStatus;

/**
 * {@code 404 Not Found}.
 * 
 * @see <a href="http://tools.ietf.org/html/rfc2616#section-10.4.5">HTTP/1.1</a>
 */
public class NotFoundException extends BusinessException {

	private static final long serialVersionUID = -2943175981668856137L;

	public NotFoundException() {
		super(HttpStatus.NOT_FOUND, "NOT_FOUND");
	}

	public NotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

}
