import java.util.ArrayList;

public class FleetManager {
        // Collection of vehicles
        private ArrayList<Vehicle> vehicles;

        // Constructor: initializes the collection and adds seed data
        public FleetManager() {
            this.vehicles = new ArrayList<>();
            seedData();
        }



        private void seedData() {
            vehicles.add(new Car("ABC123", "Volvo", 500, 2020));
            vehicles.add(new Truck("TRK999", "Scania", 1200, 15.0));
            vehicles.add(new Boat("BOAT01", "Buster", 800, 300));
            vehicles.add(new Motorbike("MC777", "Yamaha", 400, true));
        }

        // Find a vehicle by its registration number
        public Vehicle findVehicleByRegNumber(String regNumber) {
            if (regNumber == null)
                return null;


            for (Vehicle vehicle : vehicles) {
                if (vehicle.getRegNumber().equalsIgnoreCase(regNumber.trim().toUpperCase())){
                    return vehicle;
                }
            }
            return null;
        }







}