package address.data;  // Declaring package name

/**
 * Represents an entry in an address book.
 */
public class AddressEntry {
    // Declaring a class named AddressEntry

    // Declaring private instance variables for storing address details

    /**
     * First name of the individual.
     */
    private String firstName;

    /**
     * Last name of the individual.
     */
    private String lastName;

    /**
     * Street address.
     */
    private String street;

    /**
     * City name.
     */
    private String city;

    /**
     * State name.
     */
    private String state;

    /**
     * Zip code.
     */
    private int zip;

    /**
     * Telephone number.
     */
    private String telephone;

    /**
     * Email address.
     */
    private String email;

    /**
     * Default constructor.
     */
    public AddressEntry(){  // Constructor with no arguments

    };

    /**
     * Constructor with arguments to initialize instance variables.
     *
     * @param firstName First name of the individual.
     * @param lastName Last name of the individual.
     * @param street Street address.
     * @param city City name.
     * @param state State name.
     * @param zip Zip code.
     * @param telephone Telephone number.
     * @param email Email address.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String telephone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephone = telephone;
        this.email = email;
    }

    /**
     * Returns a string representation of the AddressEntry object.
     *
     * @return A string representation of the AddressEntry object.
     */
    public String toString() {
        return  firstName + "\n" +  // Concatenating first name with a newline character
                lastName + "\n" +  // Concatenating last name with a newline character
                street + "\n" +  // Concatenating street with a newline character
                city + "\n" +  // Concatenating city with a newline character
                state + "\n" +  // Concatenating state with a newline character
                zip + "\n" +  // Concatenating zip with a newline character
                telephone + "\n" +  // Concatenating telephone with a newline character
                email + "\n";  // Concatenating email with a newline character
    }

    // Getter methods to retrieve values of instance variables

    /**
     * Retrieves the first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the street address.
     *
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Retrieves the city name.
     *
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Retrieves the state name.
     *
     * @return The state name.
     */
    public String getState() {
        return state;
    }

    /**
     * Retrieves the zip code.
     *
     * @return The zip code.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Retrieves the telephone number.
     *
     * @return The telephone number.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Retrieves the email address.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    // Setter methods to set values of instance variables

    /**
     * Sets the first name.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the street address.
     *
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Sets the city name.
     *
     * @param city The city name to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the state name.
     *
     * @param state The state name to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the zip code.
     *
     * @param zip The zip code to set.
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Sets the telephone number.
     *
     * @param telephone The telephone number to set.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Sets the email address.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
