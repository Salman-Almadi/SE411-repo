package edu.psu.se411.lab09_inventory.model;

public class Books extends Items{
private String author;

public Books(String name, int id, String author) {
	super(name, id);
	this.author = author;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	if(author == null || author.isEmpty()) {
		throw new IllegalArgumentException("Author cannot be null or empty");
	}
	this.author = author;
}

}
