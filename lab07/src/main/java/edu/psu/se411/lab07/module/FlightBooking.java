package edu.psu.se411.lab07.module;

public class FlightBooking extends booking {
	private int TicketPrice;
	private int LuggageWeight;
	
	public FlightBooking(String bookingId, String customerName, String bookingDate, String bookingTime, 
					int ticketPrice, int luggageWeight) {
		super(bookingId, customerName, bookingDate, bookingTime);
		if (ticketPrice < 0) {
			throw new IllegalArgumentException("Ticket price cannot be negative");
		}
		if (luggageWeight < 0) {
			throw new IllegalArgumentException("Luggage weight cannot be negative");
		}
		this.TicketPrice = ticketPrice;
		this.LuggageWeight = luggageWeight;
	}
	
	public int getTicketPrice() {
		return TicketPrice;
	}
	
	public void setTicketPrice(int ticketPrice) {
		if (ticketPrice < 0) {
			throw new IllegalArgumentException("Ticket price cannot be negative");
		}
		this.TicketPrice = ticketPrice;
	}
	
	public int getLuggageWeight() {
		return LuggageWeight;
	}
	
	public void setLuggageWeight(int luggageWeight) {
		if (luggageWeight < 0) {
			throw new IllegalArgumentException("Luggage weight cannot be negative");
		}
		this.LuggageWeight = luggageWeight;
	}
	
	public double calculateTotalCost() {
		double extraLuggageFee = 0;
		if (LuggageWeight > 40) {
			extraLuggageFee = (LuggageWeight - 40) * 10; // Assuming $10 per kg for luggage over 40kg
		}
		return TicketPrice + (LuggageWeight * extraLuggageFee); // Assuming $10 per kg of luggage	}
}
}