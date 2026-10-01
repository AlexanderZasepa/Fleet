## Project idea

Rental Fleet System. A system that rents and manages different kind of vehicles.
Students: Alexander Zasepa & Emin Almaatooq.

## Superclass

- Name: Vehicle
- Shared fields: Reg-number, brand, basedPricePerDay
- Shared methods: describe(), getRegNumber(), getBrand(), getBasePricePerDay()

## Subclasses 

1. Car - Has extra field: modelYear, pricePerKm. Overrides: describe(), calculateRentalPrice(), calculateInsurancePrice() 
2. Truck - Has extra field: maxLoadTon. Overrides: describe(), calculateRentalPrice(), calculateInsurancePrice()
3. Boat - Has extra field: cleaningPrice. Overrides: describe(), calculateRentalPrice(), calculateInsurancePrice()
4. Motorbike - Has extra field: driverLicense. Overrides: describe(), calculateRentalPrice(), calculateInsurancePrice()

## Interface

- Name: Rentable
- Methods: double calculateRentalPrice(int days);
- Implements: Car, Truck, Boat, Motorbike.

- Name: Insurance
- Methods: double calculateInsurancePrice(int days);
- Implements: Car, Truck, Boat, Motorbike.

## Menu

1. Show all vehicles.
2. Search vehicle by reg-number
3. Calculate total cost
4. Add new vehicle
5. Remove vehicle
6. Exit

## Error scenarios

1. Invalid/incorrect data input in the menu: The user enters letters or leaves the input empty when the program expects a number. This is handled with a try-catch block around the input in FleetUI to prevent the program from crashing.
2. Creating a vehicle with invalid values: Attempting to create a vehicle with an empty registration number, empty brand, or negative daily price throws an IllegalArgumentException in the Vehicle constructor, which is caught by the interface.
3.  Attempting to add a vehicle with a registration number that already exists in the list is handled and prevented by FleetManager.

## Motivation (Later this week)

---

