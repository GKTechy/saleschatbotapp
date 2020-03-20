package com.app.saleschatbotapp.chat.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branches")
public class Branches {
	
	
	@Id
	@Column(name ="branchId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int branchId;
	
	@Column(name = "branchName")
	private String branchName;

	
	public Branches(int branchId, String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}
	
	

	/**
	 * @return the branchId
	 */
	public int getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		return "Branches [branchId=" + branchId + ", branchName=" + branchName + "]";
	}

	
	
	
	
}
