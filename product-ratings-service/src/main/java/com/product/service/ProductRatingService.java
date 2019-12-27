/**
 * 
 */
package com.product.service;

import java.util.List;

import com.product.dto.ProductRatingDTO;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
public interface ProductRatingService {

	public List<ProductRatingDTO> getProductRatings(long productId);
	
	public ProductRatingDTO getReviewRating(long reviewId);
}
