
package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final AddressBook addressBook;
    private final Scanner scanner;

    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        String input;
        do {
            System.out.println("\nAddress Book Application");
            System.out.println("a) Load entries from a file");
            System.out.println("b) Addition");
            System.out.println("c) Removal");
            System.out.println("d) Find");
            System.out.println("e) Listing");
            System.out.println("f) Quit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();

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
                    addressBook.addAddress(entry);
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

    private void loadEntriesFromFile() {
        System.out.print("Enter the file name to load entries from: ");
        String fileName = scanner.nextLine();
        addressBook.loadFromFile(fileName); // Directly using the file name provided by the user
    }


    // Method to handle the removal process
    private void removeAddressEntry() {
        System.out.print("Enter the beginning of the last name of the entry to remove: ");
        String partialLastName = scanner.nextLine();

        List<AddressEntry> matches = addressBook.findEntriesByLastName(partialLastName);

        if (matches.isEmpty()) {
            System.out.println("No entries found.");
            return;
        }

        System.out.println("Select the entry to remove:");
        for (int i = 0; i < matches.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, matches.get(i));
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        if (choice > 0 && choice <= matches.size()) {
            AddressEntry entryToRemove = matches.get(choice - 1);
            addressBook.removeAddress(entryToRemove);
            System.out.println("Entry removed successfully.");
        } else {
            System.out.println("Invalid selection.");
        }
    }



    private void findAddressEntries() {
        System.out.print("Enter the last name to search for: ");
        String lastName = scanner.nextLine();

        List<AddressEntry> results = addressBook.findEntriesByLastName(lastName);

        if (results.isEmpty()) {
            System.out.println("\nNo entries found with the last name: " + lastName);
        } else {
            System.out.println("\nFound " + results.size() + " entries:");
            int index = 1;
            for (AddressEntry entry : results) {
                System.out.printf("%d: %s\n\n", index++, entry);
            }
        }
    }



    private void listAddressEntries() {
        System.out.println();
        List<AddressEntry> entries = addressBook.listEntries();
        int index = 1;
        for (AddressEntry entry : entries) {
            System.out.printf("%d: %s\n", index++, entry);
            System.out.println();
        }
    }

 private String prompt_FirstName() {
     System.out.println();
    System.out.print("Enter first name: ");
    return scanner.nextLine();
}

private String prompt_LastName() {
    System.out.print("Enter last name: ");
    return scanner.nextLine();
}

private String prompt_Street() {
    System.out.print("Enter street: ");
    return scanner.nextLine();
}

private String prompt_City() {
    System.out.print("Enter city: ");
    return scanner.nextLine();
}

private String prompt_State() {
    System.out.print("Enter state: ");
    return scanner.nextLine();
}

private int prompt_Zip() {
    System.out.print("Enter zip code: ");
    return scanner.nextInt();
}

private String prompt_Telephone() {
    scanner.nextLine(); // Consume the newline character
    System.out.print("Enter telephone: ");
    return scanner.nextLine();
}

private String prompt_Email() {
    System.out.print("Enter email: ");
    return scanner.nextLine();
}
}