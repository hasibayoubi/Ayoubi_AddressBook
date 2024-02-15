package address;

import address.data.AddressBook;
import address.data.AddressEntry;

public class AddressBookApplication {

    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        initAddressBookExercise(ab);
    }

    public static void initAddressBookExercise(AddressBook ab) {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "Hayward", "CA", 94541, "123-555-1234", "john@gmail.com");
        AddressEntry entry2 = new AddressEntry("Hasib", "Ayoubi", "456 A St", "Livermore", "CA", 94550, "123-555-5678", "hasib@yahoo.com");

        ab.add(entry1);
        ab.add(entry2);
        ab.list();
    }
}
