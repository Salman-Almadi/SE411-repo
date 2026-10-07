package edu.psu.se411.lab09_inventory.model;

public abstract class Items {
private String name;
private int id;

public Items(String name, int id) {
	this.name = name;
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	if(name ==null || name.isEmpty()) {
		throw new IllegalArgumentException("Name cannot be null or empty");
	}
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


}
