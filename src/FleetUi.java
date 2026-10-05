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
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Enter a number between 1 & 6.");
                continue;
            }


            switch (choice) {

                case 1:
                    System.out.println("\n----- ALL VEHICLES -----");
                    if (manager.getVehicles().isEmpty()) {
                        System.out.println("There's no vehicles in the fleet!");
                    }else{
                        for (Vehicle v : manager.getVehicles()){
                            System.out.println(v);
                        }

                    }
                    break;

                case 2:
                    System.out.println("\n------ SEARCH VEHICLE -----");
                    System.out.println("Enter registration number: ");

            }



        }
        scanner.close();
    }
}