/**
 * 
 */
package com.supercon.model.product;

import com.supercon.model.discount.Discount;

/**
 * @author rosanmartin
 *
 */
public abstract class AbstractProduct {
	
	protected String productCode;
	protected String name;
	protected double price;
	protected Discount discount;
	
	/**
	 * @param productCode
	 * @param name
	 * @param price
	 * @param discount TODO
	 */
	public AbstractProduct(String productCode, String name, double price, Discount discount) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.price = price;
	}
	
	/**
	 * @param productCode
	 */
	public AbstractProduct(String productCode) {
		super();
		this.productCode = productCode;
		this.name = null;
		this.price = 0;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the discount
	 */
	public Discount getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
}
