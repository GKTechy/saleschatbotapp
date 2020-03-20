package com.app.saleschatbotapp.chat;

public interface SalesChatDao {

	SalesChatModel getSalesChat();

	SalesChatModel getAllSalesBranches();

	SalesChatModel startChat();

	SalesChatModel getValues(String payload);

}
