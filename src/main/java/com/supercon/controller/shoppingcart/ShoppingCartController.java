package com.supercon.controller.shoppingcart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.supercon.model.product.AbstractProduct;
import com.supercon.service.product.ProductServices;
import com.supercon.service.shoppingcart.ShoppingCartServices;
/**
 * @author rosanmartin
 *
 */
@RestController
public class ShoppingCartController {
	
	//@Autowired
    //private ShoppingCartServices shoppingCartServices;
	
	public void addItem() {}
	
	public void removeItem() {}
	
	public void updateItemQuantity() {}
	
	public void createCostumerOrder() {}
	
	
}
