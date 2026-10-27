package edu.psu.se411.lab12_threads.model;

import java.util.concurrent.locks.*;

import edu.psu.se411.lab12_threads.exceptions.InsufficientBalanceException;

public class CryptoAccount implements Comparable{
	private String id;
	private Double balance;
	private Lock lock = new ReentrantLock();
	
	public CryptoAccount(String id, Double balance) {
		if(balance < 0) throw new IllegalArgumentException("Account balance cannot be negative");
		this.id = id;
		this.balance = balance;
	}
	
	public Lock getLock() { //when using this lock, sometimes a deadlock occures
		return lock;
	}
	
	public void addToBalance(Double amount) {
		if(amount < 0) throw new IllegalArgumentException("Amount added to balance cannot be negative");
		balance += amount;
	}
	
	public void retrieveFromBalance(Double amount) throws InsufficientBalanceException {
		if(amount > balance) throw new InsufficientBalanceException(id);
		balance -= amount;
	}
	
	public String getId() {
		return id;
	}
	public Double getBalance() {
		return balance;
	}

	@Override
	public int compareTo(Object other) {
		if(id.compareTo((CryptoAccount)other).getId()>0) return 1;
		else if (id.compareTo((CryptoAccount)other).getId()<0) return -1;

		return 0;
	}
	
	
	
}
