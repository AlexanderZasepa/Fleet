import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle {

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

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public void describe() {
        System.out.println("Register number: " + regNumber + " | Brand : " + brand
                + "Price per day: " + basePricePerDay);
    }

    public static void startMenu() {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("DLC 020", "BMW", 300, 4));
        vehicles.add(new Truck("LGU 127", "Mercedes", 700, 3.5));
        vehicles.add(new Motorbike("YWT 070", "VOI", 9.9, true));


        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n ||  TERMINAL MENU   ||");
            System.out.println("1. Show all vehicles");
            System.out.println("2. Calculate rent");
            System.out.println("3. Search vehicle");
            System.out.println("4. Add new vehicle");
            System.out.println("5. Cancel");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n----- ALL VEHICLES -----");
            }


        }
        scanner.close();
    }
}