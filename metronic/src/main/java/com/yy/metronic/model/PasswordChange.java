package com.yy.metronic.model;

import java.io.Serializable;

public class PasswordChange implements Serializable {

	private static final long serialVersionUID = 7579297040642701290L;

	private String oldPassword;
	private String newPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
