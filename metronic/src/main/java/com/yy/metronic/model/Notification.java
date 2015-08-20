package com.yy.metronic.model;

import java.io.Serializable;

public class Notification implements Serializable {

	private static final long serialVersionUID = -6551267585799840237L;
	private String title;
	private String message;
	private String uri;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
