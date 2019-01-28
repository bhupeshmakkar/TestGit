package com.DairyFarm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compwebsites")
public class CompWebSites implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompWebSites(Integer id, String compWebSitesName) {
		super();
		this.id = id;
		this.compWebSitesName = compWebSitesName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "compwebsitesname")
	private String compWebSitesName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompWebSitesName() {
		return compWebSitesName;
	}

	public void setCompWebSitesName(String compWebSitesName) {
		this.compWebSitesName = compWebSitesName;
	}

}
