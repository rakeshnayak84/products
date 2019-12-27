/**
 * 
 */
package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductRating;
import com.product.entity.ProductDetails;
import java.util.List;
import com.product.entity.ProductReview;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
public interface ProductRatingRepository extends JpaRepository<ProductRating, Long> {
	
	List<ProductRating> findByProductDetails(ProductDetails productdetails);
	
	ProductRating findByProductReview(ProductReview productreview);

}
