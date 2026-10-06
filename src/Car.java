public class Car extends Vehicle {

    private int modelYear;
    private double pricePerKm;


    public Car(String regNumber, String brand, double basePricePerDay, double insurancePricePerDay, int modelYear, double pricePerKm, boolean available) {
        super(regNumber, brand, basePricePerDay, insurancePricePerDay, available);
        this.modelYear = modelYear;
        this.pricePerKm = pricePerKm;
    }



    @Override
    public double calculateInsurancePrice(int days) {
        return getInsurancePricePerDay()*days;
    }


    @Override
    public String describe(){       //Returns description from the superclass vehicle
        return "[CAR] "+ super.describe()      // + subclass specific attributes (modelYear), (pricePerKm)
                    + " | PRICE/KM: " + pricePerKm
                    + " | MODEL YEAR: " + modelYear;
        }
    }



