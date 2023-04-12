package resources;

import services.CustomerService;

public class HotelResource {

    private static HotelResource instance;

    private CustomerService customerService;

    private HotelResource() {
        customerService = CustomerService.getInstance();
    }

    public void createACustomer(String firstName, String lastName, String email) {
        customerService.addCustomer(firstName, lastName, email);
    }

    public static HotelResource getInstance() {
        if (instance == null) {
            instance = new HotelResource();
        }
        return instance;
    }
}
