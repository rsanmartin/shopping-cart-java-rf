package com.supercon.controller.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
//import static org.springframework.ws.test.client.RequestMatchers.connectionTo;
//import static org.springframework.ws.test.client.ResponseCreators.withPayload;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
//import org.springframework.ws.client.core.WebServiceTemplate;
//import org.springframework.ws.test.client.MockWebServiceServer;
import org.w3c.dom.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * The Class AbstractControllerTest.
 *
 * @author rsanmartin
 */

public abstract class AbstractControllerTest {

	/** The wac. */
	@Autowired
	protected WebApplicationContext wac;

	/** The mock mvc. */
	@Autowired
	protected MockMvc mockMvc;


	/**
	 * Setup mock.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setupMock() throws Exception {
		setup();
		//validatorService = applicationContext.getBean(ValidatorService.class);
		MockitoAnnotations.initMocks(this);
		//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	/**
	 * After.
	 */
	@After
	public void after() {
		try {
			//if (mockServer != null) {
				//mockServer.verify();
			//}
		} catch (Throwable e) {

		}
		//mockServer = null;
		//mockMvc = null;
	}

	

	

	/**
	 * Setup.
	 */
	public abstract void setup();

	/**
	 * Convert to string.
	 *
	 * @param object the object
	 * @return the string
	 * @throws JsonProcessingException the json processing exception
	 */
	protected String converToString(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
	
	/**
	 * Gets the http headers.
	 *
	 * @return the http headers
	 */
	protected HttpHeaders getHttpHeaders() {
		return this.getHttpHeaders("67890");
	}

	/**
	 * Gets the http headers.
	 *
	 * @param sessionId the session id
	 * @return the http headers
	 */
	protected HttpHeaders getHttpHeaders(String sessionId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("CORRELATIONID", "1234");
		headers.add("Content-Type", "application/json");
		headers.add("SESSIONID", sessionId);
		headers.add("METADATA", "OFF");
		return headers;
	}

	/**
	 * Gets the bad http headers.
	 *
	 * @return the bad http headers
	 */
	protected HttpHeaders getBadHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("CORRELATIONID", "1234");
		headers.add("Content-Type", "application/json");
		headers.add("SESSIONID", "ERROR");
		headers.add("METADATA", "OFF");
		return headers;
	}
}
