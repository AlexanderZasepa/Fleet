public class Motorbike extends Vehicle  {

    private boolean driverLicense;
    private int engineCC;

    public Motorbike(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, boolean driverLicense, int engineCC, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.driverLicense = driverLicense;
        this.engineCC = engineCC;

        if (engineCC <200 || engineCC >1200) {
            throw new IllegalArgumentException("Motorbike Engine-CC must be between 200-1200.");
        }
    }

    @Override
    public String describe() {
        return super.describe() + " | DRIVER LICENSE: " + driverLicense + " | ENGINE: " + engineCC + "cc";
    }



    @Override
    public double calculateInsurancePrice(int days) {
        // Motorbikes have a 15% risk surcharge on insurance.
        return (getInsurancePricePerDay() * days) * 1.15;
    }
    }
