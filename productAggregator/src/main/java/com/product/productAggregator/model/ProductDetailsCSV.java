package com.product.productAggregator.model;

import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByName;

public class ProductDetailsCSV {
	
	@CsvBindByName(column = "product_id")
	private long productId;
	
	@CsvBindByName(column = "product_brand")
	private String productBrand;
	
	@CsvBindByName(column = "product_line")
	private String productLine;
	
	@CsvBindByName(column = "product_generic")
	private String productGeneric;
	
	@CsvBindByName(column = "product_price")
	private BigDecimal productPrice;
	
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



}
