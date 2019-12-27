/**
 * 
 */
package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@Entity
@Table(name="ProductRating")
@NamedQuery(name="ProductRating.findAll", query="SELECT pr FROM ProductRating pr")
public class ProductRating {
	
	@Id
	@Column(name="ratingID")
	private long ratingID;
	
	@Column(name="rating")
	private int rating;
		
	@ManyToOne
	@JoinColumn(name="productId")
	private ProductDetails productDetails;

	@OneToOne
	@JoinColumn(name="reviewId")
	private ProductReview productReview;

	/**
	 * @return the ratingID
	 */
	public long getRatingID() {
		return ratingID;
	}

	/**
	 * @param ratingID the ratingID to set
	 */
	public void setRatingID(long ratingID) {
		this.ratingID = ratingID;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the productDetails
	 */
	public ProductDetails getProductDetails() {
		return productDetails;
	}

	/**
	 * @param productDetails the productDetails to set
	 */
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	/**
	 * @return the productReview
	 */
	public ProductReview getProductReview() {
		return productReview;
	}

	/**
	 * @param productReview the productReview to set
	 */
	public void setProductReview(ProductReview productReview) {
		this.productReview = productReview;
	}
	
	
	
}
