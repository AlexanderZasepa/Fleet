import java.util.Scanner;

public class FleetUi {

    //Method that starts the menu loop
    public static void startMenu(FleetManager manager) {
        Scanner scanner = new Scanner(System.in); //Scanner object to receive input
        boolean running = true;

        //A while loop to keep the menu going
        while (running) {
            System.out.println("\n ||  TERMINAL MENU   ||");
            System.out.println("1. Show all vehicles");
            System.out.println("2. Search vehicle");
            System.out.println("3. Calculate total cost");
            System.out.println("4. Add new vehicle");
            System.out.println("5. Remove vehicle");
            System.out.println("6. Exit");

            System.out.println("Choose an option: 1-6: ");

            //Blocks the user from using text as input.
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1 & 6.");
                continue;
            }


            switch (choice) {

                case 1:
                    displayAllVehicles(manager);
                    break;

                case 2:
                    searchVehicle(scanner, manager);
                    break;


                case 3:
                    calculateTotalCost(scanner, manager);
                    break;

                case 4:
                    addNewVehicle(scanner, manager);
                    break;

                case 5:

                    break;

                case 6:
                    break;
            }
        }


        scanner.close();

    }

    private static void displayAllVehicles(FleetManager manager) {
        System.out.println("\n====================== FLEET VEHICLES ======================");
        if (manager.getVehicles().isEmpty()) {
            System.out.println("There are no vehicles in the fleet!");
        } else {
            for (Vehicle v : manager.getVehicles()) {
                System.out.println(v.describe());
                System.out.println("------------------------------------------------------------");
            }
        }
    }

    private static void searchVehicle(Scanner scanner, FleetManager manager) {
        System.out.println("\n====================== SEARCH VEHICLE ======================");
        System.out.print("Enter registration number: ");
        if (scanner.hasNextLine()) {
            String regSearch = scanner.nextLine();
            Vehicle vehicle = manager.findVehicleByRegNumber(regSearch);
            if (vehicle == null) {
                System.out.println("Vehicle not found.");
            } else {
                System.out.println(vehicle.describe());
            }
        }
    }

    private static void calculateTotalCost(Scanner scanner, FleetManager manager) {
        System.out.println("\n----- CALCULATE TOTAL COST -----");


        System.out.print("Enter Vehicle registration Number: ");
        String regNumber = scanner.nextLine().trim();

        if (regNumber.isEmpty()) {
            System.out.println("Invalid input. Registration number cannot be empty.");
        }

        Vehicle foundVehicle = manager.findVehicleByRegNumber(regNumber);

        if (foundVehicle == null) {
            System.out.println("Error: Vehicle not found.");
        }
        int days = 0;
        while (true) {
            System.out.print("Enter number of rental days: ");
            try {
                days = Integer.parseInt(scanner.nextLine().trim());
                if (days > 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Days must be at least 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        boolean includeInsurance = false;
        while (true) {
            System.out.println("Do you want to include insurance for this vehicle? Yes/No: ");
            String insuranceInput = scanner.nextLine().trim().toLowerCase();

            if (insuranceInput.equals("yes")) {
                includeInsurance = true;
                break;
            } else if (insuranceInput.equals("no")) {
                includeInsurance = false;
                break;
            } else {
                System.out.println("Invalid input! Please enter: Yes or No.");
            }
        }
        double totalCost = foundVehicle.calculateTotalCost(days, includeInsurance);


        System.out.println("\n--- TOTAL RENTAL COST ---");
        System.out.println("Vehicle: " + foundVehicle.getBrand() + " (" + foundVehicle.getRegNumber() + ")");
        System.out.println("Days: " + days);
        System.out.println("Insurance included: " + (includeInsurance ? "Yes" : "No"));
        System.out.printf("Total Cost:  %.2f €\n", totalCost);
    }

    private static void addNewVehicle(Scanner scanner, FleetManager manager) {
        System.out.println("\n----- ADD NEW VEHICLE -----");


        int type = 0;
        while (true) {
            System.out.println("Select vehicle type:");
            System.out.println("1. Car\n2. Truck\n3. Boat\n4. Motorbike");
            System.out.print("Choice (1-4): ");

            try {
                type = Integer.parseInt(scanner.nextLine().trim());
                if (type >= 1 && type <= 4) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.\n");
            }
        }

        try {

            String reg = "";
            while (true) {
                System.out.print("Reg Number (e.g. ABC123): ");
                reg = scanner.nextLine().trim().toUpperCase();


                if (reg.matches("^[A-Z]{3}[0-9]{3}$")) {
                    break;
                } else {
                    System.out.println("Invalid registration number! Must be 3 letters followed by 3 numbers (e.g., ABC123).\n");
                }
            }

            System.out.print("Brand: ");
            String brand = scanner.nextLine().trim();

            System.out.print("Base price per day (€): ");
            double basePrice = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Insurance price per day (€): ");
            double insPrice = Double.parseDouble(scanner.nextLine().trim());

            Vehicle newVehicle = null;


            switch (type) {
                case 1: // Car
                    System.out.print("Model Year: ");
                    int year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Price per KM (€): ");
                    double priceKm = Double.parseDouble(scanner.nextLine().trim());

                    newVehicle = new Car(reg, brand, basePrice, insPrice, year, priceKm, true);
                    break;

                case 2: // Truck
                    System.out.print("Max Load (tons): ");
                    double maxLoad = Double.parseDouble(scanner.nextLine().trim());

                    newVehicle = new Truck(reg, brand, basePrice, insPrice, maxLoad, true);
                    break;

                case 3: // Boat
                    System.out.print("Cleaning Price (€): ");
                    double cleaning = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Boat Length (m): ");
                    int length = Integer.parseInt(scanner.nextLine().trim());

                    newVehicle = new Boat(reg, brand, basePrice, insPrice, cleaning, length, true);
                    break;

                case 4: // Motorbike
                    System.out.print("Driver License required (true/false): ");
                    boolean license = Boolean.parseBoolean(scanner.nextLine().trim());
                    System.out.print("Engine CC: ");
                    int cc = Integer.parseInt(scanner.nextLine().trim());

                    newVehicle = new Motorbike(reg, brand, basePrice, insPrice, license, cc, true);
                    break;
            }


            boolean success = manager.addVehicle(newVehicle);

            if (success) {
                System.out.println("Vehicle successfully added!");
            } else {
                System.out.println("Error: A vehicle with registration number '" + reg + "' already exists.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Input error: Please enter valid numbers for price, year, etc.");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}

