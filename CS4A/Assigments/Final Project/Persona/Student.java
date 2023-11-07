/**
 * Student-- Inherates form Persona and create Object Student
 */
package Persona;

import java.util.Calendar;

public class Student extends Persona{
    private Calendar dof;
    private Calendar firstDay;
    private double gpa;
    private int credits;

    public Student(String firstName, String middle, String lastName, String email, String telephone, String address,
            String city, String state, String zipcode, Calendar dof, Calendar firstDay, double gpa) throws Exception {
        super(firstName, middle, lastName, email, telephone, address, city, state, zipcode);
        setDof(dof);
        setFirstDay(firstDay);
        setGpa(gpa);
        credits = 0;
    }

    
    /** 
     * getDof-- Get Date of Birth of the Student
     * 
     * @author Andres Quintana
     * @return Calendar
     */
    public Calendar getDof() {
        return dof;
    }

    
    /** 
     * setDof-- Set Date of Birth of the Student
     * 
     * @author Andres Quintana
     * @param dof
     */
    public void setDof(Calendar dof) {
        this.dof = dof;
    }

    
    /** 
     * getFirstDay-- Get Date of First Day in School of the Student
     * 
     * @author Andres Quintana
     * @return Calendar
     */
    public Calendar getFirstDay() {
        return firstDay;
    }

    
    /** 
     * setFirstDay-- Set Date of First Day in School of the Student
     * 
     * @author Andres Quintana
     * @param firstDay
     */
    public void setFirstDay(Calendar firstDay) {
        this.firstDay = firstDay;
    }

    
    /** 
     * getGpa-- Get GPA of the Student
     * 
     * @author Andres Quintana
     * @return double Gpa
     */
    public double getGpa() {
        return gpa;
    }

    
    /** 
     * getGpa-- Set GPA of the Student
     * 
     * @author Andres Quintana
     * @param gpa
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    
    /** 
     * getCredits-- Get Credit of the Student for this semester
     * 
     * @author Andres Quintana
     * @return int Credits
     */
    public int getCredits() {
        return credits;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return
            "\nName: " + getFullName() + "\nE-mail: " + getEmail() + "\nTelephone: " + getTelephone() +
            "\nAddress: " + getFullAddress() + "\nID: " + getId() + "\nDOF: " + dof.getTime() +
            "\nFirst Day Attending: " + firstDay.getTime() + "\nGPA: " + gpa + "\n";
    }

	
    /**
     * isValid-- Get if Student fullfill requirments to add a course
     * 
     * @author Andres Quintana
     * @param capacity
     * @return boolean
     */
    public boolean isValid(int capacity) {
        if(credits == capacity)
            return false;
            
        credits++;
		return true;
	}

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dof == null) ? 0 : dof.hashCode());
        return result;
    }

    
    /** 
     * equals-- Compare if the students Id are the same, if so they are equal
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
        Student other = (Student) obj;
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
