package edu.psu.se411.lab07.module;

public class TrainBooking extends booking {
	private String SeatClass;
	private double distance;

	public TrainBooking(String bookingId, String customerName, String bookingDate, String bookingTime, 
					int ticketPrice, int numberOfStops) {
		super(bookingId, customerName, bookingDate, bookingTime);
		if (ticketPrice < 0) {
			throw new IllegalArgumentException("Ticket price cannot be negative");
		}
		if (numberOfStops < 0) {
			throw new IllegalArgumentException("Number of stops cannot be negative");
		}
		this.SeatClass = SeatClass;
		this.distance = distance;
	}
	
	public String getSeatClass() {
		return SeatClass;
	}
	
	public void setSeatClass(String seatClass) {
		if (seatClass == null || seatClass.trim().isEmpty()) {
			throw new IllegalArgumentException("Seat class cannot be null or empty");
		}
		this.SeatClass = seatClass;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		if (distance < 0) {
			throw new IllegalArgumentException("Distance cannot be negative");
		}
		this.distance = distance;
	}
	
	public double calculateTotalCost() {
		double baseFare = 0;
		switch (SeatClass.toLowerCase()) {
			case "first":
				baseFare = 100; // Base fare for first class
				break;
			case "second":
				baseFare = 50; // Base fare for second class
				break;
			default:
				throw new IllegalArgumentException("Invalid seat class");
		}
		return baseFare + (distance * 0.5); // Assuming $0.5 per km
		
	}
	
	}