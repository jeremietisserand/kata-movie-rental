package movierental;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;


public class RentalTest {
    @Test
    public void shouldRegularMovie_rentedLessThanTwoDays_hasAFixedPrice() {
        Rental rental = new Rental(new Movie("Jaws", Movie.REGULAR), 2);

        Double rentalAmount = rental.computeRental();

        assertEquals(2.0, rentalAmount);
    }

    @Test
    public void shouldRegularMovie_rentedMoreThanTwoDays_haveFeesPerExtraDay() {
        Rental rental = new Rental(new Movie("Jaws", Movie.REGULAR), 5);

        Double rentalAmount = rental.computeRental();

        assertEquals(6.5, rentalAmount);
    }
}
