// Copyright (C) The University of Glasgow
// All rights reserved
package com.gu.auth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Preconditions;

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

public class HomeProcessorTest
{	
	private final Logger logger = LoggerFactory.getLogger(HomeProcessorTest.class);
	
	/**
	 * Class under test.
	 */
    private HomeProcessor homeProcessor = new HomeProcessor();
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
 
    /**
     * Setup the test environment and mock up the {@link HomeController}.
     */
    @Before
    public void setUp() 
    {	    	
        // Process mock annotations
        MockitoAnnotations.initMocks(this);        
    }
    
    @SuppressWarnings("unchecked")
	@Test   
    public void testMocking()
    {
    	List<String> mockedList = mock(ArrayList.class);
    	//when(mockedList.get(0)).thenReturn("first");
    	when(mockedList.get(anyInt())).thenReturn("element");
    	    	
    	homeProcessor.setaList(mockedList);
    	
    	//assertEquals(homeProcessor.getaList().get(0), "element");
    	//assertEquals(homeProcessor.getaList().get(1), "element");
    	
    	
    	
    	
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testSetAList()
    {    	
    	homeProcessor.setaList(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIndexOutOfBoundsException()
    {    	
    	homeProcessor.testNonNegativeInt(-1);
    }
    
    @Test
    public void testDoSomething() throws ExecutionException
    {    
    	List<String> key1 = homeProcessor.cache.get(1);
    	    	
    	key1 = homeProcessor.cache.get(1);
    	

    	System.out.println("Hit count " + homeProcessor.cache.stats().hitCount());
    	
    	key1 = homeProcessor.cache.get(1);
    	

    	System.out.println("Hit count " + homeProcessor.cache.stats().hitCount());

    	
    	
    	
    	homeProcessor.aDummyMethod();
    }
    

}
