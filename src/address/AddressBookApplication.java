package address;

import address.data.AddressBook;

/**
 * The main application class for the Address Book Application.
 * This class initializes the application, including the AddressBook and Menu,
 * and starts the user interaction process through the menu system.
 *
 * @author Hasibullah Ayoubi
 * @since Feb. 26, 2024
 * @version 1
 */

public class AddressBookApplication {

    /**
     * The main entry point for the Address Book Application.
     * Initializes the AddressBook and Menu, displays a welcome message,
     * and starts the menu interaction loop. Upon exiting the menu,
     * displays a goodbye message.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu(addressBook);
        System.out.println("Welcome to the Address Book Application!");
        menu.displayMenu();
        System.out.println("Thank you for using the Address Book Application. Goodbye!");
    }
}
