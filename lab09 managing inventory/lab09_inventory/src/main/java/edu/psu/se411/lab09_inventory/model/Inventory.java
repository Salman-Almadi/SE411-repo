package edu.psu.se411.lab09_inventory.model;

import java.util.*;

public class Inventory<T> {
	private List <T> items;
	
	public Inventory() {
		this.items = new ArrayList<T>();
	}
	
	public void addItem(T item) {
		if(item == null) {
			throw new IllegalArgumentException("Item cannot be null");
		}
		items.add(item);
	}
	
	public void removeItem(T item) {
		if(item == null) {
			throw new IllegalArgumentException("Item cannot be null");
		}
		items.remove(item);
	}
	
	public List<T> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	public List<T> searchItems(String query) {
		if(query == null || query.isEmpty()) {
			throw new IllegalArgumentException("Query cannot be null or empty");
		}
		List<T> results = new ArrayList<T>();
		for(T item : items) {
			if(item.toString().toLowerCase().contains(query.toLowerCase())) {
				results.add(item);
			}
		}
		return results;
	}
	
}
