package edu.psu.se411.lab09_inventory.model;

public class searchByName implements SearchStrategy<Items> {
	private String name;

	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public searchByName(String name) {
		this.name = name;
	}

	@Override
	public boolean matches(Items item, String searchTerm) {
		return item.getName().equalsIgnoreCase(searchTerm);	}

	}
	

