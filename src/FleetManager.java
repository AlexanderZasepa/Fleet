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
        vehicles.add(new Car("ABC123", "Volvo", 50, 6.9, 2020, 0.4, true));
        vehicles.add(new Car("CLN257", "Mercedes", 70, 8.4, 2024, 0.4, false));
        vehicles.add(new Car("BOB040", "Porsche", 170, 12.5, 2025, 0.4, true));
        vehicles.add(new Car("WQR690", "Ferrari", 250, 14.9, 2022, 0.6, true));
        vehicles.add(new Truck("TRK999", "Scania", 99.9, 11.9, 15, true));
        vehicles.add(new Truck("ILN451", "MAN", 132.9, 12.9, 20, true));
        vehicles.add(new Truck("LOD522", "Mercedes", 89.9, 10.9, 10, false));
        vehicles.add(new Boat("BOAT01", "Buster", 300, 39.9, 30, 8, true));
        vehicles.add(new Boat("BOAT02", "Yamarin", 350, 39.9, 30, 10, true));
        vehicles.add(new Boat("BOAT03", "Flipper", 449.99, 44.99, 49.9, 14, true));
        vehicles.add(new Motorbike("MC777", "Yamaha", 40, 8.4, true, 325, true));
        vehicles.add(new Motorbike("YK454", "Harley", 62.4, 11.9, true, 883, true));
        vehicles.add(new Motorbike("AG456", "Kawasaki", 54.9, 8.9, true, 600, true));

    }

    // Find a vehicle by its registration number
    public Vehicle findVehicleByRegNumber(String regNumber) {
        if (regNumber == null)
            return null;


        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegNumber().equalsIgnoreCase(regNumber.trim().toUpperCase())) {
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