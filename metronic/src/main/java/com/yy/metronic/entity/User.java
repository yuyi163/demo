package com.yy.metronic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yy.metronic.commons.entity.BaseEntity;

@Entity
@Table(name = "USER")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "MOBILEPHONE", length = 100)
	private String mobilePhone;
	
	@Column(name = "EMAIL", length = 50)
	private String email;
	
	@Column(name = "USERNAME", length = 100)
	private String username;
	
	@Column(name = "PASSWORD", length = 100)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
