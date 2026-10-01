public class Boat extends Vehicle{

    private double cleaningPrice;
    private int boatLength;

    public Boat(String regNumber, String brand, double basePricePerDay, double cleaningPrice) {
        super(regNumber, brand, basePricePerDay);
        this.cleaningPrice = cleaningPrice;
        this.boatLength = boatLength;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days+cleaningPrice;
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return 200*days;
    }


    @Override
    public String describe() {      //Returns description from the superclass vehicle.
        return super.describe()     // + subclass specific attribute (cleaningPrice).
                + " | Cleaning price: " + cleaningPrice + " | Boat length: " + boatLength;
    }
}
