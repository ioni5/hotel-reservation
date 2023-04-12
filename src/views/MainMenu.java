package views;

public class MainMenu {

    private static final Console console = new Console();

    private static final String[] OPTIONS = {
        "1. Find and reserve a room",
        "2. Create an account",
        "3. Admin",
        "4. Exit"
    };

    public void show() {
        console.write("Welcome to the Hotel Reservation Application");
        console.write("-------------------------------------------");
        for (String option : OPTIONS) {
            console.write(option) ;
        }
        console.write("-------------------------------------------");
        console.write("Please select a number for the menu option");
    }

    public int getOption() {
        return console.readInt();
    }
    
}
