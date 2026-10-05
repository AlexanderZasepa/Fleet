import java.util.ArrayList;

public class FleetManager {
        // Collection of vehicles
        private ArrayList<Vehicle> vehicles;

        // Constructor: initializes the collection and adds seed data
        public FleetManager() {
            this.vehicles = new ArrayList<>();
            listOfVehicles();
        }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }



        private void listOfVehicles() {
            vehicles.add(new Car("ABC123", "Volvo", 50, 19.0, 2020, 0.7, false));
            vehicles.add(new Truck("TRK999", "Scania", 100, 24.1, 15, false));
            vehicles.add(new Boat("BOAT01", "Buster", 300, 70, 30, 8, false));
            vehicles.add(new Motorbike("MC777", "Yamaha", 40, 15, true, 325, false));
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
        if
        (findVehicleByRegNumber(vehicle.getRegNumber()) != null) {
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