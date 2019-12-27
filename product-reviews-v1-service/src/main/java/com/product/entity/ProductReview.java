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
import javax.persistence.Table;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@Entity
@Table(name="ProductReview")
@NamedQuery(name="ProductReview.findAll", query="SELECT pr FROM ProductReview pr")
public class ProductReview {
	
	@Id
	@Column(name="reviewId")
	private long reviewId;
	
	@Column(name="reviewComment")
	private String reviewComment;
	
	@Column(name="reviewer")
	private String reviewer;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private ProductDetails productDetails;
	
	
	/**
	 * @return the reviewId
	 */
	public long getReviewId() {
		return reviewId;
	}

	/**
	 * @param reviewId the reviewId to set
	 */
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * @return the reviewComment
	 */
	public String getReviewComment() {
		return reviewComment;
	}

	/**
	 * @param reviewComment the reviewComment to set
	 */
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	/**
	 * @return the reviewer
	 */
	public String getReviewer() {
		return reviewer;
	}

	/**
	 * @param reviewer the reviewer to set
	 */
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
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

	
}
