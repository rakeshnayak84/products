/**
 * 
 */
package com.product.service;

import java.util.List;

import com.product.dto.ProductDetailsDTO;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
public interface ProductDetailsService {

	public ProductDetailsDTO getProductDetails(long productId);
	
	public List<ProductDetailsDTO> getAllProducts();
}
