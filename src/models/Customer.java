package models;

import java.util.regex.Pattern;

public class Customer {
    
    private String firstName;

    private String lastName;

    private String email;

    public Customer(String firstName, String lastName, String email) {
        try {
            Pattern pattern = Pattern.compile("^(.)+@(.)+\\.com$");
            if (!pattern.matcher(email).matches()) {
                throw new IllegalArgumentException("The argument email does not match the format: name@domain.com");
            }
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + " Last Name: " + lastName + " Email: " + email;
    }

}
