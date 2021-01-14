package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public Double computeRental() {
        Double rentalPrice= 2d;
        if(_daysRented > 2) {
            rentalPrice += (_daysRented - 2) * 1.5;
        }
        return rentalPrice;
    }
}
