public abstract class Vehicle implements Rentable, Insurance {   //Implements rentable & Insurance

    //"Vehicle is our abstract superclass containing all shared attributes,
    // such as registration number, brand, and base price. Car, Truck, Boat, and Motorbike all inherit from this class."

    // Shared instance variable/Fields for all vehicles.
    private String regNumber;
    private String brand;
    private double basePricePerDay;
    private double insurancePricePerDay;
    private boolean available;

    // constructor
    public Vehicle(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, boolean available) {

        // Checks that the registration number, brand, daily price and insurance price are valid before creating the vehicle.

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
    //Checks if the given regNumber is formated correctly
    public static boolean isValidRegNumber(String regNumber) {
        if (regNumber == null) {
            return false;
        }
        String cleanReg = regNumber.trim().toUpperCase();

        // Checks if the string matches the format: 3 letters + 3 digits (e.g. ABC123)
        return cleanReg.matches("^[A-Z]{3}[0-9]{3}$");
    }
    //Checks if the given brand is formated correctly
    public static boolean isValidBrand(String brand) {
        if (brand == null) {
            return false;
        }
        String cleanBrand = brand.trim();


        return cleanBrand.matches("^[a-zA-Z\\s\\-]+$");
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

    //Calculation of the rental price.
    public double calculateRentalPrice(int days) {
        return basePricePerDay * days;


    }
    //calculation of the insurance price.
    public double calculateInsurancePrice(int days){
        return insurancePricePerDay * days;
    }

    //Calculation of the total cost and adds insurance if requested.
    public double calculateTotalCost(int days, boolean includeInsurance) {
        double total = calculateRentalPrice(days);
        if (includeInsurance) {
            total += calculateInsurancePrice(days);
        }
        return total;
    }


    // Prints the description of the vehicles.
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





