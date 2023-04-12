package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import models.Customer;

public class CustomerService {

    private static CustomerService instance;

    private Map<String, Customer> customers;

    private CustomerService() {
        customers = new HashMap<>();
    }

    public void addCustomer(String firstName, String lastName, String email) {
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String email) {
        return customers.get(email);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }
    
}
