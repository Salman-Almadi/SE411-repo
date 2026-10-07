package edu.psu.se411.lab09_inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.psu.se411.lab09_inventory.model.*;


public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		logger.info("Application is starting...");
		
		Inventory<Items> inventory = new Inventory<>();
		inventory.addItem(new Books("The Great Gatsby", 1, "F. Scott Fitzgerald"));
		inventory.addItem(new Books("To Kill a Mockingbird", 2, "Harper Lee"));
		inventory.addItem(new Books("1984", 3, "George Orwell"));
		inventory.addItem(new ElectronicDevice("Laptop", 4, "Computers"));
		inventory.addItem(new ElectronicDevice("Headphones", 5, "Audio"));
		
		logger.info("Seeded inventory with {} items.", inventory.getItems().size());
		
		
		logger.info("Application is closing...");
	}

}
