package com.app.saleschatbotapp.chat;

public interface SalesChatService {
		

	SalesChatModel startChat();
	SalesChatModel chatmsg(String message, String sender, String payload);
}
