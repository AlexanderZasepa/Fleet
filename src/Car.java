public class Car extends Vehicle {

    private int modelYear;
    private double pricePerKm;

    public int getModelYear() {
        return modelYear;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

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
    public String describe() {
        return super.describe() + " | PRICE/KM: " + pricePerKm + " | MODEL YEAR: " + modelYear;
    }

}



