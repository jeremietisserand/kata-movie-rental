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
        if (Movie.NEW_RELEASE == movie.getPriceCode()) {
            return computeNewRealeasePrice();
        }
        if (Movie.CHILDRENS == movie.getPriceCode()) {
            return computeChildrensPrice();
        }
        return computeRegularPrice();
    }

    private double computeRegularPrice() {
        double rentalPrice = 2d;
        if(daysRented > 2) {
            rentalPrice += (daysRented - 2) * 1.5;
        }
        return rentalPrice;
    }

    private double computeChildrensPrice() {
        double rentalPrice = 1.5d;
        if(daysRented > 3) {
            rentalPrice += (daysRented - 3) * 1.5;
        }
        return rentalPrice;
    }

    private double computeNewRealeasePrice() {
        return daysRented * 3d;
    }

    public int computeRenterPoints() {
        if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    public String displayRental() {
        return "\t" + movie.getTitle() + "\t" + computeRental() + "\n";
    }
}
