package com.DairyFarm.Bean;

public class CommonBean {
	private Integer categoryId;
	private String categoryName;
	private Integer productId;
	private Integer status;
	private String productName;
	private String webSitePP;
	private String compWebSitePP;
	private String varience;
	private Integer tanentId;
	private String date;

	public CommonBean() {
	}
	
	public CommonBean(String categoryName, String productName, String webSitePP, String compWebSitePP, String varience,
			String date) {
		super();
		this.categoryName = categoryName;
		this.productName = productName;
		this.webSitePP = webSitePP;
		this.compWebSitePP = compWebSitePP;
		this.varience = varience;
		this.date = date;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getWebSitePP() {
		return webSitePP;
	}

	public void setWebSitePP(String webSitePP) {
		this.webSitePP = webSitePP;
	}

	public String getCompWebSitePP() {
		return compWebSitePP;
	}

	public void setCompWebSitePP(String compWebSitePP) {
		this.compWebSitePP = compWebSitePP;
	}

	public String getVarience() {
		return varience;
	}

	public void setVarience(String varience) {
		this.varience = varience;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTanentId() {
		return tanentId;
	}

	public void setTanentId(Integer tanentId) {
		this.tanentId = tanentId;
	}

}
