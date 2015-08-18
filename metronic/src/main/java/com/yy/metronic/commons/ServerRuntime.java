package com.qdhh.clwzglxt.commons;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.lang.SystemUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ServerRuntime {

	private static final int NUMBER_OF_MILLISECONDS_IN_A_DAY = 86400000;

	private static final int NUMBER_OF_MILLISECONDS_IN_AN_HOUR = 3600000;

	private static final int NUMBER_OF_MILLISECONDS_IN_A_MINUTE = 60000;

	private static final int NUMBER_OF_MILLISECONDS_IN_A_SECOND = 1000;

	private static final ServerRuntime currentRuntime = new ServerRuntime();

	public static class SystemRunTimeJsonSerializer extends JsonSerializer<Double> {

		@Override
		public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
			jgen.writeString(calculateUptime(
					value,
					new LinkedList<Integer>(Arrays
							.asList(NUMBER_OF_MILLISECONDS_IN_A_DAY, NUMBER_OF_MILLISECONDS_IN_AN_HOUR, NUMBER_OF_MILLISECONDS_IN_A_MINUTE, NUMBER_OF_MILLISECONDS_IN_A_SECOND, 1)),
					new LinkedList<String>(Arrays.asList("天", "小时", "分钟", "秒", "毫秒"))));
		}

		private String calculateUptime(final double difference, final Queue<Integer> calculations, final Queue<String> labels) {
			if (calculations.isEmpty()) {
				return "";
			}
			final int value = calculations.remove();
			final double time = Math.floor(difference / value);
			final double newDifference = difference - (time * value);
			final String currentLabel = labels.remove();
			return Integer.toString(new Double(time).intValue()) + " " + currentLabel + " " + calculateUptime(newDifference, calculations, labels);

		}

	}

	public static class SystemMemoryJsonSerializer extends JsonSerializer<Long> {

		@Override
		public void serialize(Long value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
			jgen.writeString(value / 1024 / 1024 + "M");
		}

	}

	private Date startTime = new Date();

	public static ServerRuntime getServerRuntime() {
		return currentRuntime;
	}

	private ServerRuntime() {

	}

	@JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "GMT+08:00")
	public Date getStartTime() {
		return startTime;
	}

	@JsonSerialize(using = SystemRunTimeJsonSerializer.class)
	public double getRunTime() {
		return System.currentTimeMillis() - startTime.getTime();
	}

	public long getTotalMemory() {
		return Runtime.getRuntime().totalMemory();
	}

	public long getMaxMemory() {
		return Runtime.getRuntime().maxMemory();
	}

	public long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	public int getAvailableProcessors() {
		return Runtime.getRuntime().availableProcessors();
	}

	public String getJavaRuntimeName() {
		return SystemUtils.JAVA_RUNTIME_NAME;
	}

	public String getJavaRuntimeVersion() {
		return SystemUtils.JAVA_RUNTIME_VERSION;
	}

	public String getJavaVersion() {
		return SystemUtils.JAVA_VERSION;
	}

	public String getOsName() {
		return SystemUtils.OS_NAME;
	}

}
