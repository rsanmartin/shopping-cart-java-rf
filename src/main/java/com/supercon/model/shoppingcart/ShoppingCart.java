package com.supercon.model.shoppingcart;

import java.util.List;

import com.supercon.model.customer.Customer;

/**
 * @author rosanmartin
 *
 */
public class ShoppingCart extends AbstractOrder{

    private String cartState;
    
    /**Constructor
     * @param customer
     * @param products
     * @param cartState
     */
    public ShoppingCart(List<Item> items, Customer customer,double subTotal,double totalDiscount,double total ,String cartState) {
    	super(null, items, subTotal, totalDiscount, total, customer);
        this.cartState = cartState;
    }
    
	/**
	 * @return the cartState
	 */
	public String getCartState() {
		return cartState;
	}

	/**
	 * @param cartState the cartState to set
	 */
	public void setCartState(String cartState) {
		this.cartState = cartState;
	}

}
