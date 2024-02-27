package address.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * The AddressBook class represents an address book to manage a list of AddressEntry objects.
 * This class provides functionality to add, remove, find, and list entries,
 * as well as load entries from a file.
 * @author Hasibullah Ayoubi
 * @since Feb. 26, 2024
 * @version 1
 */

public class AddressBook {
    /**
     * The list of AddressEntry objects representing individual entries in the address book.
     */
    private final List<AddressEntry> entries;

    /**
     * Constructs an empty AddressBook initializing the list of AddressEntry objects.
     */
    public AddressBook() {
        this.entries = new ArrayList<>();
    }

    /**
     * Adds an AddressEntry to the AddressBook.
     *
     * @param entry The AddressEntry to be added.
     */
    public void add(AddressEntry entry) {
        entries.add(entry);
    }

    /**
     * Removes a specific AddressEntry from the AddressBook.
     *
     * @param entry The AddressEntry to be removed.
     * @return true if the entry was successfully removed; false otherwise.
     */
    public boolean remove(AddressEntry entry) {
        return entries.remove(entry);
    }

    /**
     * Finds and returns a list of AddressEntry objects whose last names start with
     * the specified string, ignoring case.
     *
     * @param lastName The beginning of the last name to search for.
     * @return A list of AddressEntry objects matching the search criteria.
     */
    public List<AddressEntry> find(String lastName) {
        String searchQuery = lastName.toLowerCase(); // Convert search query to lower case
        return entries.stream()
                .filter(entry -> entry.getLastName().toLowerCase().startsWith(searchQuery))
                .collect(Collectors.toList());
    }

    /**
     * Lists all AddressEntry objects in the AddressBook, sorted alphabetically
     * by last name, ignoring case.
     *
     * @return A list of all AddressEntry objects, sorted alphabetically by last name.
     */
    public List<AddressEntry> list() {
        return entries.stream()
                .sorted(Comparator.comparing(AddressEntry::getLastName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    /**
     * Loads AddressEntry objects from a specified file name. Each line in the file
     * should represent one AddressEntry, with fields separated by commas.
     * The expected order is: firstName, lastName, street, city, state, zip, email, phone.
     *
     * @param fileName The name to the file to be loaded.
     */
    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming a comma-separated values file
                if (parts.length == 8) { // Assuming 8 fields per address entry
                    AddressEntry entry = new AddressEntry(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim(), Integer.parseInt(parts[5].trim()), parts[6].trim(), parts[7].trim());
                    this.add(entry);
                }
            }
            System.out.println("File loaded successfully.");
        } catch (IOException e) {
            System.err.println("Failed to load file: " + e.getMessage());
        }
    }
}