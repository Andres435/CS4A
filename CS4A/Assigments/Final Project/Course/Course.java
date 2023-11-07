/**
 * Class Course
 */
package Course;

import Utilities.DataValidation;

public class Course implements Comparable<Course>, Cloneable {
    private String department;
    private String code;
    private String description;
    private String id;

    public Course(String department, String code, String description) throws Exception {
        setDepartment(department);
        setCode(code);
        setDescription(description);
        id = department + code;
    }

    
    /** 
     * getDepartment-- Get Department variable
     * 
     * @author Andres Quintana
     * @return String department
     */
    public String getDepartment() {
        return department;
    }

    
    /** 
     * setDepartment-- Set Department variable
     * 
     * @author Andres Quintana
     * @param department
     * @throws Exception
     */
    public void setDepartment(String department) throws Exception {
        DataValidation.ensureNonEmptyString("Department", department);
        this.department = department;
    }

    
    /** 
     * getCode-- Get Code variable
     * 
     * @author Andres Quintana
     * @return String Code
     */
    public String getCode() {
        return code;
    }

    
    /** 
     * setCode-- Set Code variable
     * 
     * @author Andres Quintana
     * @param code
     * @throws Exception
     */
    public void setCode(String code) throws Exception {
        DataValidation.ensureNonEmptyString("Code", code);
        this.code = code;
    }

    
    /** 
     * getDescription-- Get Description variable
     * 
     * @author Andres Quintana
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    
    /** 
     * setDescription-- Set Description variable
     * 
     * @author Andres Quintana
     * @param description
     * @throws Exception
     */
    public void setDescription(String description) throws Exception {
        DataValidation.ensureNonEmptyString("Description", description);
        this.description = description;
    }

    
    /** 
     * getId-- Get ID variable
     * 
     * @author Andres Quintana
     * @return String ID
     */
    public String getId() {
        return id;
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
     * equals-- Compare if the course Id are the same, if so they are equal
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
        Course other = (Course) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    /** 
     * @return String Course
     */
    @Override
    public String toString() {
        return "\nCourse: " + getId() + "\nCourse Description: " + getDescription() + "\n";
    }

    
    /** 
     * compareTo-- Compare if Id are equal
     * 
     * @author Andres Quintana
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Course o) {
        return id.compareTo(o.id);
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
