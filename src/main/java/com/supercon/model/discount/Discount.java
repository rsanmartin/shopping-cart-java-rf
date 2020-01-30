/**
 * 
 */
package com.supercon.model.discount;

/**
 * @author rosanmartin
 *
 */
public class Discount {
	
	private String discountId;
	private double discount;
	private String discountDescritpion;
	/**
	 * @param discount
	 * @param discountDescritpion
	 */
	public Discount(String discountId,double discount, String discountDescritpion) {
		this.discount = discount;
		this.discountDescritpion = discountDescritpion;
		this.discountId = discountId;
	}
	/**
	 * @param discount
	 */
	public Discount(double discount) {
		this.discount = discount;
		this.discountDescritpion = null;
	}
	/**
	 * @return the discountId
	 */
	public String getDiscountId() {
		return discountId;
	}
	/**
	 * @param discountId the discountId to set
	 */
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	/**
	 * @return the discountDescritpion
	 */
	public String getDiscountDescritpion() {
		return discountDescritpion;
	}
	/**
	 * @param discountDescritpion the discountDescritpion to set
	 */
	public void setDiscountDescritpion(String discountDescritpion) {
		this.discountDescritpion = discountDescritpion;
	}
	
}
