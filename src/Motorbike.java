public class Motorbike extends Vehicle  {

    private boolean driverLicense;

    public Motorbike(String regNumber, String brand, double basePricePerDay, boolean driverLicense) {
        super(regNumber, brand, basePricePerDay);
        this.driverLicense = driverLicense;


    }
    @Override
    public String describe() {    //Returns description from the superclass vehicle.
        return super.describe()   // + subclass specific attribute (driveLicense).
                + " | Driver license: " + driverLicense;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days;
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return 0;
    }
}
