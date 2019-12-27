/**
 * 
 */
package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDetailsRepository;
import com.product.dto.ProductDetailsDTO;
import com.product.entity.ProductDetails;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@Service
public class ProductDetailsServiceImpl implements ProductDetailsService{
	
	@Autowired
	private ProductDetailsRepository productDetailsRepository;

	public ProductDetailsDTO getProductDetails(long productId) {
		ProductDetails productDetails = null;
		ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
		
		productDetails = productDetailsRepository.findByProductId(productId);
		BeanUtils.copyProperties(productDetails, productDetailsDTO);
		
		return productDetailsDTO;
	}

	
	public List<ProductDetailsDTO> getAllProducts() {
		
		List<ProductDetailsDTO> productDetailsDTOList = new ArrayList<ProductDetailsDTO>();
		List<ProductDetails> productDetailsList = null;
		ProductDetailsDTO productDetailsDTO = null;
		
		productDetailsList = productDetailsRepository.findAll();
		
		for (ProductDetails productDetails : productDetailsList) {
			productDetailsDTO = new ProductDetailsDTO();
			BeanUtils.copyProperties(productDetails, productDetailsDTO);	
			productDetailsDTOList.add(productDetailsDTO);
		}
		
		return productDetailsDTOList;
	}
}
