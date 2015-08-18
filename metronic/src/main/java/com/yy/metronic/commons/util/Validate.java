package com.yy.metronic.commons.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yy.metronic.commons.exception.NotAccessException;




public final class Validate {
	private static final Logger log = Logger.getLogger(Validate.class);

	private static void fail(String message) {
		throw new NotAccessException(message);
	}

	private static void fail(String message, Object expected, Object actual) {
		if (log.isDebugEnabled()) {
			String formatted = "";
			if (message != null)
				formatted = message + " ";
			log.debug(formatted + "expected:<" + expected + "> but was:<" + actual + ">");
		}
		fail(message);
	}

	public static void isTrue(String message, boolean condition) {
		if (!condition)
			fail(message);
	}

	public static void isTrue(boolean condition) {
		isTrue(null, condition);
	}

	public static void isFalse(String message, boolean condition) {
		isTrue(message, !condition);
	}

	public static void isFalse(boolean condition) {
		isFalse(null, condition);
	}

	public static void isEquals(String message, Object expected, Object actual) {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual)) {
			return;
		} else {
			fail(message, expected, actual);
			return;
		}
	}

	public static void isEquals(Object expected, Object actual) {
		isEquals(((String) (null)), expected, actual);
	}

	public static void isNotEquals(String message, Object expected, Object actual) {
		if (expected == null && actual == null) {
			fail(message, expected, actual);
			return;
		}
		if (expected != null && expected.equals(actual)) {
			fail(message, expected, actual);
			return;
		} else {
			return;
		}
	}

	public static void isNotEquals(Object expected, Object actual) {
		isNotEquals(((String) (null)), expected, actual);
	}

	public static void isEmpty(String message, String str) {
		isTrue(message, StringUtils.isEmpty(str));
	}

	public static void isEmpty(String str) {
		isEmpty(null, str);
	}

	public static void isNotEmpty(String message, String str) {
		isTrue(message, StringUtils.isNotEmpty(str));
	}

	public static void isNotEmpty(String str) {
		isNotEmpty(null, str);
	}

	public static void isNull(String message, Object object) {
		isTrue(message, object == null);
	}

	public static void isNull(Object object) {
		isNull(null, object);
	}

	public static void isNotNull(String message, Object object) {
		isTrue(message, object != null);
	}

	public static void isNotNull(Object object) {
		isNotNull(null, object);
	}
}
