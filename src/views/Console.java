package views;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    
    private static final Scanner sc = new Scanner(System.in);

    public String read() {
        String input = null;
        try {
            input = sc.next();
        } catch(Exception ex) {
            this.write("Error: Invalid input");
            System.exit(0);
        }
        return input;
    }

    public int readInt() {
        int input = 0;
        try {
            input = Integer.parseInt(this.read());
        } catch (Exception ex) {
            this.write("Error: Invalid input");
            System.exit(0);
        }
        return input;
    }

    public void write(String message) {
        System.out.println(message);
    }

    public String readEmail() {
        String regex = "^(.)+@(.)+\\.com$";
        Pattern pattern = Pattern.compile(regex);
        boolean error = false;
        String email;
        do {
            System.out.println("Enter Email format: name@domain.com");
            email = sc.next();
            error = !pattern.matcher(email).matches();
            if (error) {
                System.out.println("Error: Invalid Email format");
            }
        } while (error);
        return email;
    }

    public boolean readYesOrNot() {
        String yesOrNot;
        boolean error = false;
        do {
            yesOrNot = sc.next();
            error = !yesOrNot.equalsIgnoreCase("y") && !yesOrNot.equalsIgnoreCase("n");
            if (error) {
                System.out.println("Please enter Y (Yes) or N (No)");
            }
        } while (error);
        return yesOrNot.equalsIgnoreCase("y");
    }
}
