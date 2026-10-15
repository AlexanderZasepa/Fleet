public class Boat extends Vehicle {
    //Private fields for subclass Boat
    private double cleaningPrice;
    private int boatLength;

    //Constructor
    public Boat(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, double cleaningPrice, int boatLength, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.cleaningPrice = cleaningPrice;
        this.boatLength = boatLength;

        //if statements exception. Shutdowns the program if exception is thrown.
        if (cleaningPrice <= 0) throw new IllegalArgumentException("Cleaning-price must be positive.");

        if (boatLength < 3 || boatLength > 25) throw new IllegalArgumentException("Boat-length must be between 1-25m.");
    }

    // Replaced generic base calculation with Boat-specific.

    @Override
    public double calculateRentalPrice(int days) {
        return super.calculateRentalPrice(days) + cleaningPrice;
    }

    // Replaced generic base calculation with Boat-specific insurance pricing (if boatLength >15 adds 25€)

    @Override
    public double calculateInsurancePrice(int days) {
        if (boatLength > 15) {
            return getInsurancePricePerDay() * days + 25;
        } else {
            return getInsurancePricePerDay() * days;
        }

    }

    // Overrides describe and adds Boat specific fields in the print.

    @Override
    public String describe() {
        return super.describe() + " | CLEANING FEE: " + cleaningPrice + " € | LENGTH: " + boatLength + "m";
    }
}
