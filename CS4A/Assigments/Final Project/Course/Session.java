/**
 * Class that match a professor with a list of students
 */
package Course;

import Persona.*;
import Utilities.*;

public class Session {
    private String sessionId;
    private Professor professor;
    private StudentSet students;

    public Session(StudentSet students) 
            throws Exception {
        IntegerIdGenerator id = new IntegerIdGenerator();
        sessionId = id.generateId();
        setStudents(students);
    }

    public Session(Professor professor, StudentSet students, int sessionCapacity, int maxCapacity) 
            throws Exception {
        IntegerIdGenerator id = new IntegerIdGenerator();
        sessionId = id.generateId();
        setProfessor(professor);
        setStudents(students);
    }

    
    /** 
     * getSessionId-- Get Id variable
     * 
     * @author Andres Quintana
     * @return String ID
     */
    public String getSessionId() {
        return sessionId;
    }

    
    /** 
     * setSessionId-- Set Id variable
     * 
     * @author Andres Quintana
     * @param currentNumber
     */
    public void setSessionId(int currentNumber) {
        IntegerIdGenerator id = new IntegerIdGenerator(currentNumber);
        this.sessionId = id.generateId();
    }

    
    /** 
     * getProfessor-- Get Professor variable
     * 
     * @author Andres Quintana
     * @return Professor
     */
    public Professor getProfessor() {
        return professor;
    }

    
    /** 
     * setProfessor-- Set Professor variable
     * 
     * @author Andres Quintana
     * @param professor
     * @throws Exception
     */
    public void setProfessor(Professor professor) throws Exception {
        DataValidation.ensureObjectNotNull("Professor", professor);
            this.professor = professor;
    }

    
    /** 
     * getStudentSet-- Get Student List variable
     * 
     * @author Andres Quintana
     * @return StudentSet
     * @throws Exception
     */
    public StudentSet getStudents() throws Exception {
        DataValidation.ensureObjectNotNull("Students", students);
        return students;
    }

    
    /** 
     * setStudentSet-- Set Student List variable
     * 
     * @author Andres Quintana
     * @param students
     * @throws Exception
     */
    public void setStudents(StudentSet students) throws Exception {
        DataValidation.ensureObjectNotNull("Students", students);
        this.students = students;
    }

	
    /** 
     * isvalid-- Get if student size meet the requirment
     * 
     * @author Andres Quintana
     * @param capacity
     * @return boolean
     */
    public boolean isValid(int capacity) {
        if(capacity < students.getStudents().size())
            return false;    
        
        return true;
	}

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
        return result;
    }

    
    /** 
     * equals-- Compare if the session Id are the same, if so they are equal
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
        Session other = (Session) obj;
        if (sessionId == null) {
            if (other.sessionId != null)
                return false;
        } else if (!sessionId.equals(other.sessionId))
            return false;
        return true;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "\nSession ID:" + sessionId + "\nProfessor: " + professor  + students + "\n";
    }
}
