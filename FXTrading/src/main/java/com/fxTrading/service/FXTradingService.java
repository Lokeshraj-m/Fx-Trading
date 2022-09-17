package com.fxTrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fxTrading.entity.BookedTrade;
import com.fxTrading.entity.User;
import com.fxTrading.repository.PrintRepository;

@Service
public class FXTradingService {

	@Autowired
	PrintRepository printRepository;

	// Created the object for User to Store the User Details and accessing it inside
	// the FXTraadingService...
	private User book = new User();
	// To access it inside the FXTradingService and made it as a final...
	private static final double usdInrRate = 66.00;

	// To get the Exchange value...
	public String exchangeRate(User userDetails) {

		// Adding the Required data to the user...
		book.setCustomerName(userDetails.getCustomerName());
		book.setCurrencyPair(userDetails.getCurrencyPair());
		book.setTransferAmount(userDetails.getTransferAmount());
		// Converting the Currency Value From USD to INR....
		double converted = userDetails.getTransferAmount() * usdInrRate;
		// verifying that the User need Exchange Rate or Not....
		if (userDetails.getGetRate().equalsIgnoreCase("YES")) {
			return "You are Transferring INR " + converted + " to " + userDetails.getCustomerName()
					+ ".\n(Assuming that the rate was " + usdInrRate + "...)";
		} else {
			return "Ok...Book or Cancel the Trade...";
		}

	}

	// To confirm the booking Status and adding the booking details into the
	// database...
	public String bookTrade(String bookingConfirmation) {
		if (bookingConfirmation.equalsIgnoreCase("BOOK")) {
			double converted = book.getTransferAmount() * usdInrRate;
			printRepository
					.save(new BookedTrade(0, book.getCurrencyPair(), book.getCustomerName(), converted, usdInrRate));
			return "Trade for USDINR has been booked with rate " + usdInrRate + "," + "The amount of RS " + converted
					+ " will be transferred in 2 working days to " + book.getCustomerName() + ".";
		} else {
			return "Trade is Cancelled...";
		}

	}

	// To get the booking details from the Database...
	public List<BookedTrade> printBookedTrade() {
		return printRepository.findAll();
	}

	// To Print the booked in pagination and sorting with respect to field name...
	public Page<BookedTrade> paginationAndSortedBookedTrade(int pageNo, int pageSize, String sortBy) {
		return printRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(Direction.ASC, sortBy)));
	}
}
