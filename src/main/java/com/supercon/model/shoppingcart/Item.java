package com.supercon.model.shoppingcart;

import com.supercon.model.product.AbstractProduct;

public class Item {
	
	private AbstractProduct product;
	//private double itemPrice = 0.0;
	private int quantity = 0;
	
	public Item(AbstractProduct product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Item () {
		this.product = null;
		this.quantity = 0;
	}
	
	/**
	 * @return the product
	 */
	public AbstractProduct getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(AbstractProduct product) {
		this.product = product;
	}
	/**
	 * @return the itemPrice
	 */
	public double getItemPrice() {
		return this.product.getPrice() * this.quantity;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	//public void setItemPrice(double itemPrice) {
	//	this.itemPrice = itemPrice;
	//}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
