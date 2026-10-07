package edu.psu.se411.lab09_inventory.model;

public class searchbyCatergory implements SearchStrategy<ElectronicDevice> {
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean matches(ElectronicDevice item, String searchTerm) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null");
		}
		if (searchTerm == null || searchTerm.isEmpty()) {
			throw new IllegalArgumentException("Search term cannot be null or empty");
		}
		return item.getCategory() != null && item.getCategory().equalsIgnoreCase(searchTerm);
	}
}
