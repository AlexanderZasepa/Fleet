public abstract class Vehicle {

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


    public void describe() {
        System.out.println("Register number: " + regNumber + " | Brand : " + brand + " Price per day: " + basePricePerDay);

    }
}





