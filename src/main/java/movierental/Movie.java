package movierental;

public class Movie {

    private final String title;
    private final MovieType movieType;

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    enum MovieType {
        CHILDREN(2, 1.5d, 1.5d, 3),
        NEW_RELEASE(1, 0d, 3d, 0),
        REGULAR(0, 2d, 1.5d, 2);

        private final int priceCode;

        private final double fixedPrice;

        private final double extraPricePerDay;

        private final int maximumDaysWithConstantPrice;

        MovieType(int priceCode, double fixedPrice, double extraPricePerDay, int maximumDaysWithConstantPrice) {
            this.priceCode = priceCode;
            this.fixedPrice = fixedPrice;
            this.extraPricePerDay = extraPricePerDay;
            this.maximumDaysWithConstantPrice = maximumDaysWithConstantPrice;
        }

        public int getPriceCode() {
            return priceCode;
        }

        public double getFixedPrice() {
            return fixedPrice;
        }

        public double getExtraPricePerDay() {
            return extraPricePerDay;
        }

        public int getMaximumDaysWithConstantPrice() {
            return maximumDaysWithConstantPrice;
        }
    }

    public int getPriceCode() {
        return movieType.getPriceCode();
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public String getTitle() {
        return title;
    }
}