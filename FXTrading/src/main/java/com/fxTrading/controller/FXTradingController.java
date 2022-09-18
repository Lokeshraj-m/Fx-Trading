package com.fxTrading.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxTrading.entity.BookedTrade;
import com.fxTrading.entity.User;
import com.fxTrading.service.FXTradingService;

@RestController
public class FXTradingController {
	
		
	@Autowired
	FXTradingService fxTradingService;

	// To Get the User Details...
	// To Display the Exchange value of the Trade...
	@PostMapping("exchangeRate")
	public String exchangeRate(@RequestBody @Valid User bookingDetails) {

		return fxTradingService.exchangeRate(bookingDetails);
	}

	// To Book or Cancel the Trade...
	@PostMapping("exchangeRate/{bookingConfirmation}")
	public String bookTrade(@PathVariable String bookingConfirmation) {
		return fxTradingService.bookTrade(bookingConfirmation);
	}

	// To Print the Booked Trade Details from the DataBase...
	@GetMapping("printTrade")
	public java.util.List<BookedTrade> printBookedTrade() {
		return fxTradingService.printBookedTrade();
	}

	// To print the booked trade details from the DataBase in Pagination and sorting
	// the data through the field..
	@GetMapping("printTrade/pageNo={pageNo}/pageSize={pageSize}/sort={field}")
	public Page<BookedTrade> paginationAndSortedBookedTrade(@PathVariable int pageNo, @PathVariable int pageSize,
			@PathVariable String field) {
		return fxTradingService.paginationAndSortedBookedTrade(pageNo, pageSize, field);
	}
	@RequestMapping("/Exit")
	public String shutdown() {
		return "Have a Great Day...";
	}

}
