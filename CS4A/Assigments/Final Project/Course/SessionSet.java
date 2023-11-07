/**
 *  Class that make easy to find professor and students within the session list
 */
package Course;

import java.util.ArrayList;

import Persona.*;
import Utilities.DataValidation;


public class SessionSet{
    ArrayList<Session> sessions = new ArrayList<>();

    public SessionSet(ArrayList<Session> sessions) throws Exception {
        setSessions(sessions);;
    }

	
    /** 
     * getSessions-- Get Sessions variable
     * 
     * @author Andres Quintana
     * @return ArrayList<Session> sessions
     */
    public ArrayList<Session> getSessions() {
        return sessions;
    }

    
    /** 
     * setSessions-- Set Sessions variable
     * 
     * @author Andres Quintana
     * @param sessions
     * @throws Exception
     */
    public void setSessions(ArrayList<Session> sessions) throws Exception {
        DataValidation.ensureObjectNotNull("Sessions", sessions);
        this.sessions = sessions;
    }

    
    /** 
     * addSession-- add Session to the session list
     * 
     * @author Andres Quintana
     * @param session
     */
    public void addSession(Session session) {
        if(session != null)
            sessions.add(session);
    }

    
    /** 
     * containSession-- Get if a specific session is withing the list
     * 
     * @author Andres Quintana
     * @param session
     * @return boolean
     */
    public boolean containSession(Session session) {
        for (int i = 0; i < sessions.size(); i++)
            if(!sessions.get(i).equals(session))
                    return true;
                
        return false;
    }

    
    /** 
     * findProfessor-- Get if a specific professor is withing the list
     * 
     * @author Andres Quintana
     * @param professor
     * @return boolean
     */
    public boolean findProfessor(Professor professor){
        for(int i = 0; i < sessions.size(); i++)
            if(sessions.get(i).getProfessor().equals(professor))
                return true;
        
        return false;
    }

    
    /** 
     * findProfessorCopySession-- Get if a specific professor is withing the list and return that session
     * 
     * @author Andres Quintana
     * @param professor
     * @return Session
     */
    public Session findProfessorCopySession(Professor professor){
        for(int i = 0; i < sessions.size(); i++)
            if(sessions.get(i).getProfessor().equals(professor))
                return sessions.get(i);
        
        return null;
    }

    
    /** 
     * findStudent-- Get if a specific student is withing the list
     * 
     * @author Andres Quintana
     * @param student
     * @return boolean
     * @throws Exception
     */
    public boolean findStudent(Student student) throws Exception {
        for(int i = 0; i < sessions.size(); i++)
            if(sessions.get(i).getStudents().containsStudent(student))
                return true;
        
        return false;
    }

    
    /** 
     * findStudentCopySession-- Get if a specific student is withing the list and return that session
     * 
     * @author Andres Quintana
     * @param student
     * @return String ID
     * @throws Exception
     */
    public String findStudentCopySession(Student student) throws Exception {
        for(int i = 0; i < sessions.size(); i++)
            if(sessions.get(i).getStudents().containsStudent(student))
                return sessions.get(i).getSessionId();
        
        return null;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "\nSessions Set: " + sessions;
    }
}
