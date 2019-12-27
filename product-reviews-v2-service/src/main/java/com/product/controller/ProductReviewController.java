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

import com.product.dto.ProductReviewDTO;
import com.product.service.ProductReviewService;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@RestController
public class ProductReviewController {
	
	@Autowired
	private ProductReviewService productReviewService;
	
	
	@RequestMapping(value = "/productReview/{productId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ProductReviewDTO> getProductReviews(
			@PathVariable("productId") long productId) {
		
		List<ProductReviewDTO> productReviews = new ArrayList<ProductReviewDTO>();
		
			try {
				productReviews = productReviewService.getProductReviews(productId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return productReviews;
	}	
	
}
