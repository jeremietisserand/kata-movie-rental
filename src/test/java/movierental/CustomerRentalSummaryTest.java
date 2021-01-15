package movierental;

import static junit.framework.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class CustomerRentalSummaryTest {

    @Test
    public void displaySummary() {
        CustomerRentalSummary customerRentalSummary = new CustomerRentalSummary(5d, 2);

        String expected = "Amount owed is 5.0\n" +
                "You earned 2 frequent renter points";

        assertEquals(expected, customerRentalSummary.displaySummary());
    }

    @Test
    public void shouldBuildCustomerRentalSummary_fromRentals_whenUserHasNoRental() {
        CustomerRentalSummary customerRentalSummary = CustomerRentalSummary.buildFromRentals(Collections.emptyList());

        assertEquals(0d, customerRentalSummary.getAmountOwed());
        assertEquals(0, customerRentalSummary.getFrequentRenterPoints());
    }

    @Test
    public void shouldBuildCustomerRentalSummary_fromRentals_whenUserHasRentals() {
        List<Rental> rentals = Stream.of(new Rental(new Movie("Jaws", Movie.MovieType.REGULAR), 2),
                new Rental(new Movie("Golden Eye", Movie.MovieType.REGULAR), 3))
                .collect(Collectors.toList());

        CustomerRentalSummary customerRentalSummary = CustomerRentalSummary.buildFromRentals(rentals);

        assertEquals(5.5, customerRentalSummary.getAmountOwed());
        assertEquals(2, customerRentalSummary.getFrequentRenterPoints());
    }
}
