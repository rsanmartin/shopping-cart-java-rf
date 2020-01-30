package com.supercon.service.order;

import java.util.List;

import com.supercon.model.customer.Customer;
import com.supercon.model.shoppingcart.Item;
import com.supercon.model.shoppingcart.Order;

/**
 * @author rosanmartin
 *
 */
public interface OrderServices {
	
	/**
	 * @param customer
	 * @param products
	 * @param totalPrice
	 * @param loyaltyPointsEarned
	 */
	public void showConfirmation(Customer customer, List<Item> items, double totalPrice, int loyaltyPointsEarned);
	
	/**
	 * @param customer
	 * @param products
	 * @return
	 */
	public Order placeOrder(Order order);
	
	
	public Order getOrder();
	
	
	public void removeOrder(Order order);
	
}
