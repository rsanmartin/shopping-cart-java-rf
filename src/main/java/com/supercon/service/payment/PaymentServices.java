/**
 * 
 */
package com.supercon.service.payment;

import com.supercon.model.shoppingcart.Order;

/**
 * @author rsmh8_000
 *
 */
public interface PaymentServices {
	
	/**method to pay the order
	 * @param order
	 */
	public void payOrder(Order order);

}
