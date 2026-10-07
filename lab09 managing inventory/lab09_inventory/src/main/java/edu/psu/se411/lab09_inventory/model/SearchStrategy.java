package edu.psu.se411.lab09_inventory.model;

public interface SearchStrategy <T>{
	
	boolean matches(T item, String searchTerm);
	
}
