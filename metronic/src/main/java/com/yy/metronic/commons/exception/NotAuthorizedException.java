package com.yy.metronic.commons.exception;

import org.springframework.http.HttpStatus;

/**
 * 401（未授权）
 * 
 * @说明 请求要求进行身份验证。登录后，服务器可能会返回对页面的此响应。
 */
public class NotAuthorizedException extends BusinessException {
	private static final long serialVersionUID = -5300332802397476284L;

	public NotAuthorizedException() {
		super(HttpStatus.UNAUTHORIZED, "NOT_AUTHORIZED");
	}

	public NotAuthorizedException(String message) {
		super(HttpStatus.UNAUTHORIZED, message);
	}

}
