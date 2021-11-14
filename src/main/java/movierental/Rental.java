package movierental;

public class Rental {

    private Movie movie;
	private int daysRented;
	
	/** Initialize a new movie rental object for
	 * a movie with known rental period (daysRented).
	 */
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @return the daysRented
	 */
	public int getDaysRented() {
		return daysRented;
	}

}