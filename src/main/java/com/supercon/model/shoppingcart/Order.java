package com.supercon.model.shoppingcart;

import java.util.List;

import com.supercon.model.customer.Customer;

/**
 * @author rosanmartin
 *
 */
public class Order extends AbstractOrder {
	
	/**
	 * @param items
	 * @param customer
	 * @param orderTotalAmount
	 * @param discountTotalAmount
	 */
	public Order(List<Item> items, Customer customer,double subTotal,double totalDiscount,double total) {
		super(null, items, subTotal, totalDiscount, total, customer);
	}

}
