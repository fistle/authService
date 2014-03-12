package com.gu.auth.dao;


import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gu.auth.model.Student;


@Repository("studentDAO")
public class StudentDAO extends BaseDAO{
	
	 @SuppressWarnings("unchecked")
		public List<Student> getAllStudents()
		{			 
	     	return getSession().createQuery("from Student where sex = 'Male'").list();			 
		}
	
            
	 @SuppressWarnings("unchecked")
	public List<Student> getStudents(String id){

	    	   
	    	   try {
	    		   org.hibernate.Transaction tx = getSession().beginTransaction();
	    		   	         
	    		   List<Student> students = (List<Student>) getSession().createCriteria(Student.class).add(Restrictions.in("prodID", new String[] {id})).list();
	    		   	         
	    		   tx.commit();
	    		   getSession().close(); 
	    		   
	    		   return students;
	    		   	        }
	    		   	        catch (HibernateException e) {
	    		   	            e.printStackTrace();
	    		   	         getSession().getTransaction().rollback();
	    		   	        }

	       return null;
	}
	 
	 
	 @SuppressWarnings("unchecked")
	public List<Student> getStudentList(String id){
		 
		 return (List<Student>) getSession().createSQLQuery(
				    "select * from SYSADM.PS_UOG_QV_STD_ENRL WHERE UOG_PLN_EMPLID = :id")
				    .addEntity(Student.class)
				    .setParameter("id", id).list(); 
		 
	}
	 

	 
	 
	 
	
	 
	 
	 
	 
}
