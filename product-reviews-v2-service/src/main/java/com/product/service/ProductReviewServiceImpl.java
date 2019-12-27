/**
 * 
 */
package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.dao.ProductReviewRepository;
import com.product.dto.ProductRatingDTO;
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
		
		RestTemplate restTemplate = new RestTemplate();
		final String ratingByreviewIdSvcUri = "http://localhost:8082/reviewRating/";
		
		productReviews = productReviewRepository.findByProductDetails(productDetails);
		
		for (ProductReview productReview : productReviews) {
			productReviewDTO = new ProductReviewDTO();
			BeanUtils.copyProperties(productReview, productReviewDTO);	
			productReviewDTO.setProductId(productReview.getProductDetails().getProductId());
			
			ProductRatingDTO productRatingDTO = restTemplate.getForObject(ratingByreviewIdSvcUri+productReview.getReviewId(), ProductRatingDTO.class);
			System.out.println("productRatingDTO=="+productRatingDTO);
			productReviewDTO.setRatingID(productRatingDTO.getRatingID());
			productReviewDTO.setRating(productRatingDTO.getRating());
			
			productReviewDtoList.add(productReviewDTO);
		}
		
		
		//begin - Calls the rating service via REST endpoint
		//final String uri = "http://localhost:8082/reviewRating/1";
		//RestTemplate restTemplate = new RestTemplate();
		//ProductRatingDTO productRatingDTO = restTemplate.getForObject(uri, ProductRatingDTO.class);
		//System.out.println("productRatingDTO=="+productRatingDTO);
		//end - Calls the rating service via REST endpoint
		
		return productReviewDtoList;
		
	}
	
	
	
}
