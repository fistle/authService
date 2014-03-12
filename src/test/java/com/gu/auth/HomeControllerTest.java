// Copyright (C) The University of Glasgow
// All rights reserved
package com.gu.auth;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Uses Spring {@link MockMvc} and Mockito to test the home page.
 * 
 * {@link MockMvc} was introduced in Spring 3.2
 * 
 * @see http://code.google.com/p/mockito/
 * @see http://spring.io/blog/2012/11/12/spring-framework-3-2-rc1-spring-mvc-test-framework
 * 
 * @author dl121z
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class HomeControllerTest 
{	 
    /**
     * Class under test.
     */
   private  HomeController homeController = new HomeController();
 
    /**
     * {@link MockMvc} allows us to mock up {@link HomeController}
     */
    private MockMvc mockMvc;
 
    /**
     * Setup the test environment and mock up the {@link HomeController}.
     */
    @SuppressWarnings("unchecked")
	@Before
    public void setUp() 
    {	    	
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        
        // mock some data in the HomeProcessor.
        HomeProcessor homeProcessor = new HomeProcessor();
                
        // create a mocked list of strings
        List<String> mockedList = mock(ArrayList.class);
    	//when(mockedList.get(0)).thenReturn("first");
    	when(mockedList.get(anyInt())).thenReturn("element");   
    	// add them to the HomeProcessor
    	homeProcessor.setaList(mockedList);
               
        homeController.setHomeProcessor(homeProcessor);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();	         
    }
    
    /**
     * This tests the home page ensuring the result is correct.
     */
    @SuppressWarnings("unchecked")
	@Test
    public void testCallingHomePage() throws Exception 
    {	    	    	
    	// call the home page and get the model (in MvcResult) that gets sent to the test page.
		MvcResult result = this.mockMvc.perform(get("/").param("aValue", "XXXX"))				
            .andExpect(status().isOk())
            	.andExpect(model().attributeExists("serverTime", "username", "users", "aList"))
            		.andExpect(forwardedUrl("testPage"))
            			.andReturn();
		
		List<String> 
			users = 
				(List<String>) result.getModelAndView().getModel().get("users");
				
		Assert.assertEquals(3, users.size());     
		
		List<String> 
		aList = 
			(List<String>) result.getModelAndView().getModel().get("aList");
		

		
			
		Assert.assertEquals("element", aList.get(0));    
		Assert.assertEquals("element", aList.get(1)); 
		
		
    }	
    

    
}
