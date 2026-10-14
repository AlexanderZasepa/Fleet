public interface Insurance {

    double calculateInsurancePrice(int days);
}
//We have two interfaces, Rentable and Insurance. Vehicle implements both of these, which forces all vehicle types to have calculation methods for rental and insurance."