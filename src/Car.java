public class Car extends Vehicle implements Rentable, Insurance{

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
    public void describe(){
        System.out.println("Register number: "+ getRegNumber() + " | Brand : "+ getBrand()
                + " | Price per day: "+ getBasePricePerDay()
                + " Price per km: " + pricePerKm
                + " | Model year is: " + modelYear);
    }


}
