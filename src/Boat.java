public class Boat extends Vehicle{

    private double cleaningPrice;

    public Boat(String regNumber, String brand, double basePricePerDay, double cleaningPrice) {
        super(regNumber, brand, basePricePerDay);
        this.cleaningPrice = cleaningPrice;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days+cleaningPrice;
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return 0;
    }
    @Override
    public String describe() {      //Returns description from the superclass vehicle.
        return super.describe()     // + subclass specific attribute (cleaningPrice).
                + " | Cleaning price: " + cleaningPrice;
    }
}
