package com.supercon.service.shoppingcart.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.supercon.model.product.AbstractProduct;
import com.supercon.model.product.Product;
import com.supercon.model.product.ProductPack;
import com.supercon.model.shoppingcart.Item;
import com.supercon.service.product.ProductServices;
import com.supercon.service.product.impl.ProductServicesImpl;
import com.supercon.service.shoppingcart.ShoppingCartServices;

/**
 * @author rosanmartin
 *
 */
public class ShoppingCartServicesTest {

	private ProductServices productService;
	private ShoppingCartServices shoppingCartServices;
    @Before
    public void setup() throws Exception {
        productService = new ProductServicesImpl(prepareSimpleProducts());
        shoppingCartServices = new ShoppingCartServicesImpl();
    }
    
    private List<AbstractProduct> prepareSimpleProducts() {
    	List<AbstractProduct> products = new ArrayList<AbstractProduct>();
    	Product product1 = new Product(1.50, "PROD_01", "Product 01");
    	Product product2 = new Product(3.45, "PROD_02", "Product 02");
    	
    	ProductPack packProduct1 = new ProductPack("PACK_01");
    	packProduct1.setProductCode("PACK_01");
    	packProduct1.addProduct(product1);
    	packProduct1.addProduct(product2);
    	
    	products.add(product1);
    	products.add(product2);
    	products.add(packProduct1);
    	return products;
    }
    @Ignore
    @Test
    public void getProductCodes_shouldReturnAllCodes() throws Exception {
        List<String> codes = productService.getProductCodes();
        assertEquals(3, codes.size());
        assertEquals("PROD_01", codes.get(0));
        assertEquals("PROD_02", codes.get(1));
        assertEquals("PACK_01", codes.get(2));
    }

    @Ignore
    @Test
    public void getProduct_shouldReturnProductForKnownCode() throws Exception {
    	Product product = (Product) productService.getProduct("PROD_01");
        assertEquals("PROD_01", product.getProductCode());
        assertEquals("Product 01", product.getName());
        assertEquals(1.50, product.getPrice(), 0.00);
    }
    @Ignore
    @Test
    public void getProduct_shouldReturnNullForUnknownCode() throws Exception {
    	Product product = (Product) productService.getProduct("PROD_03");
        assertNull(product);
    }
    
    @Test
    public void packItem_shouldReturnNullForUnknownCode() throws Exception {
    	//Product product = (Product) productService.getProduct("PROD_03");
        
    	/*Item 01*/
    	Product product1 = new Product(1.50, "PROD_01", "Product 01");
    	Item item = new Item();
    	item.setProduct(product1);
    	item.setQuantity(2);
    	
    	/*Item 02*/
    	Product product2 = new Product(3.50, "PROD_02", "Product 02");
    	Item item02 = new Item();
    	item02.setProduct(product2);
    	item02.setQuantity(3);
    	
    	/*Item 03*/
    	/*Pack 1*/
    	ProductPack productPack01 = new ProductPack("PACK01");
    	Product product3 = new Product(2.0, "PROD_03", "Product 03");
    	Product product4 = new Product(4.0, "PROD_04", "Product 04");
    	productPack01.addProduct(product3);
    	productPack01.addProduct(product4);
    	Item item03 = new Item();
    	item03.setProduct(productPack01);
    	item03.setQuantity(4);
    	
    	/*Item 04*/
    	/*Pack 2*/
    	ProductPack productPack02 = new ProductPack("PACK02");
    	Product product5 = new Product(5.0, "PROD_05", "Product 05");
    	Product product6 = new Product(6.0, "PROD_06", "Product 06");
    	productPack02.addProduct(product5);
    	productPack02.addProduct(product6);
    	Item item04 = new Item();
    	item04.setProduct(productPack02);
    	item04.setQuantity(4);
    	
    	shoppingCartServices.addItem(null, item);
    	shoppingCartServices.addItem(null, item02);
    	shoppingCartServices.addItem(null, item03);
    	shoppingCartServices.addItem(null, item04);
    	
    	List<Item> cartItems = shoppingCartServices.getCartItems();
    	
    	System.out.println("Subtotal del carrito: " + shoppingCartServices.getCartSubTotal());
    	
    }
    
    
    @Test
    public void updateItem_shouldReturnNullForUnknownCode() throws Exception {
    	//Product product = (Product) productService.getProduct("PROD_03");
        
    	Product product1 = new Product(1.50, "PROD_01", "Product 01");
    	Product product2 = new Product(3.50, "PROD_02", "Product 02");
    	
    	Item item = new Item();
    	item.setProduct(product1);
    	item.setQuantity(2);
    	
    	Item item02 = new Item();
    	item02.setProduct(product2);
    	item02.setQuantity(2);
    	
    	shoppingCartServices.addItem(null, item);
    	shoppingCartServices.addItem(null, item02);
    	
    	List<Item> cartItems = shoppingCartServices.getCartItems();
    	
    	item02.setQuantity(2);
    	
    	shoppingCartServices.updateItemQuantity(null, item02, 5);
    	
    	cartItems = shoppingCartServices.getCartItems();
    	//double carttotal = shoppingCartServices.calculateSubTotal();
    	
    	//shoppingCartServices.removeItem(null, item);
    	 
    	//assertNull(product);
    }
    @Ignore
    @Test
    public void addItem_shouldReturnNullForUnknownCode() throws Exception {
    	//Product product = (Product) productService.getProduct("PROD_03");
        
    	Product product1 = new Product(1.50, "PROD_01", "Product 01");
    	Product product2 = new Product(3.50, "PROD_02", "Product 02");
    	
    	Item item = new Item();
    	item.setProduct(product1);
    	item.setQuantity(2);
    	
    	Item item02 = new Item();
    	item02.setProduct(product2);
    	item02.setQuantity(2);
    	
    	shoppingCartServices.addItem(null, item);
    	shoppingCartServices.addItem(null, item02);
    	
    	List<Item> cartItems = shoppingCartServices.getCartItems();
    	
    	double carttotal = shoppingCartServices.getCartSubTotal();
    	
    	shoppingCartServices.removeItem(null, item);
    	 
    	//assertNull(product);
    }
    

}
