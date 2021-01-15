package movierental;

import java.util.Collection;

public class CustomerRentalSummary {

    private final double amountOwed;
    private final int frequentRenterPoints;

    public CustomerRentalSummary(double amountOwed, int frequentRenterPoints) {
        this.amountOwed = amountOwed;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public static CustomerRentalSummary buildFromRentals(Collection<Rental> rentals) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental each : rentals) {
            frequentRenterPoints += each.computeRenterPoints();
            totalAmount += each.computeRental();
        }
        return new CustomerRentalSummary(totalAmount, frequentRenterPoints);
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String displaySummary() {
        return "Amount owed is " + amountOwed + "\n"
                + "You earned " + frequentRenterPoints + " frequent renter points";
    }
}
