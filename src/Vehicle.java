public abstract class Vehicle implements Rentable, Insurance {   //Implements rentable & Insurance

    private String regNumber;
    private String brand;
    private double basePricePerDay;

    public Vehicle(String regNumber, String brand, double basePricePerDay) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.basePricePerDay = basePricePerDay;
    }

    public String getRegNumber() {
        return regNumber;
    }


    public String getBrand() {
        return brand;
    }


    public double getBasePricePerDay() {
        return basePricePerDay;
    }


    public String describe() {
        return "Register number: " + regNumber + " | Brand : " + brand + " Price per day: " + basePricePerDay;

    }
}





