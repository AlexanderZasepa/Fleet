## Project idea

Rental Fleet System. A system that rents and manages different kind of vehicles.
Students: Alexander Zasepa & Emin Almaatooq.

## Superclass

- Name: Vehicle (Abstract)
- Shared fields: RegNumber, brand, basedPricePerDay, insurancePricePerDay, available
- Shared methods: describe(), getRegNumber(), getBrand(), getBasePricePerDay(), getInsurancePricePerDay(), isAvailable(), getStatus(), calculateRentalPrice(), calculateTotalCost()

## Subclasses 

1. Car - Has extra field: modelYear, pricePerKm. 
   Overrides: describe(): Adds model year and kolimeter pricing information
   calculateInsurancePrice(): Applies a 10% discount on insurance for rental exceeding 7 days

2. Truck - Has extra field: maxLoadTon. 
   Overrides: describe(): Adds maximum load capacity details
   calculateRentalPrice(): Adds a fee of 10€ per ton of load capacity per rental day.

3. Boat - Has extra field: cleaningPrice, boatLength
   Overrides: describe(): Adds cleaning fee and boat length details
   calculateRentalPrice(): adds a one-time mandatory cleaning fee to the base rental cost.

4. Motorbike - Has extra field: driverLicense. engineCC
   Overrides: describe(): Adds engine displacement and driver license requirement details.
   CalculateInsurancePrice(): Applies a 15% risk surcharge on the daily insurance cost

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
6. Exit

## Error Handling & Validation Scenarios

1. Invalid Console Menu/Numeric Input: Handled using try-catch blocks catching NumberFormatException in FleetUi loops to prevent application crashes when users enter letters, empty lines, or out-of-range menu selections.
2. Domain Object Input Validation: The Vehicle superclass and its subclasses validate constructor parameters (e.g., negative prices, empty registration strings, invalid engine CCs, or invalid model years). Invalid values throw an IllegalArgumentException, which is caught and handled cleanly during object creation in FleetUi.
3. Duplicate Registration Number Prevention: FleetManager verifies that registration numbers are unique prior to adding a new vehicle to the fleet collection.
4. Missing Entity Guarding: Looking up or calculating costs for non-existent registration numbers is safely handled with null checks and early returns, preventing NullPointerException runtime errors.

## Motivation (Later this week)

---

