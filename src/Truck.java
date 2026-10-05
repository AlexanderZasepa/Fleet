public class Truck extends Vehicle {

    private double maxLoadTon;

    public Truck(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, double maxLoadTon, boolean isRented) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, isRented);
        this.maxLoadTon = maxLoadTon;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days;
    }

    @Override
    public String describe() {     //Returns description from the superclass vehicle.
        return super.describe()    // + subclass specific attribute (maxLoadTon).
                + " | Max load:" + maxLoadTon+ " ton";
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return getInsurancePricePerDay()*days;
    }
}
