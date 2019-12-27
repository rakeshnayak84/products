/**
 * 
 */
package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductRatingDTO;
import com.product.service.ProductRatingService;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@RestController
public class ProductRatingController {
	
	@Autowired
	private ProductRatingService productRatingService;
	
	
	@RequestMapping(value = "/productRating/{productId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ProductRatingDTO> getProductRatings(
			@PathVariable("productId") long productId) {
		
		List<ProductRatingDTO> productRatings = new ArrayList<ProductRatingDTO>();
		
			try {
				productRatings = productRatingService.getProductRatings(productId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return productRatings;
	}
	
	@RequestMapping(value = "/reviewRating/{reviewId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ProductRatingDTO getReviewRating(
			@PathVariable("reviewId") long reviewId) {
		
		ProductRatingDTO productRatingDto = new ProductRatingDTO();
		
			try {
				productRatingDto = productRatingService.getReviewRating(reviewId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return productRatingDto;
	}
	
}
