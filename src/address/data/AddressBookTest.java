package address.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Tests for the AddressBook class.
 * @author Hasibullah Ayoubi
 * @since Feb. 26, 2024
 * @version 1
 */
public class AddressBookTest {

    private AddressBook addressBook;

    /**
     * Sets up a new AddressBook instance before each test.
     */
    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
    }

    // Tests for add method
    /**
     * Tests adding a single entry to the AddressBook and verifies it is added correctly.
     */
    @Test
    void testAddSingleEntry() {
        AddressEntry entry = new AddressEntry("Abdul", "Ahmadi", "123 Apple St", "Hayward", "CA", 94555, "510-1234-2345", "abdul@yahoo.com");
        addressBook.add(entry);
        assertEquals(1, addressBook.list().size());
    }

    /**
     * Tests adding multiple entries to the AddressBook and verifies they are all added correctly.
     */
    @Test
    void testAddMultipleEntries() {
        AddressEntry entry1 = new AddressEntry("Ahmad", "ali", "3211 B St", "Hayward", "CA", 94541, "510-8800-5678", "ahmad@gmail.com");
        AddressEntry entry2 = new AddressEntry("Mohammad", "Benafa", "5300 C St", "Livermore", "CA", 94550, "925-7766-9012", "mohammad@hotmail.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        assertEquals(2, addressBook.list().size());
    }

    // Tests for remove method
    /**
     * Tests the removal of an existing entry from the AddressBook and verifies the entry is removed correctly.
     */
    @Test
    void testRemoveExistingEntry() {
        AddressEntry entry = new AddressEntry("Peanut", "Grow", "1010 Concord Ave", "Concord", "CA", 94520, "925-110-3456", "peanut@gmail.com");
        addressBook.add(entry);
        assertTrue(addressBook.remove(entry));
        assertEquals(0, addressBook.list().size());
    }

    /**
     * Tests the attempt to remove a non-existing entry from the AddressBook and verifies it fails as expected.
     */
    @Test
    void testRemoveNonExistingEntry() {
        AddressEntry entry = new AddressEntry("Charlie", "Puth", "1271 polk St", "San Francisco", "CA", 94321, "510-4420-7890", "charlie@gmail.com");
        assertFalse(addressBook.remove(entry));
    }

    // Tests for find method
    /**
     * Tests finding an entry by an exact match of the last name.
     * Verifies that the correct entry is found.
     */
    @Test
    void testFindEntryByExactLastName() {
        AddressEntry entry = new AddressEntry("Hasib", "Ayoubi", "1411 wall St", "San Francisco", "CA", 94338, "510-7734-6789", "hasibayoub@yahoo.com");
        addressBook.add(entry);
        List<AddressEntry> results = addressBook.find("Ayoubi");
        assertEquals(1, results.size());
    }

    /**
     * Tests finding an entry by a partial match of the last name.
     * Verifies that the correct entry is found even with only the beginning part of the last name.
     */
    @Test
    void testFindEntryByPartialLastName() {
        AddressEntry entry = new AddressEntry("Mark", "Lyon", "2351 main St", "Oakland", "CA", 94221, "510-9032-4321", "lyon@gmail.com");
        addressBook.add(entry);
        List<AddressEntry> results = addressBook.find("Lyon");
        assertEquals(1, results.size());
    }

    // Tests for list method
    /**
     * Tests listing entries from an empty AddressBook.
     * Verifies that the list operation correctly returns an empty list when no entries are present.
     */
    @Test
    void testListEntriesWhenEmpty() {
        assertTrue(addressBook.list().isEmpty());
    }

    /**
     * Tests listing entries from a populated AddressBook.
     * Verifies that all added entries are correctly listed.
     */
    @Test
    void testListEntriesWhenPopulated() {
        AddressEntry entry = new AddressEntry("Karim", "Misbah", "2020 Bush St", "San Francisco", "CA", 94231, "510-8457-2345", "karim@hotmail.com");
        addressBook.add(entry);
        assertFalse(addressBook.list().isEmpty());
    }

    //  readFromFile tests
    /**
     * Tests reading from a file that exists but contains no AddressEntry data.
     * Verifies that no entries are added to the AddressBook.
     */
    @Test
    void testReadFromEmptyFile() {
        String name = "empty.txt"; // Adjust the path as necessary
        addressBook.readFromFile(name);
        assertTrue(addressBook.list().isEmpty());
    }

    /**
     * Tests reading from a file that contains exactly one AddressEntry.
     * This test verifies that the AddressBook correctly parses and adds a single entry
     * from a file and that the entry's details match the expected values.
     */
    @Test
    void testReadFromFileWithOneEntry() {
        String path = "oneEntry.txt"; // Adjust the path as necessary
        addressBook.readFromFile(path);
        assertEquals(1, addressBook.list().size());

        AddressEntry firstEntry = addressBook.list().get(0);
        assertEquals("Hasibullah", firstEntry.getFirstName());
        assertEquals("Ayoubi", firstEntry.getLastName());

    }

}
