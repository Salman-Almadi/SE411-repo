package edu.psu.se411.lab07.module;

public abstract class booking {
	private String bookingId;
	private String customerName;
	private String bookingDate;
	private String bookingTime;

	public booking(String bookingId, String customerName, String bookingDate, String bookingTime) {		
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		
	
	if (bookingId == null || bookingId.trim().isEmpty()) {
		throw new IllegalArgumentException("Booking ID cannot be null or empty");
	}
	if (customerName == null || customerName.trim().isEmpty()) {
		throw new IllegalArgumentException("Customer name cannot be null or empty");
	}
	if (bookingDate == null || bookingDate.trim().isEmpty()) {
		throw new IllegalArgumentException("Booking date cannot be null or empty");
	}
	if (bookingTime == null || bookingTime.trim().isEmpty()) {
		throw new IllegalArgumentException("Booking time cannot be null or empty");
	}

}

	public abstract double calculateTotalCost();}