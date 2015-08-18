package com.yy.metronic.commons.exception;

/**
 * 401锛堢櫥闄嗙敤鎴疯繛鎺ユ湇鍔″櫒瓒呮椂锛� * 
 * @璇存槑 璇锋眰瑕佹眰杩涜韬唤楠岃瘉銆傜櫥褰曞悗锛屾湇鍔″櫒鍙兘浼氳繑鍥炲椤甸潰鐨勬鍝嶅簲銆� */
public class LoginTimeoutException extends NotAuthorizedException {
	private static final long serialVersionUID = 1L;

	public LoginTimeoutException() {
		super("LOGIN_TIMEOUT");
	}

}
