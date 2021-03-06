package movierental;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * A customer who rents movies.
 * The customer object holds information about the
 * movies rented for the current billing period,
 * and can print a statement of his rentals.
 */
public class Customer {
	/** Customer's name. */
	private String name;
	/** Customer's rentals for current billing period. */
	private List<Rental> rentals;
	
	/** Initialize a new customer. */
	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<Rental>();
	}
	
	public void addRental(Rental rental) {
		if (!rentals.contains(rental)) {
			rentals.add(rental);
		}
	}
	
	public String getName() {
		return name;
	}
	
	/** Print all the rentals in current period, 
	 * along with total charges and reward points.
	 * @return the statement as a String
	 */
	public String statement() {
		double totalAmount = 0; // total charges
		int frequentRenterPoints = 0; // frequent renter points
		String stmt = "Rental Report for " + getName() + "\n\n";
		// header for details section
		stmt += composeHeader();

		for (Rental rental: rentals) {
			// compute rental change
			totalAmount += computeRentalAmount(rental);
			// award renter points for each rental
			frequentRenterPoints += getFrequentRenterPoints(rental);
			// one line of detail for this movie
			stmt += computeStatementLine(rental);
		}

		stmt += composeFooter(totalAmount, frequentRenterPoints);		
		return stmt;
	}

	public String composeHeader() {
		return "Rental Report for " + getName() + "\n\n" 
			+ String.format("%-40.40s %4s %-8s\n", "Movie Title", "Days", "Price");
	}

	public String composeFooter(double totalAmount, int frequentRenterPoints) {
		return "Total amount owed: " + totalAmount +
			   "\nFrequent renter points earned: " + frequentRenterPoints;
	}

	public double computeRentalAmount(Rental rental) {
		double amount = 0;
		switch( rental.getMovie().getPriceCode() ) {
			case Movie.REGULAR:
				amount = 2;
				if (rental.getDaysRented() > 2) {
					amount += 1.5 * (rental.getDaysRented() - 2);
				}
				break;
			case Movie.CHILDRENS:
				amount = 1.5;
				if (rental.getDaysRented() > 3) {
					amount += 1.5 * (rental.getDaysRented() - 3);
				}
				break;
			case Movie.NEW_RELEASE:
				amount = 3*rental.getDaysRented();
				break;
			default:
				getLogger().warning("Movie "+rental.getMovie()+" has unrecognized priceCode "+rental.getMovie().getPriceCode());
		}
		rental.setCharge(amount);
		return amount;
	}

	public int getFrequentRenterPoints(Rental rental) {
		if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) {
			return rental.getDaysRented();
		} 
		return 1;
	}

	public String computeStatementLine(Rental rental) {
		return String.format("%-40.40s %4d %.2f\n", rental.getMovie().getTitle(), rental.getDaysRented(), rental.getCharge());
	}

	/** Get a logger object. */
	private static Logger getLogger() {
		return Logger.getLogger(Customer.class.getName());
	}
	
}