public class Motorbike extends Vehicle implements Rentable{

    boolean driverLicense;

    public Motorbike(String regNumber, String brand, double basePricePerDay, boolean driverLicense) {
        super(regNumber, brand, basePricePerDay);
        this.driverLicense = driverLicense;


    }
    @Override
    public void describe() {
        System.out.println("Register number: " + getRegNumber() + " | Brand : " + getBrand()
                + " | Price per day: " + getBasePricePerDay()
                + " | Driver license: " + driverLicense);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days;
    }
}
