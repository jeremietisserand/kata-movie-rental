package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Double computeRental() {
        Movie.MovieType movieType = movie.getMovieType();
        double rentalPrice = movieType.getFixedPrice();
        if(daysRented > movieType.getMaximumDaysWithConstantPrice()) {
            rentalPrice += (daysRented - movieType.getMaximumDaysWithConstantPrice()) * movieType.getExtraPricePerDay();
        }
        return rentalPrice;
    }

    public int computeRenterPoints() {
        if ((movie.getPriceCode() == Movie.MovieType.NEW_RELEASE.getPriceCode()) && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    public String displayRental() {
        return "\t" + movie.getTitle() + "\t" + computeRental() + "\n";
    }
}
