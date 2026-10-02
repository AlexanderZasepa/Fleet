import java.util.ArrayList;

public class FleetManager {
        // Collection of vehicles
        private ArrayList<Vehicle> vehicles;

        // Constructor: initializes the collection and adds seed data
        public FleetManager() {
            this.vehicles = new ArrayList<>();
            seedData();
        }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    private void seedData() {
            vehicles.add(new Car("ABC123", "Volvo", 500, 2020,2));
            vehicles.add(new Truck("TRK999", "Scania", 1200, 15.0));
            vehicles.add(new Boat("BOAT01", "Buster", 800, 300, 9));
            vehicles.add(new Motorbike("MC777", "Yamaha", 400, true, 325));
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


    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return false;
        }

        // If the vehicle already exists (search returns non-null), refuse to add
        if (findVehicleByRegNumber(vehicle.getRegNumber()) != null) {
            return false;
        }

        return vehicles.add(vehicle);
    }

    public boolean removeVehicle(String regNumber) {

        Vehicle vehicleToRemove = findVehicleByRegNumber(regNumber);

        if (vehicleToRemove != null) {
            return vehicles.remove(vehicleToRemove);
        }

        return false; //Car doesn't exist
        }


}