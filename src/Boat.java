public class Boat extends Vehicle{

    private double cleaningPrice;
    private int boatLength;

    public Boat(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, double cleaningPrice, int boatLength, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.cleaningPrice = cleaningPrice;
        this.boatLength = boatLength;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return super.calculateRentalPrice(days)+cleaningPrice;
    }


    @Override
    public double calculateInsurancePrice(int days) {
        return getInsurancePricePerDay()*days;
    }


    @Override
    public String describe() {
        return super.describe() + " | CLEANING FEE: " + cleaningPrice + " € | LENGTH: " + boatLength + "m";
    }
}
