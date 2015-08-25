package com.yy.metronic.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.yy.metronic.commons.entity.BaseEntity;

@Entity
@Table(name="usermeta")
public class UserMeta extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public static final String NAME_IMAGE = "image";
	
	@Column(name = "userid",length = 50)
	private String userId;

	@Column(name = "metaname",length = 50)
	private String metaName;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "metaContent",columnDefinition = "LONGTEXT")
	private String content;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMetaName() {
		return metaName;
	}

	public void setMetaName(String metaName) {
		this.metaName = metaName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
