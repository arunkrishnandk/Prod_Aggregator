package com.product.productAggregator.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBeanBuilder;
import com.product.productAggregator.model.ProductDetailsCSV;
import com.product.productAggregator.model.ProductDetailsSummaryDTO;
import com.product.productAggregator.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	/**
     * getProductDetails endpoint receives a csv file, filterKey and filterValue
     * based on the filter value the filtered response returns
     * @param   file   the csv file
     * @param filterKey the filter key
     * @param filterValue the filter value
     * @return productDetailsSummaryDTO returns ProductDetailsSummaryDTO .
     */
	@PostMapping(value = "productDetails")
	public ProductDetailsSummaryDTO getProductDetails(@RequestParam("file") MultipartFile file,
			@RequestParam("filterKey") String filterKey, @RequestParam("filterValue") String filterValue)
			throws IllegalStateException, IOException {
		ProductDetailsSummaryDTO productSummary = new ProductDetailsSummaryDTO();
		if (!file.isEmpty()) {
			try {

				BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
				//  Reading to bean ProductDetailsCSV from csv file using opencsv  
				List<ProductDetailsCSV> products = new CsvToBeanBuilder(fileReader).withType(ProductDetailsCSV.class).build()
						.parse();
				if(CollectionUtils.isNotEmpty(products)) {
					
					productSummary = productService.getFilteredProducts(products, filterKey, filterValue);
				}
				fileReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		return productSummary;

	}
}
