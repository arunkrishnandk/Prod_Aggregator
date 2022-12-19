package com.product.productAggregator.model;

import java.math.BigDecimal;
import java.util.List;

public class ProductDetailsSummaryDTO {
	
	private List<ProductDetailsDTO> productDetailsDTO;
	
	private BigDecimal priceSum;

	public List<ProductDetailsDTO> getProductDetailsDTO() {
		return productDetailsDTO;
	}

	public void setProductDetailsDTO(List<ProductDetailsDTO> productDetailsDTO) {
		this.productDetailsDTO = productDetailsDTO;
	}

	public BigDecimal getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(BigDecimal priceSum) {
		this.priceSum = priceSum;
	}

}
