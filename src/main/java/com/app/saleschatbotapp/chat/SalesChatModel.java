package com.app.saleschatbotapp.chat;

import java.util.List;

import org.json.simple.JSONArray;

import com.app.saleschatbotapp.chat.Entity.Branches;
import com.app.saleschatbotapp.chat.Entity.Buttons;
import com.app.saleschatbotapp.chat.Entity.Sales;

public class SalesChatModel {

	public String responseMsg;
	public JSONArray responseArray;
	public Sales sales;
	public List<Sales> saleslist;
	public List<Branches> brancheslist;
	public List<Buttons> buttonList;
	
	
	
	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}
	/**
	 * @param responseMsg the responseMsg to set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	/**
	 * @return the responseArray
	 */
	public JSONArray getResponseArray() {
		return responseArray;
	}
	/**
	 * @param responseArray the responseArray to set
	 */
	public void setResponseArray(JSONArray responseArray) {
		this.responseArray = responseArray;
	}
	/**
	 * @return the sales
	 */
	public Sales getSales() {
		return sales;
	}
	/**
	 * @param sales the sales to set
	 */
	public void setSales(Sales sales) {
		this.sales = sales;
	}
	/**
	 * @return the saleslist
	 */
	public List<Sales> getSaleslist() {
		return saleslist;
	}
	/**
	 * @param saleslist the saleslist to set
	 */
	public void setSaleslist(List<Sales> saleslist) {
		this.saleslist = saleslist;
	}
	/**
	 * @return the brancheslist
	 */
	public List<Branches> getBrancheslist() {
		return brancheslist;
	}
	/**
	 * @param brancheslist the brancheslist to set
	 */
	public void setBrancheslist(List<Branches> brancheslist) {
		this.brancheslist = brancheslist;
	}
	/**
	 * @return the buttonList
	 */
	public List<Buttons> getButtonList() {
		return buttonList;
	}
	/**
	 * @param buttonList the buttonList to set
	 */
	public void setButtonList(List<Buttons> buttonList) {
		this.buttonList = buttonList;
	}
	
	
}
