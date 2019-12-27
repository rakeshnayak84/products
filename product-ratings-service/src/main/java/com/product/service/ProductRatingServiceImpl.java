/**
 * 
 */
package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductRatingRepository;
import com.product.dto.ProductRatingDTO;
import com.product.entity.ProductDetails;
import com.product.entity.ProductRating;
import com.product.entity.ProductReview;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@Service
public class ProductRatingServiceImpl implements ProductRatingService{
	
	@Autowired
	private ProductRatingRepository productRatingRepository;
	
	
	public List<ProductRatingDTO> getProductRatings(long productId) {
		
		ProductDetails productDetails = new ProductDetails();
		productDetails.setProductId(productId);
		
		List<ProductRatingDTO> productRatingDtoList = new ArrayList<ProductRatingDTO>();
		List<ProductRating> productRatings = null;
		ProductRatingDTO productRatingDTO = null;
		
		productRatings = productRatingRepository.findByProductDetails(productDetails);
		
		for (ProductRating productRating : productRatings) {
			productRatingDTO = new ProductRatingDTO();
			BeanUtils.copyProperties(productRating, productRatingDTO);	
			productRatingDTO.setProductId(productRating.getProductDetails().getProductId());
			productRatingDTO.setReviewId(productRating.getProductReview().getReviewId());
			productRatingDtoList.add(productRatingDTO);
		}
		
		return productRatingDtoList;		
	}
	
	public ProductRatingDTO getReviewRating(long reviewId) {
		
		ProductReview productReview = new ProductReview();
		productReview.setReviewId(reviewId);
		
		ProductRating productRating = null;
		ProductRatingDTO productRatingDTO = new ProductRatingDTO();
		
		productRating = productRatingRepository.findByProductReview(productReview);
		
		BeanUtils.copyProperties(productRating, productRatingDTO);	
		productRatingDTO.setProductId(productRating.getProductDetails().getProductId());
		productRatingDTO.setReviewId(productRating.getProductReview().getReviewId());
		
		return productRatingDTO;
	}
}
