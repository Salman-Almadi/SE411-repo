package edu.psu.se411.lab09_inventory.model;

public class ElectronicDevice extends Items {
private String category;

public ElectronicDevice(String name, int id, String category) {
	super(name, id);
	this.category = category;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}


}
