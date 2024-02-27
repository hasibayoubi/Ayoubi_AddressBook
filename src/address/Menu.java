
package address;

import address.data.AddressBook;
import address.data.AddressEntry;
import java.util.List;
import java.util.Scanner;

/**
 * The Menu class represents Provides a text-based user interface for managing an address book.
 * This includes adding, removing, finding, and listing entries, as well as loading them from a file.
 * @author Hasibullah Ayoubi
 * @since Feb. 26, 2024
 * @version 1
 */

public class Menu {

    /**
     * The address book to manage through this menu.
     */
    private final AddressBook addressBook;

    /**
     * Scanner for reading user input.
     */
    private final Scanner scanner;

    /**
     * Constructs a new Menu instance.
     *
     * @param addressBook The AddressBook instance to interact with.
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu and handles user input for various operations.
     */

    public void displayMenu() {
        String input;
        do {
            System.out.println("\n**********************************");
            System.out.println("Please enter your menu selection");
            System.out.println("a) Load from file");
            System.out.println("b) Addition");
            System.out.println("c) Removal");
            System.out.println("d) Find");
            System.out.println("e) Listing");
            System.out.println("f) Quit");
            System.out.println("**********************************");
            input = scanner.nextLine();
            System.out.println();

            switch (input) {
                case "a":
                    loadEntriesFromFile();
                    break;
                case "b":
                    String firstName = prompt_FirstName();
                    String lastName = prompt_LastName();
                    String street = prompt_Street();
                    String city = prompt_City();
                    String state = prompt_State();
                    int zip = prompt_Zip();
                    String telephone = prompt_Telephone();
                    String email = prompt_Email();
                    AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, telephone, email);
                    addressBook.add(entry);
                    break;
                case "c":
                    removeAddressEntry();
                    break;
                case "d":
                    findAddressEntries();
                    break;
                case "e":
                    listAddressEntries();
                    break;
                case "f":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (!input.equalsIgnoreCase("f"));
    }

    /**
     * Loads address entries from a specified file into the address book.
     */
    private void loadEntriesFromFile() {
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();
        addressBook.readFromFile(fileName);
    }

    /**
     * Prompts the user for the last name and removes matching entries from the address book.
     */
    private void removeAddressEntry() {
        System.out.println("Enter in Last Name of contact to remove: ");
        String partialLastName = scanner.nextLine();

        List<AddressEntry> matches = addressBook.find(partialLastName);

        if (matches.isEmpty()) {
            System.out.println("No entries found.");
            return;
        }

        if (matches.size() == 1) {
            // When exactly one entry is found
            AddressEntry singleMatch = matches.get(0);
            System.out.println("\nThe following entry was found in the address book.");
            System.out.println(singleMatch);
            System.out.println("\nHit 'y' to remove the entry or 'n' to return to main menu: ");
            String confirmation = scanner.nextLine().trim();
            while (!(confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("n"))) {
                System.out.println("Invalid input. Please enter 'y' to remove or 'n' to cancel:");
                confirmation = scanner.nextLine().trim();
            }
            if (confirmation.equalsIgnoreCase("y")) {
                addressBook.remove(singleMatch);
                System.out.println("Entry removed successfully.");
            }
        } else {
            // When multiple entries are found
            System.out.println("\nThe following entries were found in the address book, select the number of the entry you wish to remove:\n");
            for (int i = 0; i < matches.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, matches.get(i));
                System.out.println();
            }

            System.out.print("Your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid selection. Please enter a number:");
                scanner.next();
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= matches.size()) {
                AddressEntry entryToRemove = matches.get(choice - 1);
                System.out.println("\nHit 'y' to remove the following entry or 'n' to return to main menu:");
                System.out.println(entryToRemove);
                System.out.println();
                String confirmRemove = scanner.nextLine().trim();
                while (!(confirmRemove.equalsIgnoreCase("y") || confirmRemove.equalsIgnoreCase("n"))) {
                    System.out.println("Invalid input. Please enter 'y' to remove or 'n' to cancel:");
                    confirmRemove = scanner.nextLine().trim();
                }
                if (confirmRemove.equalsIgnoreCase("y")) {
                    addressBook.remove(entryToRemove);
                    System.out.println("Entry removed successfully.");
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }


    /**
     * Finds and displays entries from the address book that match the last name provided by the user.
     */

    private void findAddressEntries() {
        System.out.println("Enter in all or beginning of last name you wish to find: ");
        String lastName = scanner.nextLine();

        List<AddressEntry> results = addressBook.find(lastName);

        if (results.isEmpty()) {
            System.out.println("\nNo entries found with the last name: " + lastName);
        } else {
            System.out.println("\nThe following " + results.size() + " entries were found in the address book for a last name starting with " + ("\"" + lastName + "\""));
            int index = 1;
            for (AddressEntry entry : results) {
                System.out.printf("%d: %s\n\n", index++, entry);
            }
        }
    }

    /**
     * Lists all entries in the address book.
     */
    private void listAddressEntries() {
        System.out.println();
        List<AddressEntry> entries = addressBook.list();
        int index = 1;
        for (AddressEntry entry : entries) {
            System.out.printf("%d: %s\n", index++, entry);
            System.out.println();
        }
    }

    /**
     * Prompts the user for the first name of the address entry.
     *
     * @return The first name entered by the user.
     */

    private String prompt_FirstName() {
        System.out.println("First name: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user for the last name of the address entry.
     *
     * @return The last name entered by the user.
     */

    private String prompt_LastName() {
        System.out.println("Last name: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user for the street name of the address entry.
     *
     * @return The street name entered by the user.
     */

    private String prompt_Street() {
        System.out.println("Street: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user for the city name of the address entry.
     *
     * @return The city name entered by the user.
     */

    private String prompt_City() {
        System.out.println("City: ");
        return scanner.nextLine();
    }
    /**
     * Prompts the user for the state name of the address entry.
     *
     * @return The state name entered by the user.
     */
    private String prompt_State() {
        System.out.println("State: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user for a zip code and ensures that the input is a valid integer.
     * Continuously prompts the user until a valid integer is entered for the zip code.
     *
     * @return The validated zip code entered by the user.
     */
    private int prompt_Zip() {
        int zipCode = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println("Zip: ");
            String input = scanner.nextLine();

            try {
                zipCode = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid zip code. Please enter a numeric value.");
            }
        }

        return zipCode;
    }

    /**
     * Prompts the user for the telephone number of the address entry.
     *
     * @return The telephone number entered by the user.
     */
    private String prompt_Telephone() {
        System.out.println("Telephone: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user for the email of the address entry.
     *
     * @return The email entered by the user.
     */
    private String prompt_Email() {
        System.out.println("Email: ");
        return scanner.nextLine();
    }
}