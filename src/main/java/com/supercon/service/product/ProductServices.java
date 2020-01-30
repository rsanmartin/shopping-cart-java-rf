package com.supercon.service.product;

import java.util.List;

import com.supercon.model.product.AbstractProduct;

/**
 * @author rosanmartin
 *
 */
public interface ProductServices {
	
	/**
	 * @return
	 */
	public List<String> getProductCodes();
	
	/**
	 * @param code
	 * @return
	 */
	public AbstractProduct getProduct(final String code);
	
	/**
	 * @return
	 */
	public List<AbstractProduct> getAllProducts();

}
