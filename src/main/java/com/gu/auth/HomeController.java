package com.gu.auth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.common.base.Preconditions;
import com.gu.auth.dao.ApprovalStageDAO;
import com.gu.auth.model.ApprovalStage;
import com.gu.auth.model.Student;
import com.gu.auth.service.StudentService;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HomeProcessor homeProcessor;
	
	 @Autowired 
	 private StudentService studentService;
	 
	 @Autowired 
	    private ApprovalStageDAO approvalStageDAO;
	

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//public String testPage(Locale locale, Model model, @RequestParam("aValue") String aValue) 
	public String testPage(Locale locale, Model model) 
	{		
        
		//logger.warn("aValue is ");
		
		//logger.error("This is a test error",new Exception("XXXXXXXX"));
		
		//logger.info("info is ");
		
		//logger.error("Email error ");
		
		// return a load of values to the test page.
		model.addAttribute("serverTime", new Date() );	
		model.addAttribute("admin", true );		
		model.addAttribute("today", Calendar.getInstance());
		model.addAttribute("username", "Kelly Green" );		
		model.addAttribute("aList", homeProcessor.getaList() );		
		model.addAttribute("aNumber", 15.45643 );
		
		List<String> users = new ArrayList<String>();		
		users.add("Fred");
		users.add("Jim");
		users.add("Anne");		
		model.addAttribute("users", users );
			
		return "testPage";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("username", "Kelly Green" );	
		return "home";
	}
	
	@RequestMapping(value = "/dataProtection", method = RequestMethod.GET)
	public String dataProtection(Locale locale, Model model) {
		model.addAttribute("username", "Kelly Green" );	
		return "dataProtection";
	}
	
	@RequestMapping(value = "/page1", method = RequestMethod.GET)
	public String page1(Locale locale, Model model) {
			
		return "page1";
	}
	
	@RequestMapping(value = "/page2", method = RequestMethod.GET)
	public String page2(Locale locale, Model model) {
			
		ApprovalStage approvalStage = new ApprovalStage(1,1,1,1);

		  model.addAttribute("approvalStage", approvalStage);
		  
		return "page2";
	}

	public HomeProcessor getHomeProcessor() {
		return homeProcessor;
	}

	public void setHomeProcessor(HomeProcessor homeProcessor) {
		this.homeProcessor = homeProcessor;
	}
	
	
	@RequestMapping(value = "/processForm", method=RequestMethod.POST)
	public String processForm(@Valid ApprovalStage approvalStage, BindingResult result, Model model) {
		
		if(result.hasErrors()) 
		{
	        return "page2";
	    }

		approvalStageDAO.insertApprovalStage(approvalStage);					

		return "end";
	}
	
	
	/*@RequestMapping(value = "/processForm", method=RequestMethod.POST)
	public String processForm(@Valid ApprovalStage approvalStage, BindingResult result, Model model) {
		
		if(result.hasErrors()) 
		{
	        return "page2";
	    }

		try
		{
			approvalStageDAO.insertApprovalStage(approvalStage);					
		}
		catch(Exception e)
		{
			result.addError(new FieldError("approvalStage","systemId", "systemId already used"));
			return "page2";
		}

		return "end";
	}*/
}
