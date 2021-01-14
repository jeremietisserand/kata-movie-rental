package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<Rental>();

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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : rentals) {
            frequentRenterPoints += each.computeRenterPoints();
            result.append(each.displayRental());
            totalAmount += each.computeRental();
        }
        // add footer lines
        appendFooterLines(totalAmount, frequentRenterPoints, result);
        return result.toString();
    }

    private void appendFooterLines(double totalAmount, int frequentRenterPoints, StringBuilder result) {
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
    }
}
