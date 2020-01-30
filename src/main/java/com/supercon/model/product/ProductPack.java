package com.supercon.model.product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rosanmartin
 *
 */
public class ProductPack extends AbstractProduct{

	private List<AbstractProduct> products = new ArrayList<AbstractProduct>();
	
	/**
	 * @param price
	 * @param productCode
	 * @param name
	 */
	public ProductPack(String name) {
		super(null, name, 0, null);
	}
	
	/**
	 * get total price from all products
	 */
	public double getPrice() {
		double price = 0;
		for(AbstractProduct child: products) {
			price+=child.getPrice();
		}
		return price;
	}
	
	/**
	 *Not supported
	 */
	public void setPrice(double price) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @param product
	 */
	public void addProduct(AbstractProduct product) {
		this.products.add(product);
	}
	
	/**
	 * Remove specific product from products list
	 * @param product
	 * @return
	 */
	public boolean removeProduct(AbstractProduct product) {
		return this.products.remove(product);
	}
}
