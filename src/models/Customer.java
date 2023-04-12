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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
