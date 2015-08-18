package com.yy.metronic.commons.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static String toJsonString(Object object) {
		try {
			if (object == null) {
				return null;
			}
			return objectMapper.writeValueAsString(object);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static final ObjectMapper objectMapper = createObjectMapper();

	private static ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}

}
