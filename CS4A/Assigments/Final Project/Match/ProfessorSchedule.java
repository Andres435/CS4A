/**
 * Class that get Professor Schedule
 */
package Match;

import java.util.ArrayList;

import Course.*;
import Files.WriteFiles;
import Persona.Professor;

public class ProfessorSchedule implements Scheduler{
    Professor professor;
    // CourseSet and SessionSet work as pairs
    ArrayList<Course> myCourses = new ArrayList<>();
    SessionSet mySessions = new SessionSet(new ArrayList<>());

    public ProfessorSchedule(ArrayList<CourseSchedule> allCourses, Professor professor) throws Exception {
        this.professor = professor;
        this.addToSchedule(allCourses);
    }

    
    /** 
     * addToSchedule -- Get Courses Schedulled this semester and find the course and session the Professor is teaching
     * 
     * @author Andres Quintana
     * @param allCourses
     * @throws Exception
     */
    @Override
    public void addToSchedule(ArrayList<CourseSchedule> allCourses) throws Exception {
        for(int i = 0; i < allCourses.size(); i++) {
            if(allCourses.get(i).getSessions().findProfessor(this.professor)) {
                myCourses.add(allCourses.get(i).getCourse());
                mySessions.addSession(allCourses.get(i).getSessions().findProfessorCopySession(this.professor));
            }
        }
    }

    
    /** 
     * writeFile -- Save data into a file
     * 
     * @author Andres Quintana
     * @param scheduled
     * @throws Exception
     */
    public void writeFile(WriteFiles scheduled) throws Exception {
        scheduled.writeToFile("Professor: " + professor);
        for(int i = 0; i < mySessions.getSessions().size(); i++) {
            scheduled.writeFile(myCourses.get(i));
            scheduled.writeToFile("Session Id: " + mySessions.getSessions().get(i).getSessionId());
            scheduled.writeToFile("Session Size: " + mySessions.getSessions().get(i).getStudents().getStudents().size());
        }
    }

    
    /** 
     * printSchedule -- Print data into the console
     * 
     * @author Andres Quintana
     * @throws Exception
     */
    public void printSchedule() throws Exception {
        System.out.print("\nProfessor: " + professor);
        for(int i = 0; i < mySessions.getSessions().size(); i++) {
            System.out.print(myCourses.get(i));
            System.out.println("Session Id: " + mySessions.getSessions().get(i).getSessionId());
            System.out.println("Session Size: " + mySessions.getSessions().get(i).getStudents().getStudents().size());
        }
    }
}
                    