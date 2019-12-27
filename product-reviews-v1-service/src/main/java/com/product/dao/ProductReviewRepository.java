/**
 * 
 */
package com.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductDetails;
import com.product.entity.ProductReview;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
	
		
	List<ProductReview> findByProductDetails(ProductDetails productdetails);
	
	}
