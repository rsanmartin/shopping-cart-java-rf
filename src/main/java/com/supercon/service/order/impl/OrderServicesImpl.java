package com.supercon.service.order.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supercon.model.customer.Customer;
import com.supercon.model.shoppingcart.Item;
import com.supercon.model.shoppingcart.Order;
import com.supercon.service.order.OrderServices;

/**
 * @author rosanmartin
 *
 */
@Service
public class OrderServicesImpl implements OrderServices{

    
	@Override
	public void showConfirmation(Customer customer, List<Item> items, double totalPrice, int loyaltyPointsEarned) {
		// TODO Auto-generated method stub
		//show confirmation
        //do some calculations and formatting on the shopping cart data and ask user for confirmation
        //after confirmation redirect to place order
	}

	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		
		//Se llama a logica de pago PaymentServices
		//Se llama a logica de Actualización de Stock 
		
		return order;
	}

	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	
}
