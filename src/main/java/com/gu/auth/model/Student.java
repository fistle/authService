package com.gu.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYSADM.PS_UOG_QV_STD_ENRL")
public class Student {
           @Id
           @Column(name="UOG_PLN_EMPLID")
           private String prodID;
          
           @Column(name="UOG_PLN_FNAME")
           private String name;
           
           @Column(name="UOG_PLN_SEX")
           private String sex;
          
                      
           public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getProdID() {
                       return prodID;
           }

           public void setProdID(String prodID) {
                       this.prodID = prodID;
           }

           public String getName() {
                       return name;
           }

           public void setName(String name) {
                       this.name = name;
           }                      
}
