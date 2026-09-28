public class Car extends Vehicle implements Rentable{

    int modelYear;


    public Car(String regNumber, String brand, double basePricePerDay, int modelYear) {
        super(regNumber, brand, basePricePerDay);
        this.modelYear = modelYear;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePricePerDay()*days;
    }
    @Override
    public void describe(){
        System.out.println("Register number: "+ getRegNumber() + " | Brand : "+ getBrand()
                + " | Price per day: "+ getBasePricePerDay()
                +" | Model year is: " + modelYear);
    }


}
