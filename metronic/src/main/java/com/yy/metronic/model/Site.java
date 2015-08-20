package com.yy.metronic.model;

import java.io.Serializable;

public class Site implements Serializable {

	private static final long serialVersionUID = -5869835441905396800L;

	public static final String SITE_NAME = "siteName";
	/**
	 * 站点名称
	 */
	private String siteName;

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

}
