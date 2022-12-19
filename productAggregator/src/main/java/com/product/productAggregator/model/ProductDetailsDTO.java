package com.product.productAggregator.model;

import java.math.BigDecimal;

public class ProductDetailsDTO {
	
	private long productId;
	
	private String productBrand;
	
	private String productLine;
	
	private String productGeneric;
	
	private BigDecimal productPrice;
	
	private String diffResult;
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductGeneric() {
		return productGeneric;
	}

	public void setProductGeneric(String productGeneric) {
		this.productGeneric = productGeneric;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getDiffResult() {
		return diffResult;
	}

	public void setDiffResult(String diffResult) {
		this.diffResult = diffResult;
	}
}
