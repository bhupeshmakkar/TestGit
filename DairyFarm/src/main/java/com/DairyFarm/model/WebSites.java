package com.DairyFarm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_websites")
public class WebSites implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebSites() {}
	public WebSites(Integer id, String webSitesName) {
		super();
		this.id = id;
		this.webSitesName = webSitesName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "site_id")
	private Integer id;

	@Column(name = "site_name")
	private String webSitesName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWebSitesName() {
		return webSitesName;
	}

	public void setWebSitesName(String webSitesName) {
		this.webSitesName = webSitesName;
	}

}
