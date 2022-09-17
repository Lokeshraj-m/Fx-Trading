package com.fxTrading.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// This class contains getters and setters, to string, constructor and validation....
public class User {
	// Customer Name must be minimum of 4 Characters...
	@Size(min = 4, message = "Name must be min of 4 characters...")
	// Customer Name is Validated by using regex it should contain only letters, dot
	// and spaces...
	@Pattern(regexp = "[A-Za-z\\s.]*", message = "Invalid Customer Name.. Enter only Letters and Spaces...")
	@NotEmpty
	private String customerName;
	@NotEmpty
	// Currency pair are validated by using regex...
	@Pattern(regexp = "^(USDINR)$", message = "Invalid Currency Pair")
	private String currencyPair;
	@NotNull
	// Transfer amount must be above 1....
	@Min(value = 1, message = "Inavlid Amount...Enter Valid amount...")
	private float transferAmount;
	@NotEmpty
	// It should contain only Yes or No to validate regex concept is used...
	@Pattern(regexp = "^(yes|YES|NO|no|Yes|No)*", message = "Invalid Entry... Enter Yes or No...")
	private String getRate;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public float getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(float transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getGetRate() {
		return getRate;
	}

	public void setGetRate(String getRate) {
		this.getRate = getRate;
	}

	@Override
	public String toString() {
		return "Book [customerName=" + customerName + ", currencyPair=" + currencyPair + ", transferAmount="
				+ transferAmount + ", getRate=" + getRate + "]";
	}

	public User(String customerName, String currencyPair, float transferAmount, String getRate) {
		super();
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.transferAmount = transferAmount;
		this.getRate = getRate;
	}

	public User() {

	}

}
