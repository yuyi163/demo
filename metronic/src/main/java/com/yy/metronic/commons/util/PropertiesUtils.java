package com.yy.metronic.commons.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 获取系统*.properties文件处理类
 */
public class PropertiesUtils {

	private static final Logger log = Logger.getLogger(PropertiesUtils.class);

	private PropertiesUtils() {
	}

	/**
	 * 根据文件路径获取*.properties文件
	 * 
	 * @param filePath
	 * @return Properties
	 * @throws IOException
	 */
	public static Properties getProperties(String filePath) throws IOException {
		try {
			Properties props = new Properties();
			props.load(PropertiesUtils.class.getResourceAsStream(filePath));
			return props;
		} catch (IOException e) {
			log.error("找不到对应的配置文件！");
			throw e;
		}
	}
}
