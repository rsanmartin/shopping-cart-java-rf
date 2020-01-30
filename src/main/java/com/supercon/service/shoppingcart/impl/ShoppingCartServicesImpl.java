package com.supercon.service.shoppingcart.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.supercon.model.customer.Customer;
import com.supercon.model.product.AbstractProduct;
import com.supercon.model.shoppingcart.Item;
import com.supercon.model.shoppingcart.Order;
import com.supercon.model.shoppingcart.ShoppingCart;
import com.supercon.service.order.OrderServices;
import com.supercon.service.shoppingcart.ShoppingCartServices;

/**
 * @author rosanmartin
 *
 */
@Service
public class ShoppingCartServicesImpl implements ShoppingCartServices {

	
	private List <Item> items;
	private OrderServices orderService;
	
	public ShoppingCartServicesImpl() {
		items = new ArrayList<Item>();
	}
	
	@Override
	public boolean addItem(String orderId, Item item) {
		// TODO Auto-generated method stub
		if(this.items != null) {
			return this.items.add(item);
		}else {
			return false;
		}	
	}

	@Override
	public boolean removeItem(String orderId, Item item) {
		// TODO Auto-generated method stub
		if(this.items != null) {
			return this.items.remove(item);
		}else {
			return false;
		}
	}

	@Override
	public boolean updateItemQuantity(String orderId, Item item, int quantity) {
		// TODO Auto-generated method stub
		boolean ret = false;
		int index = 0;
		Item temporalItem = new Item();
		try {
			if(this.items != null && this.items.size() >0) {
				index = this.items.indexOf(item);
				if(index > -1){
					temporalItem = this.items.get(index);
					temporalItem.setQuantity(quantity);
					this.items.add(index, temporalItem);
					ret = true;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return ret;
	}

	@Override
	public void checkout(Customer customer, List<Item> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getCartSubTotal() {
		double subtotal = 0;
		if(this.items != null && this.items.size() > 0) {
			for(Item item : this.items) {
				subtotal+=item.getItemPrice();
			}
		}
		System.out.println(subtotal);
		return subtotal;
	}

	@Override
	public List<Item> getCartItems() {
		// TODO Auto-generated method stub
		return this.items;
	}

}
