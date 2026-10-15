public class Truck extends Vehicle {
    //private field for Truck
    private double maxLoadTon;

    //constructor
    public Truck(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, double maxLoadTon, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.maxLoadTon = maxLoadTon;

        //if statements exception. Shutdowns the program if exception is thrown.

        if (maxLoadTon < 0 || maxLoadTon > 30) {
            throw new IllegalArgumentException("MaxLoadTon must be between 0-30.");
        }


    }
    // Overrides describe and adds Truck specific fields in the print.

    @Override
    public String describe() {
        return super.describe() + " | MAX LOAD: " + maxLoadTon + " ton";
    }

    // Replaced generic base calculation with Truck-specific.

    @Override
    public double calculateRentalPrice(int days) {
        // Trucks cost an extra €10 per ton of load capacity per day.
        return getBasePricePerDay() * days + (maxLoadTon * 10 * days);
    }


}