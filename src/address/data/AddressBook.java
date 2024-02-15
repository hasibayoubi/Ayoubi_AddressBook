package address.data;

import java.util.LinkedList;

public class AddressBook {
    private LinkedList<AddressEntry> addressEntryList;

    // Constructor initializes an empty linked list when an AddressBook object is created
    public AddressBook() {
        this.addressEntryList = new LinkedList<>();
    }

    public void list() {
        // Iterates through the linked list and print the string representation of each AddressEntry
        for (AddressEntry entry : addressEntryList) {
            System.out.println(entry.toString());
        }
    }


    public void add(AddressEntry addressEntry) {
        // Adds the provided AddressEntry object to the addressEntryList
        addressEntryList.add(addressEntry);
    }
}
