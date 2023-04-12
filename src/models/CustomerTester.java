package models;

public class CustomerTester {
    
    public static void main(String[] args) {
        Customer firstCustomer = new Customer("Javier", "Rodríguez", "javier.rodriguez89@example.com");
        System.out.println(firstCustomer);
        Customer secondCustomer = new Customer("Javier", "Rodríguez", "email");
        System.out.println(secondCustomer);
    }
}
