package com.product.productAggregator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.productAggregator.model.ProductDetailsCSV;
import com.product.productAggregator.model.ProductDetailsSummaryDTO;

@Service
public interface ProductService {

	ProductDetailsSummaryDTO getFilteredProducts(List<ProductDetailsCSV> products, String filterKey, String filterValue);

}
