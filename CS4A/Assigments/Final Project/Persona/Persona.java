/**
 *  Base class for Personal Information
 */
package Persona;

import Utilities.DataValidation;
import Utilities.UUIDGenerator;

public abstract class Persona implements Comparable<Persona>, Cloneable{
    private String firstName;
    private String middle;
    private String lastName;
    private String email;
    private String telephone;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    protected String id;

    Persona(String firstName, String middle, String lastName, String email, String telephone, String address, 
            String city, String state, String zipcode)
            throws Exception {
        setFirstName(firstName);
        setMiddle(middle);
        setLastName(lastName);
        setEmail(email);
        setTelephone(telephone);
        setAddress(address);
        setCity(city);
        setState(state);
        setZipcode(zipcode);

        UUIDGenerator id = new UUIDGenerator();
        this.id = id.generateId();
    }

    
    /** 
     * getFirstName-- Get First Name variable
     * 
     * @author Andres Quintana
     * @return String FirstName
     */
    public String getFirstName() {
        return firstName;
    }

    
    /** 
     * setFirstName-- Set First Name variable
     * 
     * @author Andres Quintana
     * @param firstName
     * @throws Exception
     */
    public void setFirstName(String firstName) throws Exception {
        DataValidation.ensureNonEmptyString("First Name", firstName);
        this.firstName = firstName;
    }

    
    /** 
     * getMiddle-- Get Middle Name variable
     * 
     * @author Andres Quintana
     * @return String Middle Name
     */
    public String getMiddle() {
        return middle;
    }

    
    /** 
     * setMiddle-- Set Middle Name variable
     * 
     * @author Andres Quintana
     * @param middle
     * @throws Exception
     */
    public void setMiddle(String middle) throws Exception {
        DataValidation.ensureNonEmptyString("Middle Name", middle);
        this.middle = middle;
    }

    
    /** 
     * getLastName-- Get Last Name variable
     * 
     * @author Andres Quintana
     * @return String Last Name
     */
    public String getLastName() {
        return lastName;
    }

    
    /** 
     * setLastName-- Set Last Name variable
     * 
     * @author Andres Quintana
     * @param lastName
     * @throws Exception
     */
    public void setLastName(String lastName) throws Exception {
        DataValidation.ensureNonEmptyString("Last Name", lastName);
        this.lastName = lastName;
    }

    
    /** 
     * getFullName-- Get Full Name by adding together first, middle and last name
     * 
     * @author Andres Quintana
     * @return String Full name
     */
    public String getFullName(){
        return firstName + " " + middle + " " + lastName;
    }

    
    /** 
     * getEmail-- Get Email variable
     * 
     * @author Andres Quintana
     * @return String Email
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * setEmail-- Set Email variable
     * 
     * @author Andres Quintana
     * @param email
     * @throws Exception
     */
    public void setEmail(String email) throws Exception {
        DataValidation.ensureNonEmptyString("Email", email);
        this.email = email;
    }

    
    /** 
     * getTelephone-- Get Telephone variable
     * 
     * @author Andres Quintana
     * @return String Telephone
     */
    public String getTelephone() {
        return telephone;
    }

    
    /** 
     * setTelephone-- Set Telephone variable
     * 
     * @author Andres Quintana
     * @param telephone
     * @throws Exception
     */
    public void setTelephone(String telephone) throws Exception {
        DataValidation.ensureNonEmptyString("Telephone", telephone);
        this.telephone = telephone;
    }

    
    /** 
     * getAddress-- Get Addresss variable
     * 
     * @author Andres Quintana
     * @return String Address
     */
    public String getAddress() {
        return address;
    }

    
    /** 
     * setAddress-- Set Addresss variable
     * 
     * @author Andres Quintana
     * @param address
     * @throws Exception
     */
    public void setAddress(String address) throws Exception {
        DataValidation.ensureNonEmptyString("Address", address);
        this.address = address;
    }

    
    /** 
     * getCity-- Get City variable
     * 
     * @author Andres Quintana
     * @return String City
     */
    public String getCity() {
        return city;
    }

    
    /** 
     * setCity-- Set City variable
     * 
     * @author Andres Quintana
     * @param city
     * @throws Exception
     */
    public void setCity(String city) throws Exception {
        DataValidation.ensureNonEmptyString("City", city);
        this.city = city;
    }

    
    /** 
     * getState-- Get State variable
     * 
     * @author Andres Quintana
     * @return String State
     */
    public String getState() {
        return state;
    }

    
    /** 
     * setState-- Set State variable
     * 
     * @author Andres Quintana
     * @param state
     * @throws Exception
     */
    public void setState(String state) throws Exception {
        DataValidation.ensureNonEmptyString("State", state);
        this.state = state;
    }

    
    /** 
     * getZipcode-- Get Zipcode variable
     * 
     * @author Andres Quintana
     * @return String Zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    
    /** 
     * getZipcode-- Get Zipcode variable
     * 
     * @author Andres Quintana
     * @param zipcode
     * @throws Exception
     */
    public void setZipcode(String zipcode) throws Exception {
        DataValidation.ensureNonEmptyString("Zipcode", zipcode);
        this.zipcode = zipcode;
    }

    
    /** 
     * getFullAddress-- Get full adress by adding address, city, state, and zipcode together
     * 
     * @author Andres Quintana
     * @return String Full Address
     */
    public String getFullAddress(){
        return getAddress() + ", " + getCity() + ", " + getState() + ", " + getZipcode();
    }

    
    /** 
     * getId-- Get Id variable
     * 
     * @author Andres Quintana
     * @return String ID
     */
    public String getId() {
        return id;
    }

    
    /** 
     * compareTo-- Compare if Id are equal
     * 
     * @author Andres Quintana
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Persona o) {
        if (getId().equalsIgnoreCase(o.getId()))
            return 0;
        
        return 1;
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
    /** 
     * equals-- Compare if the Person Id are the same, if so they are equal
     * 
     * @author Andres Quintana
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return
            " Name: " + getFullName() + "\nE-mail: " + email + "\nTelephone: " + telephone +
            "\nAddress: " + getFullAddress() + "\nID: " + id + "\n";
    }
}
