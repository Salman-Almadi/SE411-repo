package edu.psu.se411.lab11_threads.model;

import edu.psu.se411.lab11_threads.exceptions.InsufficientBalanceException;

public class Transaction implements Runnable {
	private String id;
	private CryptoAccount sender;
	private CryptoAccount receiver;
	private double amount;
	
	public Transaction(String id, CryptoAccount sender, CryptoAccount receiver, double amount2) {
		super();
		if(id == null || sender == null || receiver == null || amount2 < 0) throw new IllegalArgumentException();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount2;
	}
	
	public void execute() {
		if(sender.getBalance() >= amount){
			try {
				sender.retrieveFromBalance(amount);
			} catch (InsufficientBalanceException e) {
				throw new IllegalArgumentException("Insufficient balance in sender account", e);
			}
			receiver.addToBalance(amount);
		}
		
		else {
			throw new IllegalArgumentException("Insufficient balance in sender account");
		}
	}

	@Override
	public void run() {
		execute();
	}
	
	public CryptoAccount getSender() {
		return sender;
	}
	public void setSender(CryptoAccount sender) {
		this.sender = sender;
	}
	public CryptoAccount getReceiver() {
		return receiver;
	}
	public void setReceiver(CryptoAccount receiver) {
		this.receiver = receiver;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
}
