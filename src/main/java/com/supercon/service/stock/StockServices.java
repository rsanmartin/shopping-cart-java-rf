/**
 * 
 */
package com.supercon.service.stock;

import com.supercon.model.product.AbstractProduct;

/**
 * @author rosanmartin
 *
 */
public interface StockServices {
	
	/**Method to update product stock
	 * @param product
	 * @param productQuantity
	 * @return
	 */
	public boolean updateProductStock(AbstractProduct product, int productQuantity);
	
	/**
	 * @param product
	 * @param productQuantity
	 * @return
	 */
	public boolean verifyProductStock(AbstractProduct product, int productQuantity);

}
