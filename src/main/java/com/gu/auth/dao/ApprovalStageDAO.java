package com.gu.auth.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gu.auth.model.ApprovalStage;

@Repository("approvalStageDAO")
public class ApprovalStageDAO extends BaseDAO{
	
	 @SuppressWarnings("unchecked")
	 public List<ApprovalStage> getAllApprovalStages()
	 {			 
	     	return getSession().createQuery("from ApprovalStage").list();			 
	 }
	 
	 public void insertApprovalStage(ApprovalStage approvalStage)
	 {		
		 Session session = getSession();
		 
		 session.getTransaction().begin();		 
		 session.save(approvalStage);		     	
		 session.getTransaction().commit();
	 }	 
}
