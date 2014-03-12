// Copyright (C) The University of Glasgow
// All rights reserved
package com.gu.auth.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gu.auth.model.ApprovalStage;
import com.gu.auth.model.Student;
import com.gu.auth.service.StudentService;




/**
 * Important - We are using the test version of servlet-context.xml. It is a copy of the
 * servlet-context.xml with Tiles removed. There was a problem loading the tiles with
 * SpringJUnit4ClassRunner.
 * 
 * @author dl121z
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ApprovalStageDaoTest extends TestCase{

    @Autowired 
    private ApprovalStageDAO approvalStageDAO;

    @Test
    public void insertApprovalStage() 
    {  
        //approvalStageDAO.insertApprovalStage(new ApprovalStage(3,1,1,2));      	      
    }
    
    @Test
    public void getAllApprovalStages() 
    {  
        for (ApprovalStage approvalStage : approvalStageDAO.getAllApprovalStages())
        {
        	System.out.println(approvalStage.toString());
        	
        }
    }
}
