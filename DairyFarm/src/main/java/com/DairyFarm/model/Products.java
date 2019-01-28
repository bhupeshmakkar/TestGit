package com.DairyFarm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "m_product")
public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Products() {
	}

	public Products(Integer id, String productName) {
		super();
		this.id = id;
		this.productName = productName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prd_id")
	private Integer id;

	@Column(name = "prd_name")
	private String productName;

	@Column(name = "prd_cat_id")
	private Integer category;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}


}
