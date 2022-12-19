package com.product.productAggregator.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.product.productAggregator.model.ProductDetailsCSV;
import com.product.productAggregator.model.ProductDetailsDTO;
import com.product.productAggregator.model.ProductDetailsSummaryDTO;
import com.product.productAggregator.service.ProductService;

import io.micrometer.common.util.StringUtils;

@Service
public class ProductServiceImpl implements ProductService {
	
	public static final String PRODUCT_BRAND ="ProductBrand";
	public static final String PRODUCT_LINE ="ProductLine";

	/**
     * getFilteredProducts method receives list of ProductDetailsCSV , filterKey and filterValue
     * based on the filter value the filtered response returns
     * @param   products   the data read from csv file
     * @param filterKey the filter key
     * @param filterValue the filter value
     * @return productDetailsSummaryDTO returns ProductDetailsSummaryDTO .
     */
	@Override
	public ProductDetailsSummaryDTO getFilteredProducts(List<ProductDetailsCSV> products, String filterKey,
			String filterValue) {
		ProductDetailsSummaryDTO detailsSummaryDTO = new ProductDetailsSummaryDTO();
		// Applying Filter based on filter key and value
		if(StringUtils.isNotEmpty(filterValue) && StringUtils.isNotEmpty(filterKey)) {
			// filter based on product brand
			if (PRODUCT_BRAND.equalsIgnoreCase(filterKey)) {
				products = products.stream().filter(p-> filterValue.equalsIgnoreCase(p.getProductBrand())).collect(Collectors.toList());
			} else if(PRODUCT_LINE.equalsIgnoreCase(filterKey)) {
				// filter based on product line
				products = products.stream().filter(p-> filterValue.equalsIgnoreCase(p.getProductLine())).collect(Collectors.toList());
			}  
		}
		// map productDetails to ProductSummaryDTO
		mapProductDetails(detailsSummaryDTO, products);
		return detailsSummaryDTO;
	}

	// map productDetails to ProductSummaryDTO
	private void mapProductDetails(ProductDetailsSummaryDTO detailsSummaryDTO,
			List<ProductDetailsCSV> products) {
		List<ProductDetailsDTO> productDetailsDTOs = new ArrayList<ProductDetailsDTO>();
		for(ProductDetailsCSV productDetailsCSV: products) {
			ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
			// map prduct id
			productDetailsDTO.setProductId(productDetailsCSV.getProductId());
			// map product brand
			productDetailsDTO.setProductBrand(productDetailsCSV.getProductBrand());
			// map product generic
			productDetailsDTO.setProductGeneric(productDetailsCSV.getProductGeneric());
			// map product line
			productDetailsDTO.setProductLine(productDetailsCSV.getProductLine());
			// map product price
			productDetailsDTO.setProductPrice(productDetailsCSV.getProductPrice());
			//  differences between the ‘product generics’ and the ‘product lines’
			productDetailsDTO.setDiffResult(productDetailsCSV.getProductLine().replaceAll(productDetailsCSV.getProductGeneric(), ""));
			productDetailsDTOs.add(productDetailsDTO);
		}
		detailsSummaryDTO.setProductDetailsDTO(productDetailsDTOs);
		List<BigDecimal> bigDecimalsList = products.stream().filter(p ->null !=p.getProductPrice()).map(ProductDetailsCSV :: getProductPrice).collect(Collectors.toList());
		// calculating sum of prices
		detailsSummaryDTO.setPriceSum(
				bigDecimalsList.stream().reduce(BigDecimal.ZERO, (p, q) -> p.add(q)));
	}

}
