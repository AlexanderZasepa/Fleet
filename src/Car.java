public class Car extends Vehicle {
    //Private fields for subclass Car.
    private int modelYear;
    private double pricePerKm;

    //Getters
    public int getModelYear() {
        return modelYear;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    // Constructor
    public Car(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, int modelYear, double pricePerKm, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.modelYear = modelYear;
        this.pricePerKm = pricePerKm;

        //if statements exception. Shutdowns the program if exception is thrown.
        if (modelYear < 2000 || modelYear > 2026) {
            throw new IllegalArgumentException("Model-year must be between 2000-2026.");
        }
        if (pricePerKm < 0) throw new IllegalArgumentException("Price per km can't be negative.");
    }

    // Replaced generic base calculation with car-specific Rental pricing (5% discount for rentals > 20 days)
    @Override
    public double calculateRentalPrice(int days) {
        // Cars get a 5% insurance discount for rentals longer than 20 days.
        if (days > 20) {
            return (getBasePricePerDay() * days) * 0.95;
        } else {
            return getBasePricePerDay() * days;
        }
    }

    // Replaced generic base calculation with car-specific insurance pricing (10% discount for rentals > 7 days)
    @Override
    public double calculateInsurancePrice(int days) {
        // Cars get a 10% insurance discount for rentals longer than 7 days.
        if (days > 7) {
            return (getInsurancePricePerDay() * days) * 0.9;
        } else {
            return getInsurancePricePerDay() * days;
        }
    }
    // Overrides describe and adds Car specific fields in the print.
    @Override
    public String describe() {
        return super.describe() + " | PRICE/KM: " + pricePerKm + " | MODEL YEAR: " + modelYear;
    }

}



