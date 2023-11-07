/**
 * Class that get Student Schedule
 */
package Match;

import java.util.ArrayList;

import Course.Course;
import Files.WriteFiles;
import Persona.Student;

public class StudentSchedule implements Scheduler{
    Student student;
    // CourseSet and String SessionSet work as pairs
    ArrayList<Course> myCourses = new ArrayList<>();
    ArrayList<String> mySessions = new ArrayList<>();

    public StudentSchedule(ArrayList<CourseSchedule> allCourses, Student student) throws Exception {
        this.student = student;
        addToSchedule(allCourses);
    }

    /** 
     * getStudent-- Get Students variable
     * 
     * @author Andres Quintana
     * @return Student
     */
    public Student getStudent(){
        return student;
    }
    
    /** 
     * addToSchedule -- Get Courses Schedulled this semester and find the course and session the student is in
     * 
     * @author Andres Quintana
     * @param allCourses
     * @throws Exception
     */
    @Override
    public void addToSchedule(ArrayList<CourseSchedule> allCourses) throws Exception {
        for(int i = 0; i < allCourses.size(); i++) {
            if(allCourses.get(i).getSessions().findStudent(this.student)) {
                myCourses.add(allCourses.get(i).getCourse());
                mySessions.add(allCourses.get(i).getSessions().findStudentCopySession(this.student));
            }
        }
    }

    
    /** 
     * writeFile -- Save data into a file
     * 
     * @author Andres Quintana
     * @param scheduled
     * @param unscheduled
     * @throws Exception
     */
    public void writeFile(WriteFiles scheduled, WriteFiles unscheduled) throws Exception {
        if(student.getCredits() == 0) {
            unscheduled.writeToFile("Unscheduled Student: \n" + student);
        }
        else{
            scheduled.writeToFile( "Student: " + student);
            for(int i = 0; i < myCourses.size(); i++){
                scheduled.writeToFile("Course Id: " + myCourses.get(i).getId());
                scheduled.writeToFile("Description: " + myCourses.get(i).getDescription());
                scheduled.writeToFile("Session Id: " + mySessions.get(i));
            }
        }
    }

    
    /** 
     * printSchedule-- Print the Data into the console
     * 
     * @author Andres Quintana
     * @throws Exception
     */
    public void printSchedule() throws Exception {
        if(student.getCredits() != 0) {
            System.out.println( "\nStudent: " + student);
            for(int i = 0; i < myCourses.size(); i++){
                System.out.println("Course Id: " + myCourses.get(i).getId());
                System.out.println("Description: " + myCourses.get(i).getDescription());
                System.out.println("Session Id: " + mySessions.get(i));
            }
        }
        else{
            System.out.println("Unescheduled Student: ");
            System.out.println(student);
        }
    }
}
