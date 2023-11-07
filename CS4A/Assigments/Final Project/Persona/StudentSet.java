/**
 * StudentSet-- Get specific set of students based on the whole list
 */
package Persona;

import java.util.ArrayList;

import Course.Session;
import Utilities.DataValidation;

public class StudentSet{
    private ArrayList<Student> students;

    public StudentSet(ArrayList<Student> students) throws Exception {
        setStudents(students);
    }

    
    /** 
     * getStudents-- Get Students list variable
     * 
     * @author Andres Quintana
     * @return ArrayList<Student> students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    
    /** 
     * setStudents-- Set Students list variable
     * 
     * @author Andres Quintana
     * @param students
     * @throws Exception
     */
    public void setStudents(ArrayList<Student> students) throws Exception {
        DataValidation.ensureObjectNotNull("Students", students);
        this.students = students;
    }

    
    /** 
     * addPerson-- add new Student to the list
     * 
     * @author Andres Quintana
     * @param person
     */
    public void addPerson(Student person) {
        if(!students.contains(person))
            students.add(person);
    }

    
    /** 
     * containStudent-- Get if Students variable is within the list
     * 
     * @author Andres Quintana
     * @param student
     * @return boolean
     */
    public boolean containsStudent(Student student) {
        for (int i = 0; i < students.size(); i++)
            if(students.get(i).equals(student))
                return true;
                
        return false;
    }

    
    /** 
     * sessionRequirments-- Get Students that fullfill the requirments
     * 
     * @author Andres Quintana
     * @param sessionCapacity
     * @param capacity
     * @return ArrayList<Student>
     */
    public ArrayList<Student> sessionRequirments(int sessionCapacity, int capacity) {
        ArrayList<Student> fillRequirments = new ArrayList<>();
        int count = 0;
        
        for(int i = 0; i < students.size(); i++)  {
            if(students.get(i).isValid(capacity)) {
                if(count < sessionCapacity) {
                    fillRequirments.add(students.get(i));
                    students.remove(i);
                    count++;
                }
            }
        }
        return fillRequirments;
    }

    
    /** 
     * fillSessions-- Get sessions based on the student list
     * 
     * @author Andres Quintana
     * @param maxSessions
     * @param sessionCapacity
     * @param studentCapacity
     * @return ArrayList<Session>
     * @throws Exception
     */
    public ArrayList<Session> fillSessions(int maxSessions, int sessionCapacity, int studentCapacity) throws Exception {
        ArrayList<Session> sessions = new ArrayList<>();

        for(int i = 0; i < maxSessions; i++){
            sessions.add(new Session(new StudentSet(this.sessionRequirments(sessionCapacity, studentCapacity))));
            sessions.get(i).setSessionId(i);
            if(students.size() == 0){
                if(sessions.get(i).getStudents().getStudents().size() == 0)
                    sessions.remove(sessions.get(i));
                return sessions;
            }
        }
        return sessions;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "\nStudents: " + students;
    }
}
