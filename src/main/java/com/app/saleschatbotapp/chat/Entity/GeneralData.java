package com.app.saleschatbotapp.chat.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="generaldata")
public class GeneralData {
	
	
	@Id
	@Column(name ="access_id")
	private String accessId;
	
	@Column(name = "seq_no")
	private String seqNo;

	
	@Column(name = "display_value")
	private String displayValue;

	@Column(name = "display_type")
	private String displayType;

	
	
	/**
	 * 
	 */
	public GeneralData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * @param accessId
	 * @param seqNo
	 * @param displayValue
	 * @param displayType
	 */
	public GeneralData(String accessId, String seqNo, String displayValue, String displayType) {
		super();
		this.accessId = accessId;
		this.seqNo = seqNo;
		this.displayValue = displayValue;
		this.displayType = displayType;
	}



	/**
	 * @return the accessId
	 */
	public String getAccessId() {
		return accessId;
	}

	/**
	 * @param accessId the accessId to set
	 */
	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	/**
	 * @return the seqNo
	 */
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return the displayValue
	 */
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * @param displayValue the displayValue to set
	 */
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	/**
	 * @return the displayType
	 */
	public String getDisplayType() {
		return displayType;
	}

	/**
	 * @param displayType the displayType to set
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "GeneralData [accessId=" + accessId + ", seqNo=" + seqNo + ", displayValue=" + displayValue
				+ ", displayType=" + displayType + "]";
	}

	
	
}
