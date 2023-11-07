/**
 * Professor-- Inherates form Persona and create Object Professor
 */
package Persona;

import java.util.Calendar;

import Utilities.DataValidation;

public class Professor extends Persona{
    private String tenurated;
    private Calendar hiredDate;
    private int numberOfSession;

    public Professor(String firstName, String middle, String lastName, String email, String telephone, String address,
              String city, String state, String zipcode, String tenurated, Calendar hiredDate) throws Exception {
        super(firstName, middle, lastName, email, telephone, address, city, state, zipcode);
        setTenurated(tenurated);
        setHiredDate(hiredDate);
        numberOfSession = 0;
    }

    
    /**
     * getTenurated-- get Tenurated variable
     * 
     * @author Andres Quintana
     * @return String Tenurated
     */
    public String getTenurated() {
        return tenurated;
    }

    
    /** 
     * setTenurated-- set Tenurated variable
     * 
     * @author Andres Quintana
     * @param tenurated
     * @throws Exception
     */
    public void setTenurated(String tenurated) throws Exception {
        DataValidation.ensureNonEmptyString("Tenurated", tenurated);
        this.tenurated = tenurated;
    }

    
    /** 
     * getHiredDate- get Hired Date variable
     * 
     * @author Andres Quintana
     * @return Calendar
     */
    public Calendar getHiredDate() {
        return hiredDate;
    }

    
    /** 
     * getHiredDate- get Hired Date variable
     * 
     * @author Andres Quintana
     * @param hiredDate
     */
    public void setHiredDate(Calendar hiredDate) {
        this.hiredDate = hiredDate;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return
            "\nName: " + getFullName() + "\nE-mail: " + getEmail() + "\nTelephone: " + getTelephone() +
            "\nAddress: " + getFullAddress() + "\nID: " + getId() + "\nHired Date: " + hiredDate.getTime() +
            "\nTernurated: " + tenurated + "\n";
    }

	
    /** 
     * isValid- get if professor meet requirmnts to add the sesison
     * 
     * @author Andres Quintana
     * @param capacity
     * @return boolean
     */
    public boolean isValid(int capacity) {
        if(numberOfSession == capacity)
		    return false;
        
        numberOfSession++;
        return true;
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((hiredDate == null) ? 0 : hiredDate.hashCode());
        return result;
    }

    
    /** 
     * equals-- Compare if the professor Id are the same, if so they are equal
     * 
     * @author Andres Quintana
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Professor other = (Professor) obj;
        if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
    /** 
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
