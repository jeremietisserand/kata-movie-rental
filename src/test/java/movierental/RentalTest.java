package movierental;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;


public class RentalTest {
    @Test
    public void shouldRegularMovie_rentedLessThanTwoDays_hasAFixedPrice() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.REGULAR), 2);

        double rentalAmount = rental.computeRental();

        assertEquals(2.0, rentalAmount);
    }

    @Test
    public void shouldRegularMovie_rentedMoreThanTwoDays_haveFeesPerExtraDay() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.REGULAR), 5);

        double rentalAmount = rental.computeRental();

        assertEquals(6.5, rentalAmount);
    }

    @Test
    public void shouldNewRelease_rentedOneDay_costsThree() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.NEW_RELEASE), 1);

        double rentalAmount = rental.computeRental();

        assertEquals(3.0, rentalAmount);
    }

    @Test
    public void shouldChildrens_rentedLessThanThreeDays_hasAFixedPrice() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.CHILDREN), 2);

        double rentalAmount = rental.computeRental();

        assertEquals(1.5, rentalAmount);
    }

    @Test
    public void shouldChildrens_rentedMoreThanThreeDays_hasFeesPerExtraDay() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.CHILDREN), 4);

        double rentalAmount = rental.computeRental();

        assertEquals(3.0, rentalAmount);
    }
    
    @Test 
    public void computeRenterPoints_shouldReturnOne() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.REGULAR), 4);

        int renterPoints = rental.computeRenterPoints();

        assertEquals(1, renterPoints);
    }

    @Test
    public void computeRenterPoints_shouldReturnTwo_whenNewReleaseMovieAndRentedMoreThanOneDay() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.NEW_RELEASE), 2);

        int renterPoints = rental.computeRenterPoints();

        assertEquals(2, renterPoints);
    }

    @Test
    public void displayRental() {
        Rental rental = new Rental(new Movie("Jaws", Movie.MovieType.NEW_RELEASE), 2);

        String rentalDisplay = rental.displayRental();

        assertEquals("\tJaws\t6.0\n", rentalDisplay);
    }
}
