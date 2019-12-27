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

import com.product.dto.ProductDetailsDTO;
import com.product.service.ProductDetailsService;

/**
 * @author rakesh.a.kumar.nayak
 *
 */
@RestController
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@RequestMapping(value = "/productDetails/{productId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ProductDetailsDTO getProductDetails(
			@PathVariable("productId") long productId) {
		
		ProductDetailsDTO productDetailsDTO = null;
		
			try {
				productDetailsDTO = productDetailsService.getProductDetails(productId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return productDetailsDTO;
	}
	
	@RequestMapping(value = "/allProducts", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ProductDetailsDTO> getAllProducts() {
		
		List<ProductDetailsDTO> productDetailsDTOList = new ArrayList<ProductDetailsDTO>();
		
			try {
				productDetailsDTOList = productDetailsService.getAllProducts();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return productDetailsDTOList;
	}

}
