package com.app.saleschatbotapp.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesChatController {
	
	@Autowired
	SalesChatService saleschatservice;
	
	
	@PostMapping("/api/sendInput")
	@ResponseBody
	public SalesChatModel chatmsg(@RequestParam("inputmessage") String message,@RequestParam("sender") String sender,@RequestParam("payload") String payload) {
		SalesChatModel responseModel = new SalesChatModel();
		try {
			responseModel =saleschatservice.chatmsg(message,sender,payload);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	@GetMapping("/api/startChat")
	@ResponseBody
	public SalesChatModel startChat() {
		SalesChatModel responseModel = new SalesChatModel();
		try {
			responseModel =saleschatservice.startChat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseModel;
	}
}
