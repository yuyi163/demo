package com.yy.metronic.commons.exception;

import org.springframework.http.HttpStatus;

/**
 * 500锛堟湇鍔″櫒鍐呴儴閿欒锛� * 
 * @璇存槑 鏈嶅姟鍣ㄩ亣鍒伴敊璇紝鏃犳硶瀹屾垚璇锋眰銆� */
public class InternalServerErrorException extends BusinessException {

	private static final long serialVersionUID = -2943175981668856137L;

	public InternalServerErrorException() {
		super(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");
	}

	public InternalServerErrorException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}

	public InternalServerErrorException(String message, Throwable cause) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
	}

	public InternalServerErrorException(Throwable cause) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, cause);
	}
}
