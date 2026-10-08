public abstract class Vehicle implements Rentable, Insurance {   //Implements rentable & Insurance

    private String regNumber;
    private String brand;
    private double basePricePerDay;
    private double insurancePricePerDay;
    private boolean available;


    public Vehicle(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, boolean available) {

        // Checks that the registration number, brand and daily price are valid before creating the vehicle.

        if (regNumber == null || regNumber.isEmpty())
            throw new IllegalArgumentException("Registration number cannot be null or empty");

        if (brand == null || brand.isEmpty())
            throw new IllegalArgumentException("Brand cannot be null or empty");

        if (basePricePerDay <= 0)
            throw new IllegalArgumentException("Base price per day must be positive");

        if (insurancePricePerDay <= 0)
            throw new IllegalArgumentException("Insurance price must be positive");

        this.regNumber = regNumber;
        this.brand = brand;
        this.basePricePerDay = basePricePerDay;
        this.insurancePricePerDay = insurancePricePerDay;
        this.available = available;
    }

    //Getters
    public String getRegNumber() {
        return regNumber;
    }


    public String getBrand() {
        return brand;
    }


    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public double getInsurancePricePerDay() {
        return insurancePricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    //Returns "Available" if private field available is true else returns "Rented"
    public String getStatus() {
        if (available) {
            return "Available";
        } else {
            return "Rented";
        }
    }

    @Override
    public double calculateRentalPrice(int days) {

        if (days <= 0) {
            throw new IllegalArgumentException("Rental days must be greater than 0.");
        }

        return basePricePerDay * days;

    }
    public double calculateTotalCost(int days, boolean includeInsurance){
        double total = calculateRentalPrice(days);
        if (includeInsurance){
            total += calculateInsurancePrice(days);
        }
        return total;
    }


    //Calling the constructor
    public String describe() {
        return String.format("[%s] | Reg: %-6s | Brand: %-8s | Price/Day: %6.2f € | Insurance: %5.2f € | Status: %s",
                getClass().getSimpleName().toUpperCase(),
                regNumber,
                brand,
                basePricePerDay,
                insurancePricePerDay,
                getStatus());
    }

}





