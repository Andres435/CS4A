import java.util.Date;

import utilities.DataValidation;

public class Worker extends Contact {

    private String department;

    public Worker(String firstName, String lastName, String email, String telephoneNumber, String id, Date hireDate, String department) 
        throws Exception
    {
        super(firstName, lastName, email, telephoneNumber, id, hireDate);
        setDepartment(department);
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) throws Exception {
        DataValidation.ensureValidString("Department", department);
        this.department = department;
    }

    
    @Override
    public String toString() {
        return 
            super.toString() + ", department='" + getDepartment() + "'";
    }

    @Override
    public String getRole() {
        return "Worker";
    }
    
}
