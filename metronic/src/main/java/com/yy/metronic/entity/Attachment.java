package com.yy.metronic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yy.metronic.commons.entity.BaseEntity;

@Entity
@Table(name = "ATTACHMENT")
public class Attachment extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="userid",length=100)
	private String userId;
	
	@Column(name="attachmentname",length=100)
	private String attachmentName;
	
	@Column(name="attachmentpath",length=100)
	private String attachmentPath;
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	
}
