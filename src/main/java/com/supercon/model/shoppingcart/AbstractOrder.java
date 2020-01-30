package com.supercon.model.shoppingcart;

import java.util.List;

import com.supercon.model.customer.Customer;

/**
 * @author rosanmartin
 *
 */
public abstract class AbstractOrder {

	protected String orderId;
	protected List<Item> items;
	protected Customer customer;
	protected double subTotal;
	protected double totalDiscount;
	protected double total;
	
	/**
	 * @param orderId TODO
	 * @param customer
	 * @param products
	 */
	public AbstractOrder(String orderId, List<Item> items, double subTotal , double totalDiscount, double total, Customer customer) {
		super();
		this.items = items;
		this.customer = customer;
		this.subTotal = subTotal;
		this.totalDiscount = totalDiscount;
		this.total = total;
	}
	
	/**
	 * @return the products
	 */
	public List<Item> getItems() {
		return items;
	}
	/**
	 * @param products the products to set
	 */
	public void setItem(List<Item> items) {
		this.items = items;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the totalDiscount
	 */
	public double getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * @param totalDiscount the totalDiscount to set
	 */
	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
}
