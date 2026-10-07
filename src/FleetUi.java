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
                    System.out.println("\n----- ALL VEHICLES -----");
                    if (manager.getVehicles().isEmpty()) {
                        System.out.println("There's no vehicles in the fleet!");
                    } else {
                        for (Vehicle v : manager.getVehicles()) {
                            System.out.println(v.describe());
                        }

                    }
                    break;

                case 2:
                    System.out.println("\n------ SEARCH VEHICLE -----");
                    System.out.println("Enter registration number: ");
                    if (scanner.hasNextLine()) {

                        String regSearch = scanner.nextLine();

                        Vehicle vehicle = manager.findVehicleByRegNumber(regSearch);
                        if (vehicle == null) {
                            System.out.println("Vehicle not found.");
                        } else {
                            System.out.println(vehicle.describe());
                        }
                    }
                    break;


                case 3:
                    System.out.println("\n----- CALCULATE TOTAL COST -----");


                    System.out.print("Enter Vehicle registration Number: ");
                    String regNumber = scanner.nextLine().trim();

                    if (regNumber.isEmpty()) {
                        System.out.println("Invalid input. Registration number cannot be empty.");
                        break;
                    }

                    Vehicle foundVehicle = manager.findVehicleByRegNumber(regNumber);

                    if (foundVehicle == null) {
                        System.out.println("Error: Vehicle not found.");
                        break;
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

                    break;
            }
        }

        scanner.close();
    }
}