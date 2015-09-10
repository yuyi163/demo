package com.yy.metronic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yy.metronic.commons.entity.BaseEntity;

@Entity
@Table(name = "yydata")
public class Yydata extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="renderingengine" ,length=255)
	private String RenderingEngine;
	
	@Column(name="browser" ,length=255)
	private String Browser;
	
	@Column(name="platform" ,length=255)
	private String Platform;
	
	@Column(name="engineversion" ,length=255)
	private String EngineVersion;
	
	@Column(name="cssgrade" ,length=255)
	private String 	CSSgrade;

	public String getRenderingEngine() {
		return RenderingEngine;
	}

	public void setRenderingEngine(String renderingEngine) {
		RenderingEngine = renderingEngine;
	}

	public String getBrowser() {
		return Browser;
	}

	public void setBrowser(String browser) {
		Browser = browser;
	}

	public String getPlatform() {
		return Platform;
	}

	public void setPlatform(String platform) {
		Platform = platform;
	}

	public String getEngineVersion() {
		return EngineVersion;
	}

	public void setEngineVersion(String engineVersion) {
		EngineVersion = engineVersion;
	}

	public String getCSSgrade() {
		return CSSgrade;
	}

	public void setCSSgrade(String cSSgrade) {
		CSSgrade = cSSgrade;
	}
	
	
	
}
