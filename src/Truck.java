public class Truck extends Vehicle {

    private double maxLoadTon;

    public Truck(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, double maxLoadTon, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.maxLoadTon = maxLoadTon;
    }



    @Override
    public String describe() {     //Returns description from the superclass vehicle.
        return "[TRUCK] "+super.describe()    // + subclass specific attribute (maxLoadTon).
                + " | MAX LOAD: " + maxLoadTon+ " ton";
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return getInsurancePricePerDay()*days;
    }



}
