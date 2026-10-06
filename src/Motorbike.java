public class Motorbike extends Vehicle  {

    private boolean driverLicense;
    private int engineCC;

    public Motorbike(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, boolean driverLicense, int engineCC, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.driverLicense = driverLicense;
        this.engineCC = engineCC;
    }

    @Override
    public String describe() {    //Returns description from the superclass vehicle.
        return "[MC] "+ super.describe()   // + subclass specific attribute (driveLicense).
                + " | DRIVER LICENSE: " + driverLicense + " | ENGINE: " + engineCC +"cc";
    }



    @Override
    public double calculateInsurancePrice(int days) {
        return getInsurancePricePerDay()*days;
    }
}
