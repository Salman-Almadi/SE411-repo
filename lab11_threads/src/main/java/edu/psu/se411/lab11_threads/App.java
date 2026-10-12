package edu.psu.se411.lab11_threads;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import edu.psu.se411.lab11_threads.model.CryptoAccount;

import edu.psu.se411.lab11_threads.model.Transaction;

/**
 * Build and run using Maven goal: clean package exec:java
 */
public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static Integer nbAccounts = 10;
	public static Double initialBalance = 10000.0;
	public static Integer nbTransactions = 10000;

	public static void main(String[] args) {
		logger.info("Application is starting...");
		
		// 1- Create accounts
		CryptoAccount[] accounts = new CryptoAccount[nbAccounts];
		Thread[] threads = new Thread[nbTransactions];
		for (Integer i = 0; i < nbAccounts; i++) {
			accounts[i] = new CryptoAccount("acc_" + i.toString(), initialBalance);
		}
		
		// TODO
		
		// 2 - Create all transactions and execute them in separate threads
		for (Integer i = 0; i < nbTransactions; i++) {
			CryptoAccount sender = accounts[(int)(Math.random() * nbAccounts)];
			CryptoAccount receiver = accounts[(int)(Math.random() * nbAccounts)];
			int amount = (int) (Math.random() * 100);
			Transaction t = new Transaction("Trx" + i, sender, receiver, amount);
			Thread thread = new Thread(t);
			threads[i] = thread;
			thread.start();
		}
		
		
		// 3 - Wait for all threads to finish
		for(int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 4 - verify that the total balance is still the same
		System.out.println("Total balance after transactions: " + getBalance(accounts));

		logger.info("Application is closing...");
	}

	private static Double getBalance(CryptoAccount[] accounts) {
		Double total = 0.0;
		for (CryptoAccount account : accounts) {
			total += account.getBalance();
		}
		return total;
	}

}
