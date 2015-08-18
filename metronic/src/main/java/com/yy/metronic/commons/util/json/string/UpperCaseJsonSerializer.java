package com.qdhh.clwzglxt.commons.util.json.string;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UpperCaseJsonSerializer extends JsonSerializer<String> {
	@Override
	public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if (value == null) {
			return;
		}
		jgen.writeString(value.toUpperCase());
	}

}