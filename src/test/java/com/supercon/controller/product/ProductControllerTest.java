package com.supercon.controller.product;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


import com.supercon.controller.controllers.AbstractControllerTest;
import com.supercon.model.product.AbstractProduct;
import com.supercon.model.product.Product;
import com.supercon.model.product.ProductPack;
import com.supercon.service.product.ProductServices;

/**
 * The Class ProductControllerTest.
 *
 * @author rsanmartin
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductControllerTest extends AbstractControllerTest{

	/** The product controller. */
	//@InjectMocks
	//@Qualifier("rsm")
	//private ProductController productController;

	/** The product services. */
	@MockBean
	//@Qualifier("rsm")
	private ProductServices productServices;
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.todo1.as.trx.controller.controllers.AbstractControllerTest#setup()
	 */
	public void setup() {}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void getProductByCode() throws Exception {
		Product product1 = new Product(1.50, "PROD_01", "Product 01");
		Mockito.doReturn(product1).when(productServices).getProduct("PROD_01");
		
		Assert.assertNotNull(mockMvc.perform(get("/v1/products/"+product1.getProductCode())
		.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
		.content(converToString(product1))
		.headers(getHttpHeaders()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.productCode").value("PROD_01"))
		.andExpect(jsonPath("$.price").value(1.50))
		.andExpect(jsonPath("$.name").value("Product 01"))
		);
	}
	
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 * @throws Exception
	 *             the exception
	 */
	@Ignore
	@Test
	public void getAllProducts() throws Exception {
		List<AbstractProduct> products = prepareSimpleProducts();
		//products.add(getProductMed());
		Product product1 = new Product(1.50, "PROD_01", "Product 01");
		List <String> productsCodes = new ArrayList <String>();
		productsCodes.add("COD01");
		productsCodes.add("COD02");
		productsCodes.add("COD03");
		/****************** TEST 1 ******************/
		Mockito.doReturn(productsCodes).when(productServices).getProductCodes();
		
		
		//products = productServices.getAllProducts();
		//Assert.assertNotNull(mockMvc.perform(get("/v1/products")
				//.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
				//.content(converToString())
				//.headers(getHttpHeaders()))
				//.andExpect(status().isOk()));
		
		/*mockMvc.perform(get("/v1/products")
				.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
				.content(converToString()).headers(getHttpHeaders()))
				.andExpect(status().isOk()
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))		
				);*/
		
		Assert.assertNotNull(mockMvc.perform(get("/v1/products")
				.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
		.headers(getHttpHeaders()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.productCode").value(12345)));
		
		
		//mockMvc.perform(get("/v1/products") 
		          // .accept(MediaType.APPLICATION_JSON))
		//.content(converToString())
		//.headers(getHttpHeaders()))
		           //.andExpect(status().isOk())
		          // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		          // .andExpect(jsonPath("$.productCode").value(12345));
		           //.andExpect(jsonPath("$.accountType").value("SAVINGS"))
		           //.andExpect(jsonPath("$.balance").value(5000.0));
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

	/**
	 * Gets the all products 2.
	 *
	 * @return the all products 2
	 * @throws Exception
	 *             the exception
	 */
	@Ignore
	@Test
	public void getAllProducts2() throws Exception {
		/****************** TEST 2 ******************/
		Mockito.doReturn(null).when(productServices).getAllProducts();
		//Assert.assertNotNull(mockMvc.perform(get("/master/product/all")
				//.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE)).headers(getHttpHeaders()))
				//.andExpect(status().isNotFound()));
	}

	/**
	 * Gets the all products 3.
	 *
	 * @return the all products 3
	 * @throws Exception
	 *             the exception
	 */
	@Ignore
	@Test
	public void getAllProducts3() throws Exception {
		/****************** TEST 3 ******************/
		Mockito.doReturn(new ArrayList<>(0)).when(productServices).getAllProducts();
		//Assert.assertNotNull(mockMvc.perform(get("/master/product/all")
				//.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE)).headers(getHttpHeaders()))
				//.andExpect(status().isNotFound()));
	}

	/**
	 * Gets the all products 4.
	 *
	 * @return the all products 4
	 * @throws Exception
	 *             the exception
	 */
	@Ignore
	@Test
	public void getAllProducts4() throws Exception {
		/****************** TEST 4 ******************/
		//Mockito.doThrow(new MediatorException("ERROR IN TEST")).when(productServices).getAllProducts();
		//Assert.assertNotNull(mockMvc.perform(get("/master/product/all")
				//.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE)).headers(getHttpHeaders()))
				//.andExpect(status().isInternalServerError()));
	}

	/**
	 * Gets the all products 5.
	 *
	 * @return the all products 5
	 * @throws Exception
	 *             the exception
	 */
	@Ignore
	@Test(expected = Exception.class)
	public void getAllProducts5() throws Exception {
		/****************** TEST 5 ******************/
		//Mockito.doAnswer(new Answer<Object>() {
			//@Override
			//public Object answer(InvocationOnMock invocation) throws Throwable {
			//	return new MediatorException();
			//}
		///}).when(productServices).getAllProducts();
		//Assert.assertNotNull(mockMvc.perform(get("/master/product/all")
				///.contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE)).headers(getHttpHeaders()))
				///.andExpect(status().isOk()));
	}
}