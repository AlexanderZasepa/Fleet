public class Car extends Vehicle {

    private int modelYear;
    private double pricePerKm;


    public Car(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, int modelYear, double pricePerKm) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay);
        this.modelYear = modelYear;
        this.pricePerKm = pricePerKm;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days;
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return getInsurancePricePerDay()*days;
    }
    @Override
    public String describe(){       //Returns description from the superclass vehicle
        return super.describe()     // + subclass specific attributes (modelYear), (pricePerKm)
                    + " | Price per km: " + pricePerKm
                    + " | Model year is: " + modelYear;
        }
    }



