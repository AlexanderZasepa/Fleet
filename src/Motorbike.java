public class Motorbike extends Vehicle  {

    private boolean driverLicense;
    private int engineCC;

    public Motorbike(String regNumber, String brand, double basePricePerDay, boolean driverLicense, int engineCC) {
        super(regNumber, brand, basePricePerDay);
        this.driverLicense = driverLicense;
        this.engineCC = engineCC;
    }

    @Override
    public String describe() {    //Returns description from the superclass vehicle.
        return super.describe()   // + subclass specific attribute (driveLicense).
                + " | Driver license: " + driverLicense + " | Engine CC: " + engineCC;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days;
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return 50*days;
    }
}
