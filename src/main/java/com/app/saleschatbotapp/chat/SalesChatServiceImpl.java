package com.app.saleschatbotapp.chat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SalesChatServiceImpl implements SalesChatService {

	@Autowired
	private SalesChatDao salesChatDao;
	
	@Override
	public SalesChatModel chatmsg(String message, String sender,String payload) {
		SalesChatModel responseModel = new SalesChatModel();
	    try {
		//	System.out.println("input->"+message);
			//System.out.println("sender->"+sender);
			System.out.println("payload->"+payload);
	
			try {
				
				if(payload.equalsIgnoreCase("0")) {
					JSONParser parser = new JSONParser();
					JSONArray responseArray = (JSONArray)parser.parse(pythonCall(message,sender)); //Python call
					if(responseArray.size() == 1) {
						JSONObject jsonObj = (JSONObject) responseArray.get(0);
					//	System.out.println("----"+jsonObj.get("text").toString());
						if(jsonObj.get("text").toString().equalsIgnoreCase("AllBranches")) {
								
							SalesChatModel sm = salesChatDao.getAllSalesBranches();
							jsonObj.put("buttons", sm.getButtonList());
							jsonObj.put("text", "Sales Branches List");
							
							JSONArray responseArray1 = new JSONArray();
							responseArray1.add(0, jsonObj);
							
							responseModel.setResponseArray(responseArray1);
						}else if(jsonObj.get("text").toString().equalsIgnoreCase("Hi How can I  help you?")){
							SalesChatModel res =startChat();
							responseModel.setResponseArray(res.getResponseArray());
						} else {
							responseModel.setResponseArray(responseArray);
						}
					}else {
						responseModel.setResponseArray(responseArray);
					}
					
				}else {
					SalesChatModel res =getValues(payload);
					responseModel.setResponseArray(res.getResponseArray());
				}
				
				
				
				
				/*
				 * for (int i = 0; i < array.size(); i++) { JSONObject jsonObj = (JSONObject)
				 * array.get(i); System.out.println(jsonObj.get("text")); }
				 */
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	    
		return responseModel;
	}
	
	public SalesChatModel getAllSalesBranches() {
		return salesChatDao.getSalesChat();
	}

	@Override
	public SalesChatModel startChat() {
		SalesChatModel responseModel = new SalesChatModel();
		JSONObject jsonObj = new JSONObject();
		
		try {
			SalesChatModel sm = salesChatDao.startChat();
			jsonObj.put("buttons", sm.getButtonList());
			jsonObj.put("text", "Hi How can I  help you? ");
			
			JSONArray responseArray1 = new JSONArray();
			responseArray1.add(0, jsonObj);
			
			responseModel.setResponseArray(responseArray1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseModel;
	}
	
	
	public String pythonCall(String message, String sender) {
		
		final String uri = "http://localhost:5005/webhooks/rest/webhook";
		
		RestTemplate restTemplate = new RestTemplate();
		 
		Map<String, String> params = new HashMap<String, String>();
		params.put("message",message);
		params.put("sender",sender);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(params, headers);
		 

		HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		 
		String resultString = response.getBody();
		HttpHeaders responseheaders = response.getHeaders();
		
		System.out.println("resultString----->"+resultString);
		System.out.println("responseheaders----->"+responseheaders);
		return resultString;
	}

	public SalesChatModel getValues(String payload) {
		SalesChatModel responseModel = new SalesChatModel();
		JSONObject jsonObj = new JSONObject();
		
		try {
			SalesChatModel sm = salesChatDao.getValues(payload);
			if(sm.getResponseMsg().equalsIgnoreCase("listValues")) {
				jsonObj.put("buttons", sm.getButtonList());
			}else {
				jsonObj.put("text", sm.getResponseMsg());	
			}
			
			
			JSONArray responseArray1 = new JSONArray();
			responseArray1.add(0, jsonObj);
			
			responseModel.setResponseArray(responseArray1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseModel;
	}


}
