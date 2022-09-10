package com.fxTrading.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.fxTrading.entity.Print;
@Repository
public class PrintDao {
	static ArrayList<Print> bookedTradeList = new ArrayList<>();

	public static void addBooking(int tradeNo, String currencyPair, String customerName, double amount, double rate) {
		bookedTradeList.add(new Print(tradeNo, currencyPair, customerName, amount, rate));
	}

	public ArrayList<Print> printTrade() {
		return bookedTradeList;
	}
}
