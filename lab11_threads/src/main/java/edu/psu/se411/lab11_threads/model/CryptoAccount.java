package edu.psu.se411.lab11_threads.model;

import edu.psu.se411.lab11_threads.exceptions.InsufficientBalanceException;

public class CryptoAccount {
	private String id;
	private Double balance;
	
	public CryptoAccount(String id, Double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public void addToBalance(double amount) {
		// TODO
		if(amount < 0) throw new IllegalArgumentException();
		balance += amount;
	}
	
	public void retrieveFromBalance(double amount) throws InsufficientBalanceException {
		// TODO
		if(amount < 0) throw new IllegalArgumentException();
		if(balance < amount) throw new InsufficientBalanceException("insufficient balance");
		balance -= amount;
	}
	
	public String getId() {
		return id;
	}
	public Double getBalance() {
		return balance;
	}
	
}
