public class Truck extends Vehicle {

    private double maxLoadTon;

    public Truck(String regNumber, String brand, double basePricePerDay, double maxLoadTon) {
        super(regNumber, brand, basePricePerDay);
        this.maxLoadTon = maxLoadTon;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return (getBasePricePerDay()*days + (maxLoadTon*100));
    }

    @Override
    public String describe() {     //Returns description from the superclass vehicle.
        return super.describe()    // + subclass specific attribute (maxLoadTon).
                + " | Max load:" + maxLoadTon+ " ton";
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return 150*days;
    }
}
