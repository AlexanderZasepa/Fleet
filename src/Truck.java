public class Truck extends Vehicle implements Rentable{

    private double maxLoadTon;

    public Truck(String regNumber, String brand, double basePricePerDay, double maxLoadTon) {
        super(regNumber, brand, basePricePerDay);
        this.maxLoadTon = maxLoadTon;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return (getBasePricePerDay()*days + (maxLoadTon*100));
    }

    @Override
    public void describe() {
        System.out.println("Register number: " + getRegNumber() + " | Brand : " + getBrand()
                + " | Price per day: " + getBasePricePerDay()
                + " | Max load:" + maxLoadTon+ " ton");
    }
}
