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
            System.out.println("6. Book vehicle");
            System.out.println("7. Exit");

            System.out.println("Choose an option: 1-7: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1 & 7.");
                continue;
            }

            // A menu switch with our cases which includes our methods.
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
                    removeAnyVehicle(scanner, manager);
                    break;

                case 6:
                    bookAnyVehicle(scanner, manager);
                    break;

                case 7: // Ändrat från 6 till 7
                    System.out.println("\n-----Exiting the system!-----");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option (1-7): ");
            }
        }


        scanner.close();

    }

    //A method that prints our arraylist and if the arraylist is empty, i will give a error string.
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

    // A method that searches for a vehicle by registration number and displays an error message if the vehicle is not found.
    private static void searchVehicle(Scanner scanner, FleetManager manager) {
        System.out.println("\n====================== SEARCH VEHICLE ======================");
        System.out.print("Enter registration number: ");
        // Check if another line of input is available to read
        if (scanner.hasNextLine()) {
            // Read the user's input and store it in the variable "regSearch"
            String regSearch = scanner.nextLine();
            Vehicle vehicle = manager.findVehicleByRegNumber(regSearch);
            if (vehicle == null) {
                System.out.println("Vehicle not found.");
            } else {
                System.out.println(vehicle.describe());
            }
        }
    }


    // A method that calculates the total rental cost of a vehicle
    private static void calculateTotalCost(Scanner scanner, FleetManager manager) {
        System.out.println("\n----- CALCULATE TOTAL COST -----");


        System.out.print("Enter Vehicle registration Number: ");
        String regNumber = scanner.nextLine().trim(); // Trims down the input stores in the variable "regNummer"

        if (regNumber.isEmpty()) {
            System.out.println("Invalid input. Registration number cannot be empty.");
            return;
        }

        // Search for the vehicle using its registration number.
        Vehicle foundVehicle = manager.findVehicleByRegNumber(regNumber);

        if (foundVehicle == null) {
            System.out.println("Error: Vehicle not found.");
            return;
        }
        // Create variable "days" to store the number of rental day
        int days = 0;
        // Keep asking the user until valid input is entered
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
        //ask the user if they want to inlucde the insurance or not.
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

        // Calculates the total rental cost and stores the result in totalCost.
        double totalCost = foundVehicle.calculateTotalCost(days, includeInsurance);

        System.out.println("\n--- TOTAL RENTAL COST ---");
        System.out.println("Vehicle: " + foundVehicle.getBrand() + " (" + foundVehicle.getRegNumber() + ")");
        System.out.println("Days: " + days);
        System.out.println("Insurance included: " + (includeInsurance ? "Yes" : "No"));
        System.out.printf("Total Cost:  %.2f €\n", totalCost);
    }


    // Adds a new vehicle to the fleet
    private static void addNewVehicle(Scanner scanner, FleetManager manager) {
        System.out.println("\n----- ADD NEW VEHICLE -----");

        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        System.out.print("Enter password: ");
        String pwd = scanner.nextLine();

        //Asking the user for Admin login credentials
        if (AdminCredentials.AuthManager.authenticate(user, pwd)) {
            System.out.println("Login successful!");

        } else {
            System.out.println("Invalid credentials!");
            return;
        }

        // Create a variable to store the selected vehicle type
        int type = 0;

        while (true) {
            System.out.println("Select vehicle type:");
            System.out.println("1. Car\n2. Truck\n3. Boat\n4. Motorbike");
            System.out.print("Choice (1-4): ");

            try {

                type = Integer.parseInt(scanner.nextLine().trim()); // Read the input and convert it to an integer
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
                // Read the registration number, remove spaces and convert to uppercase
                reg = scanner.nextLine().trim().toUpperCase();


                // Check that the registration is valid
                if (Vehicle.isValidRegNumber(reg)) {
                    break;
                } else {
                    System.out.println("Invalid registration format! Must be 3 letters followed by 3 digits.");
                }
            }

            // Read and validate Brand
            String brand = "";
            while (true) {
                System.out.print("Brand: ");
                brand = scanner.nextLine().trim();


                if (Vehicle.isValidBrand(brand)) {
                    break;
                } else {
                    System.out.println("Invalid brand! Brand name cannot contain numbers.\n");
                }
            }

            System.out.print("Base price per day (€): ");
            double basePrice = Double.parseDouble(scanner.nextLine().trim()); // convert it to a decimal number


            System.out.print("Insurance price per day (€): ");
            double insPrice = Double.parseDouble(scanner.nextLine().trim()); // convert it to a decimal number

            // Create the variable "newVehicle" to store the new information
            Vehicle newVehicle = null;


            // Create the correct vehicle based on the selected type
            switch (type) {
                case 1: // Create a Car
                    System.out.print("Model Year: ");
                    int year = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Price per KM (€): ");
                    double priceKm = Double.parseDouble(scanner.nextLine().trim());

                    // Create a new vehicle using the entered information
                    newVehicle = new Car(reg, brand, basePrice, insPrice, year, priceKm, true);
                    break;

                case 2: // Create a Truck
                    System.out.print("Max Load (tons): ");
                    double maxLoad = Double.parseDouble(scanner.nextLine().trim());

                    newVehicle = new Truck(reg, brand, basePrice, insPrice, maxLoad, true);
                    break;

                case 3: // Create a Boat
                    System.out.print("Cleaning Price (€): ");
                    double cleaning = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Boat Length (m): ");
                    int length = Integer.parseInt(scanner.nextLine().trim());

                    newVehicle = new Boat(reg, brand, basePrice, insPrice, cleaning, length, true);
                    break;

                case 4: // Create a Motorbike
                    System.out.print("Driver License required (true/false): ");
                    boolean license = Boolean.parseBoolean(scanner.nextLine().trim());
                    System.out.print("Engine CC: ");
                    int cc = Integer.parseInt(scanner.nextLine().trim());

                    newVehicle = new Motorbike(reg, brand, basePrice, insPrice, license, cc, true);
                    break;
            }


            // Try to add the new vehicle to the fleet
            boolean success = manager.addVehicle(newVehicle);

            // Check whether the vehicle was added successfully
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

    // Removing existing vehicle from the fleet
    private static void removeAnyVehicle(Scanner scanner, FleetManager manager) {
        System.out.println("\n----- REMOVE VEHICLE -----");

        try {
            // Keep asking until a vehicle is removed or the operation is cancelled
            while (true) {

                //Asking the user for Admin login credentials
                System.out.print("Enter username: ");
                String user = scanner.nextLine();
                System.out.print("Enter password: ");
                String pwd = scanner.nextLine();

                //Asking the user for Admin login credentials
                if (AdminCredentials.AuthManager.authenticate(user, pwd)) {
                    System.out.println("Login successful!");

                } else {
                    System.out.println("Invalid credentials!");
                    return;
                }

                System.out.println("Enter registration number to remove (e.g ABC123 or '0' to cancel: ");
                String reg = scanner.nextLine().trim().toUpperCase();

                // Cancel the operation if the user enters 0
                if (reg.equals("0")) {
                    System.out.println("Operation cancelled ");
                    return;
                }
                // Check that the registration number has 3 letters followed by 3 numbers
                if (Vehicle.isValidRegNumber(reg)) {

                } else {
                    System.out.println("Invalid registration format! Must be 3 letters followed by 3 digits.");
                }
                // Try to remove the vehicle with the entered registration number
                boolean remove = manager.removeVehicle(reg);

                // Check whether the vehicle was removed successfully
                if (remove) {
                    System.out.println("Vehicle with registration number: " + reg + " was successfully removed! ");
                    break;
                } else {
                    System.out.println("Error: No vehicle found with registration number " + reg + ". Please try again!\n");
                    return;
                }


            }

            //catch errors if the input format is wrong
        } catch (NumberFormatException e) {
            System.out.println("Input error: Please enter valid registration number!");

            //catch errors when rules or validation fails.
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());

        }


    }

    // A method to handle booking a vehicle via its registration number
    private static void bookAnyVehicle(Scanner scanner, FleetManager manager) {
        System.out.println("\n====================== BOOK VEHICLE ======================");
        System.out.print("Enter registration number to book (e.g. ABC123): ");

        String regNumber = scanner.nextLine().trim().toUpperCase();

        if (regNumber.isEmpty()) {
            System.out.println("Invalid input. Registration number cannot be empty.");
            return;
        }

        // Validate the format just like in other places
        if (!Vehicle.isValidRegNumber(regNumber)) {
            System.out.println("Invalid registration format! Must be 3 letters followed by 3 digits.");
            return;
        }

        // Check if the vehicle exists
        Vehicle vehicle = manager.findVehicleByRegNumber(regNumber);
        if (vehicle == null) {
            System.out.println("Error: No vehicle found with registration number " + regNumber + ".");
            return;
        }

        // Check if the vehicle is already booked before asking for confirmation
        if (!vehicle.isAvailable()) {
            System.out.println("Error: Vehicle " + regNumber + " is already rented/booked!");
            return;
        }

        // Ask for confirmation before proceeding with the booking
        boolean confirmBooking = false;
        while (true) {
            System.out.print("Are you sure you want to book this vehicle (" + vehicle.getBrand() + " - " + regNumber + ")? Yes/No: ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                confirmBooking = true;
                break;
            } else if (confirmation.equals("no")) {
                System.out.println("Booking cancelled.");
                return;
            } else {
                System.out.println("Invalid input! Please enter: Yes or No.");
            }
        }

        // If confirmed, try to book the vehicle
        if (confirmBooking) {
            boolean success = manager.bookVehicle(regNumber);
            if (success) {
                System.out.println("Success! Vehicle " + regNumber + " (" + vehicle.getBrand() + ") has been successfully booked.");
            } else {
                System.out.println("Error: Vehicle could not be booked.");
            }
        }
    }

}


