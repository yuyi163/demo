package com.qdhh.clwzglxt.commons.util.json.string;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UpperCaseJsonDeserializer extends JsonDeserializer<String> {

	@Override
	public String deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		return parser.getText() == null ? null : parser.getText().toUpperCase();
	}

}
