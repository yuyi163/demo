package com.yy.metronic.commons.exception;

import org.springframework.http.HttpStatus;

/**
 * 403锛堝凡绂佹锛� * 
 * @璇存槑 鏈嶅姟鍣ㄦ嫆缁濊姹�鏁版嵁楠岃瘉澶辫触鎴栨病鏈夋潈闄愭椂浣跨敤鍒� */
public class NotAccessException extends BusinessException {

	private static final long serialVersionUID = -2943175981668856137L;

	public NotAccessException() {
		super(HttpStatus.FORBIDDEN, "NOT_ACCESS");
	}

	public NotAccessException(String message) {
		super(HttpStatus.FORBIDDEN, message);
	}

}
