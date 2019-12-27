/**
 * 
 */
package com.product.service;

import java.util.List;

import com.product.dto.ProductReviewDTO;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
public interface ProductReviewService {

	public List<ProductReviewDTO> getProductReviews(long productId);
}
