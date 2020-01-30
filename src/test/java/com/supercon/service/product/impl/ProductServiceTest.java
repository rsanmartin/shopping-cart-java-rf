package com.supercon.service.product.impl;

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
import com.supercon.service.product.ProductServices;
import com.supercon.service.product.impl.ProductServicesImpl;

/**
 * @author rosanmartin
 *
 */
public class ProductServiceTest {

    //private ProductServicesImpl productService;
	private ProductServices productService;
    @Before
    public void setup() throws Exception {
        productService = new ProductServicesImpl(prepareSimpleProducts());
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

    @Test
    public void getProductCodes_shouldReturnAllCodes() throws Exception {
        List<String> codes = productService.getProductCodes();
        assertEquals(3, codes.size());
        assertEquals("PROD_01", codes.get(0));
        assertEquals("PROD_02", codes.get(1));
        assertEquals("PACK_01", codes.get(2));
    }

    //@Ignore
    @Test
    public void getProduct_shouldReturnProductForKnownCode() throws Exception {
    	Product product = (Product) productService.getProduct("PROD_01");
        assertEquals("PROD_01", product.getProductCode());
        assertEquals("Product 01", product.getName());
        assertEquals(1.50, product.getPrice(), 0.00);
    }

    @Test
    public void getProduct_shouldReturnNullForUnknownCode() throws Exception {
    	Product product = (Product) productService.getProduct("PROD_03");
        assertNull(product);
    }

}
