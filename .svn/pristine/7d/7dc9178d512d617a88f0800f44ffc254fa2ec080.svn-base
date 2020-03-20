package com.app.saleschatbotapp.chat.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sales {
	
	
	@Id
	@Column(name ="responseid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int responseId;
	
	@Column(name = "responsevalue")
	private String responseValue;

	
	public Sales() {
		super();
	}

	public Sales(int responseId, String responseValue) {
		super();
		this.responseId = responseId;
		this.responseValue = responseValue;
	}

	/**
	 * @return the responseId
	 */
	public int getResponseId() {
		return responseId;
	}

	/**
	 * @param responseId the responseId to set
	 */
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	/**
	 * @return the responseValue
	 */
	public String getResponseValue() {
		return responseValue;
	}

	/**
	 * @param responseValue the responseValue to set
	 */
	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}

	@Override
	public String toString() {
		return "Sales [responseId=" + responseId + ", responseValue=" + responseValue + "]";
	}
	
	
	
}
