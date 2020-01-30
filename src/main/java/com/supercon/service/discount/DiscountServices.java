/**
 * 
 */
package com.supercon.service.discount;

import com.supercon.model.discount.Discount;
import com.supercon.model.product.AbstractProduct;
import com.supercon.model.shoppingcart.Order;

/**
 * @author rosanmartin
 *
 */
public interface DiscountServices {
	
	/**
	 * @param product
	 */
	public Discount getProductDiscount(AbstractProduct product);
	
	/**
	 * @param order
	 * @return
	 */
	public Order applyOrderDiscount(Order order);
	
	/**
	 * @param productCode
	 */
	public void addProductDiscount(String productCode);
	
	/**
	 * @param productCode
	 */
	public void removeProductDiscount(String productCode);
	
	/**
	 * @param productCode
	 */
	public void updateProductDiscount(Discount discount);
	
}
