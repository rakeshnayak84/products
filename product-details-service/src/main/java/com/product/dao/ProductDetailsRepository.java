/**
 * 
 */
package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductDetails;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
	
	
	ProductDetails findByProductId(long productId);
		
}
