package com.gu.auth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

@Component
public class HomeProcessor 
{
	private final Logger logger = LoggerFactory.getLogger(HomeProcessor.class);
	
	public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
			  "red",
			  "orangex",
			  "yellow",
			  "green",
			  "blue",
			  "purplexx");
	
	public LoadingCache<Integer, List<String>> cache = CacheBuilder.newBuilder()
		       .expireAfterAccess(10, TimeUnit.MINUTES)
		       .recordStats()
		       .build(
		           new CacheLoader<Integer, List<String>>() {
		             public List<String> load(Integer key) { // no checked exception
		            	 
		            	 ArrayList<String> list = new ArrayList<String>();
		            	 
		            		 list.add("fred1");
		            		 list.add("ggg1");

		            	 return list;
		             }
		           });

	
	private List<String> aList = new ArrayList<String>();
	
	private String aField;
	 
	public String getaField() {
		return aField;
	}
	public void setaField(String aField) {
		this.aField = aField;
	}
	public List<String> getaList() {
		return aList;
	}
	public void setaList(List<String> aList) {
		Preconditions.checkArgument( aList != null, "List must not be null" );
		this.aList = aList;
	}
	public int aDummyMethod()
	{
		int x = 0;
		x++;
		
		COLOR_NAMES.add("GREEN");
		
		return 9;
	}
	
		
	public void testNonNegativeInt(int i)
	{		
		logger.error("This is a test error");
		Preconditions.checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
	}
	
	public void doSomething() {
		ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(COLOR_NAMES, new Function<String, Integer> () {
		    public Integer apply(String string) {
		      return string.length();
		    }
		  });
		
		String name = stringsByIndex.get(6);

		}
	
	


	
	
	
	
	
}
