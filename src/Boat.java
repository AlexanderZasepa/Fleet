public class Boat extends Vehicle implements Rentable{

    private double cleaningPrice;

    public Boat(String regNumber, String brand, double basePricePerDay, double cleaningPrice) {
        super(regNumber, brand, basePricePerDay);
        this.cleaningPrice = cleaningPrice;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days+cleaningPrice;
    }
}
