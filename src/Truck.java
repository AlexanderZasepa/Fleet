public class Truck extends Vehicle {

    private double maxLoadTon;

    public Truck(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, double maxLoadTon, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.maxLoadTon = maxLoadTon;

        if (maxLoadTon < 0 || maxLoadTon > 30) {
            throw new IllegalArgumentException("MaxLoadTon must be between 0-30.");
        }


    }

    @Override
    public String describe() {
        return super.describe() + " | MAX LOAD: " + maxLoadTon + " ton";
    }

    @Override
    public double calculateRentalPrice(int days) {
        // Trucks cost an extra €10 per ton of load capacity per day.
        return getBasePricePerDay() * days + (maxLoadTon * 10 * days);
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return getInsurancePricePerDay() * days;
    }
}