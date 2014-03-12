package com.gu.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.auth.dao.StudentDAO;
import com.gu.auth.model.Student;


@Service("studentSvc")
public class StudentService {
     
      @Autowired
      private StudentDAO studentDAO;
      public void setStudentDAO(StudentDAO prodDAO) {
             this.studentDAO = prodDAO;
      }
      
      public List<Student> getStudent(String id){
             return studentDAO.getStudents(id);
      }
      
      public List<Student> getStudentList(String id){
          return studentDAO.getStudentList(id);
   }
      
      public List<Student> getAllStudents(){
          return studentDAO.getAllStudents();
   }
}
