public abstract class Vehicle implements Rentable, Insurance {   //Implements rentable & Insurance

    private String regNumber;
    private String brand;
    private double basePricePerDay;
    private double insurancePricePerDay;
    private boolean isRented;




    public Vehicle(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, boolean isRented) {

        // Checks that the registration number, brand and daily price are valid before creating the vehicle.

        if (regNumber == null || regNumber.isEmpty())
            throw new IllegalArgumentException("Registration number cannot be null or empty");

        if (brand == null || brand.isEmpty())
            throw new IllegalArgumentException("Brand cannot be null or empty");

        if (basePricePerDay <= 0)
            throw new IllegalArgumentException("Base price per day must be positive");

        this.regNumber = regNumber;
        this.brand = brand;
        this.basePricePerDay = basePricePerDay;
        this.insurancePricePerDay = insurancePricePerDay;
        this.isRented = isRented;
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

    public boolean isRented() {
        return isRented;
    }

    //Calling the constructor
    public String describe() {
        return "Register number: " + regNumber + " | Brand : " + brand + " Price per day: " + basePricePerDay;

    }
}





