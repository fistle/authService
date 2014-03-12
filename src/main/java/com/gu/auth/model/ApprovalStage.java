package com.gu.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="APPROVALSTAGES")
public class ApprovalStage {
	
	 @Id
     @Column(name="SYSTEMID")
     private int systemId;
    
     @Column(name="ACCESSLEVELID")
     @NotNull @Min(13) @Max(120)
     private int accessLevelId;
     
     @Column(name="APPROVALSTAGE")
     private int approvalStage;
     
     @Column(name="ALLANYMULTIPLE")
     private int allanyMultiple;
     
     public ApprovalStage(){}
     
     public ApprovalStage(int systemId, int accessLevelId, int approvalStage, int allanyMultiple)
     {
    	 this.systemId = systemId;
    	 this.accessLevelId = accessLevelId;
    	 this.approvalStage = approvalStage;
    	 this.allanyMultiple = allanyMultiple;
    	 
    	 
     }

	@Override
	public String toString() {
		return "ApprovalStage [systemId=" + systemId + ", accessLevelId="
				+ accessLevelId + ", approvalStage=" + approvalStage
				+ ", allanyMultiple=" + allanyMultiple + "]";
	}

	public int getSystemId() {
		return systemId;
	}

	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}

	public int getAccessLevelId() {
		return accessLevelId;
	}

	public void setAccessLevelId(int accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	public int getApprovalStage() {
		return approvalStage;
	}

	public void setApprovalStage(int approvalStage) {
		this.approvalStage = approvalStage;
	}

	public int getAllanyMultiple() {
		return allanyMultiple;
	}

	public void setAllanyMultiple(int allanyMultiple) {
		this.allanyMultiple = allanyMultiple;
	}
     

}
