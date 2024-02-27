package address.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the AddressEntry class
 * Ensures that getters, setters, and constructors function correctly.
 * @author Hasibullah Ayoubi
 * @since Feb. 26, 2024
 * @version 1
 */
public class AddressEntryTest {

    private AddressEntry entry;

    /**
     * Setup method to initialize an AddressEntry object before each test.
     */
    @BeforeEach
    void setUp() {
        // Initialize with default values to test setters and getters separately.
        entry = new AddressEntry();
    }

    /**
     * Tests the parameterized constructor for proper field initialization.
     */
    @Test
    void testParameterizedConstructor() {
        AddressEntry paramEntry = new AddressEntry("Hasib", "Ayoubi", "118 A St", "Hayward", "CA", 94541, "510-4420-1234", "hasibayoubi@gmail.com");
        assertAll("Constructor initializes all fields correctly",
                () -> assertEquals("Hasib", paramEntry.getFirstName()),
                () -> assertEquals("Ayoubi", paramEntry.getLastName()),
                () -> assertEquals("118 A St", paramEntry.getStreet()),
                () -> assertEquals("Hayward", paramEntry.getCity()),
                () -> assertEquals("CA", paramEntry.getState()),
                () -> assertEquals(94541, paramEntry.getZip()),
                () -> assertEquals("510-4420-1234", paramEntry.getTelephone()),
                () -> assertEquals("hasibayoubi@gmail.com", paramEntry.getEmail())
        );
    }

    /**
     * Tests setting and getting the first name.
     */
    @Test
    void testSetAndGetFirstName() {
        entry.setFirstName("Hasib");
        assertEquals("Hasib", entry.getFirstName());
    }

    /**
     * Tests setting and getting the last name.
     */
    @Test
    void testSetAndGetLastName() {
        entry.setLastName("Ahmad");
        assertEquals("Ahmad", entry.getLastName());
    }

    /**
     * Tests setting and getting the street address.
     */
    @Test
    void testSetAndGetStreet() {
        entry.setStreet("456 B St");
        assertEquals("456 B St", entry.getStreet());
    }

    /**
     * Tests setting and getting the city.
     */
    @Test
    void testSetAndGetCity() {
        entry.setCity("San Francisco");
        assertEquals("San Francisco", entry.getCity());
    }

    /**
     * Tests setting and getting the state.
     */
    @Test
    void testSetAndGetState() {
        entry.setState("CA");
        assertEquals("CA", entry.getState());
    }

    /**
     * Tests setting and getting the zip code.
     */
    @Test
    void testSetAndGetZip() {
        entry.setZip(94520);
        assertEquals(94520, entry.getZip());
    }

    /**
     * Tests setting and getting the telephone number.
     */
    @Test
    void testSetAndGetTelephone() {
        entry.setTelephone("510-8821-6789");
        assertEquals("510-8821-6789", entry.getTelephone());
    }

    /**
     * Tests setting and getting the email address.
     */
    @Test
    void testSetAndGetEmail() {
        entry.setEmail("hasibayoubi@gmail.com");
        assertEquals("hasibayoubi@gmail.com", entry.getEmail());
    }

    /**
     * Tests the toString method for correct format and content.
     */
    @Test
    void testToString() {
        entry = new AddressEntry("Hasib", "Ayoubi", "118 A St", "Hayward", "CA", 94541, "510-4420-1234", "hasibayoubi@gmail.com");
        String expectedString = "Hasib Ayoubi\n118 A St\nHayward, CA 94541\nhasibayoubi@gmail.com\n510-4420-1234";
        assertEquals(expectedString, entry.toString());
    }
}
