package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return displayRentalCustomerInfo(CustomerRentalSummary.buildFromRentals(rentals));
    }

    private String displayRentalCustomerInfo(CustomerRentalSummary summary) {
        return displayRentalRecordForCustomer() +
                rentals.stream().map(Rental::displayRental).reduce(String::concat).orElse("") +
                summary.displaySummary();
    }

    private String displayRentalRecordForCustomer() {
        return "Rental Record for " + getName() + "\n";
    }
}
