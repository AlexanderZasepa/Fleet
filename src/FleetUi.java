import java.util.Scanner;

public class FleetUi {

    public static void startMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n ||  TERMINAL MENU   ||");
            System.out.println("1. Show all vehicles");
            System.out.println("2. Search vehicle");
            System.out.println("3. Calculate total cost");
            System.out.println("4. Add new vehicle");
            System.out.println("5. Remove vehicle");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n----- ALL VEHICLES -----");
            }


            scanner.close();
        }
    }
}