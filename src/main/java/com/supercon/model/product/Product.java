package com.supercon.model.product;

/**
 * @author rosanmartin
 *
 */
public class Product extends AbstractProduct{

	/**Constructor
	 * @param price
	 * @param productCode
	 * @param name
	 */
	public Product(double price, String productCode, String name) {
		super(productCode, name, price, null);
	}
	
	public Product(String productCode) {
		super(productCode);
	}

}
