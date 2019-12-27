/**
 * 
 */
package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductReviewRepository;
import com.product.dto.ProductReviewDTO;
import com.product.entity.ProductDetails;
import com.product.entity.ProductReview;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@Service
public class ProductReviewServiceImpl implements ProductReviewService{
	
	@Autowired
	private ProductReviewRepository productReviewRepository;
	
	
	public List<ProductReviewDTO> getProductReviews(long productId) {
		
		ProductDetails productDetails = new ProductDetails();
		productDetails.setProductId(productId);
		
		List<ProductReviewDTO> productReviewDtoList = new ArrayList<ProductReviewDTO>();
		List<ProductReview> productReviews = null;
		ProductReviewDTO productReviewDTO = null;
		
		productReviews = productReviewRepository.findByProductDetails(productDetails);
		
		for (ProductReview productReview : productReviews) {
			productReviewDTO = new ProductReviewDTO();
			BeanUtils.copyProperties(productReview, productReviewDTO);	
			productReviewDTO.setProductId(productReview.getProductDetails().getProductId());
			productReviewDtoList.add(productReviewDTO);
		}
		
		return productReviewDtoList;
		
	}
	
}
