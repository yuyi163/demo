package com.yy.metronic.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yy.metronic.commons.entity.BaseEntity;

@Entity
@Table(name = "USER")
public class User extends BaseEntity implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum Status {
		/**
		 * 已过期
		 */
		EXPIRED,
		/**
		 * 已锁定
		 */
		LOCKED,
		/**
		 * 已启用
		 */
		ENABLED
	}
	
	@Column(name = "MOBILEPHONE", length = 100)
	private String mobilePhone;
	
	@Column(name = "EMAIL", length = 50)
	private String email;
	
	@Column(name = "USERNAME", length = 100)
	private String username;
	
	@Column(name = "PASSWORD", length = 100)
	private String password;
	
	@Column(name = "STATUS", length = 50)
	private Status status;

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

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>();
	}
	
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return Status.EXPIRED != status;
	}

	public boolean isAccountNonLocked() {
		return Status.LOCKED != status;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return Status.ENABLED != status;
	}
	

}
