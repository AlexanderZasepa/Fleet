public class Car extends Vehicle {

    private int modelYear;
    private int pricePerKm;


    public Car(String regNumber, String brand, double basePricePerDay, int modelYear, int pricePerKm) {
        super(regNumber, brand, basePricePerDay);
        this.modelYear = modelYear;
        this.pricePerKm = pricePerKm;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days;
    }

    @Override
    public double calculateInsurancePrice(int days) {
        return 50*days;
    }
    @Override
    public String describe(){       //Returns description from the superclass vehicle
        return super.describe()     // + subclass specific attributes (modelYear), (pricePerKm)
                    + " | Price per km: " + pricePerKm
                    + " | Model year is: " + modelYear;
        }
    }



