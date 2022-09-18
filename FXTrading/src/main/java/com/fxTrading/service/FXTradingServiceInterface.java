package com.fxTrading.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fxTrading.entity.BookedTrade;
import com.fxTrading.entity.User;

public interface FXTradingServiceInterface {
	
	
	public String exchangeRate(User userDetails);
	
	public String bookTrade(String bookingConfirmation);
	
	public List<BookedTrade> printBookedTrade();
	
	public Page<BookedTrade> paginationAndSortedBookedTrade(int pageNo, int pageSize, String sortBy);

}
