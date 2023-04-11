package views;

public class AdminMenu {

    private static final Console console = new Console();
    
    private static final String[] OPTIONS = {
        "1. See all Customers",
        "2. See all Rooms",
        "3. See all Reservations",
        "4. Add a Room",
        "5. Back to Main Menu"
    };

    public void show() {
        console.write("Admin Menu");
        console.write("------------------------------");
        for (String option : OPTIONS) {
            console.write(option);
        }
        console.write("------------------------------");
        console.write("Please select a number for the menu option");
    }

    public int getOption() {
        return console.readInt();
    }
}
