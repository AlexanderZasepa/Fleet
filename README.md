## Project idea

Rental Fleet System. A system that rents and manages different kind of vehicles.
Students: Alexander Zasepa & Emin Almaatooq.

## Superclass

- Name: Vehicle (Abstract)
- Shared fields: RegNumber, brand, basedPricePerDay, insurancePricePerDay, available
- Shared methods: describe(), getRegNumber(), getBrand(), getBasePricePerDay(), getInsurancePricePerDay(), isAvailable(), getStatus(), calculateRentalPrice(), calculateTotalCost(), isValidRegNumber(), isValidBrand(), bookVehicle()

## Subclasses 

1. Car - Has extra field: modelYear, pricePerKm. 
   Overrides: describe(), calculateInsurancePrice(), calculateRentalPrice()

2. Truck - Has extra field: maxLoadTon. 
   Overrides: describe(), calculateRentalPrice()

3. Boat - Has extra field: cleaningPrice, boatLength
   Overrides: describe(), calculateRentalPrice(), calculateInsurancePrice()

4. Motorbike - Has extra field: driverLicense. engineCC
   Overrides: describe(), CalculateInsurancePrice()

## Interface

- Name: Rentable
- Methods: double calculateRentalPrice(int days);
- Implements: Vehicle (inherited polymorphically by all subclasses).

- Name: Insurance
- Methods: double calculateInsurancePrice(int days);
- Implements: Vehicle (inherited polymorphically by all subclasses).

## Menu

1. Show all vehicles.
2. Search vehicle
3. Calculate total cost
4. Add new vehicle
5. Remove vehicle
6. Book vehicle
7. Exit

## Error Handling & Validation Scenarios

1. Invalid Console Menu/Numeric Input: Handled using try-catch blocks catching NumberFormatException in FleetUi loops to prevent application crashes when users enter letters, empty lines, or out-of-range menu selections.
2. Domain Object Input Validation: The Vehicle superclass and its subclasses validate constructor parameters (e.g., negative prices, empty registration strings, invalid engine CCs, or invalid model years). Invalid values throw an IllegalArgumentException, which is caught and handled cleanly during object creation in FleetUi.
3. Duplicate Registration Number Prevention: FleetManager verifies that registration numbers are unique prior to adding a new vehicle to the fleet collection.
4. Missing Entity Guarding: Looking up or calculating costs for non-existent registration numbers is safely handled with null checks and early returns, preventing NullPointerException runtime errors.

## Motivation (Later this week)
Motivation

Our motivation for this project was to build a stable, crash-free Fleet Rental System with a simple user interface. We prioritized clean, self-documenting code that is easy to navigate and simple to build upon.


1. A polymorphic class hierarchy with a superclass and sub-classes, complemented by functional interfaces.

2. A dedicated FleetManager that safely manages the ArrayList and business logic to prevent runtime exceptions.

3. A FleetUI layer built around a modular switch-menu with reusable methods for a seamless user experience.

---

