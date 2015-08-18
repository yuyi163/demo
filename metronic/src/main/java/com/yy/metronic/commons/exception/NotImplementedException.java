package com.yy.metronic.commons.exception;

import org.springframework.http.HttpStatus;

/**
 * 501（尚未实施）
 * 
 * @说明 服务器不具备完成请求的功能。例如，当服务器无法识别请求方法时，服务器可能会返回此代码。
 */
public class NotImplementedException extends BusinessException {

	private static final long serialVersionUID = -2943175981668856137L;

	public NotImplementedException() {
		super(HttpStatus.NOT_IMPLEMENTED, "NOT_IMPLEMENTED");
	}

	public NotImplementedException(String message) {
		super(HttpStatus.NOT_IMPLEMENTED, message);
	}

}
