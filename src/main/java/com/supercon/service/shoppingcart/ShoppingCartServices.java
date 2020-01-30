package com.supercon.service.shoppingcart;

import java.util.List;

import com.supercon.model.customer.Customer;
import com.supercon.model.shoppingcart.Item;
import com.supercon.model.shoppingcart.Order;

/**
 * @author rosanmartin
 *
 */
public interface ShoppingCartServices {
	
	/**Method to add selected product
	 * @param product
	 */
	public boolean addItem(String orderId,Item item);
	
	/**
	 * Method to remove selected product
	 * @param product
	 */
	public boolean removeItem(String orderId,Item item);
	
	/**Method to update product quantity on cart
	 * @param product
	 * @param quantity
	 * @return
	 */
	public boolean updateItemQuantity(String orderId,Item item, int quantity);

	/**Method to checkout customer order
	 * @param customer
	 * @param products
	 */
	public void checkout(Customer customer, List<Item> items);
	
	
	/**Method to obtain cart subtotal
	 * @param items
	 * @return
	 */
	public double getCartSubTotal();
	
	/**
	 * @return
	 */
	public List<Item> getCartItems();
	
}
