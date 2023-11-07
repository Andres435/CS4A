/**
 * Program that generates the ScheduleCourses for the semester, 
 * the Student Schedule for the semeter, and the professor Schedule for the semester.
 * Then, save the data into a different file for each schedule.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Persona.*;
import Course.*;
import Files.WriteFiles;
import Match.*;

public class Main {
    
    /** 
     * main-- Get information from the Files, Schedule Courses and save it into specific files
     * 
     * @author Andres Quintana
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Get Schedule Limits for Professor and Students
        final int[] parameters = loadParameters();

        // Get Student Data
        File input = new File("Files/Input/AllStudents.txt");
        StudentSet students = new StudentSet(loadStudentData(input));
        // Print to console total students
        System.out.println("\nTotal Students: " + students.getStudents().size());

        // Get Professor Data
        input = new File("Files/Input/AllFaculty.txt");
        ArrayList<Professor> professors = loadProfessorData(input);
        // Print to console total professors
        System.out.println("Total Faculty: " + professors.size());

        try{
            // Get Course Data and save into file
            WriteFiles unscheduled = new WriteFiles("Files/Output/UnscheduledCourseSessions.txt");
            WriteFiles scheduled = new WriteFiles("Files/Output/ScheduledCourseSessions.txt");
            input = new File("Files/Input/AllCourses.txt");
            ArrayList<CourseSchedule> courses = loadCourseData(input, students.getStudents(), professors, parameters[0], parameters[1]);
            // Print to console total courses
            System.out.println("Total Courses: " + courses.size());
            for (int i = 0; i < courses.size(); i++)
                courses.get(i).writeFile(scheduled, unscheduled);
            
            //Print to console total Sessions
            int totalSessions = 0;
            for(int i = 0; i < courses.size(); i++)
                totalSessions+=courses.get(i).getSessions().getSessions().size();
            System.out.println("Total Sessions: " + totalSessions);

            // Get Student Scheduled and save into file
            WriteFiles unscheduledStudent = new WriteFiles("Files/Output/UnscheduledStudents.txt");
            WriteFiles scheduledStudent = new WriteFiles("Files/Output/ScheduledStudents.txt");
            ArrayList<StudentSchedule> mySchedule = new ArrayList<>();
            for (int i = 0; i < students.getStudents().size(); i++) {
                mySchedule.add(new StudentSchedule(courses, students.getStudents().get(i)));
                mySchedule.get(i).writeFile(scheduledStudent, unscheduledStudent);
            }

            // Print to console Uncheduled Courses
            int totalUnscheduled = 0;
            for(int i = 0; i < courses.size(); i++)
                if(courses.get(i).getSessions().getSessions().size() == 0)
                    totalUnscheduled++;
            System.out.println("Total Unscheduled Courses: " + totalUnscheduled);

            // Print to console Uncheduled Students
            totalUnscheduled = 0;
            for(int i = 0; i < mySchedule.size(); i++)
                if(mySchedule.get(i).getStudent().getCredits() == 0)
                    totalUnscheduled++;
            System.out.println("Total Unscheduled Students: " + totalUnscheduled);
            System.out.println();

            // Get Professor Schedule and save into file
            WriteFiles scheduledProfessor = new WriteFiles("Files/Output/Faculty.txt");
            ArrayList<ProfessorSchedule> myClasses = new ArrayList<>();
            for (int i = 0; i < professors.size(); i++) {
                myClasses.add(new ProfessorSchedule(courses, professors.get(i)));
                myClasses.get(i).writeFile(scheduledProfessor);
            }
        } catch(IOException ex){
            System.out.println("Error handling file" + ex);
        }
    }

    
    /** 
     * loadParameters-- From specific file take Student and Professor Schedule Limitations
     * 
     * @author Andres Quintana
     * @return int[]
     * @throws IOException
     */
    public static int[] loadParameters() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Files/Input/ContolParameters.txt"));
            int[] parameters = { Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()) };
            br.close();
            return parameters;
        } catch (IOException ex) {
            System.out.println("IOException at Parameters: " + ex);
        }
        return null;
    }

    
    /** 
     * loadStudentData-- From specific file take Student Data
     * 
     * @author Andres Quintana
     * @param input
     * @return ArrayList<Student>
     * @throws Exception
     */
    public static ArrayList<Student> loadStudentData(File input) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String read = br.readLine(); // jump first line

            // Get Student Data from file
            while (!read.equals(null)) {
                String firstName = br.readLine();
                String middle = br.readLine();
                String lastName = br.readLine();
                String email = br.readLine();
                String telephone = br.readLine();
                String address = br.readLine();
                String city = br.readLine();
                String state = br.readLine();
                String zipcode = br.readLine();
                String strDate = br.readLine();
                String strDate2 = br.readLine();
                double gpa = Double.parseDouble(br.readLine());

                Calendar dof = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                dof.setTime(sdf.parse(strDate));
                Calendar firstDay = Calendar.getInstance();
                firstDay.setTime(sdf.parse(strDate2));

                Student student = new Student(firstName, middle, lastName, email, telephone, address, city, state, zipcode, dof, firstDay, gpa);
                students.add(student);

                read = br.readLine();
                if(read == null)
                    break;
            }
            br.close();
        } catch(IOException ex){
            System.out.println("IOException at Student Data: " + ex);
        }

        return students;
    }

    
    /** 
     * loadProfessorData-- From specific file take Professor Data
     * 
     * @author Andres Quintana
     * @param input
     * @return ArrayList<Professor>
     * @throws Exception
     */
    public static ArrayList<Professor> loadProfessorData(File input) throws Exception {
        ArrayList<Professor> professors = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(input));
            String read = br.readLine(); // Jump first line

            // Get Professor Data from file
            while (!read.equals(null)) {
                String firstName = br.readLine();
                String middle = br.readLine();
                String lastName = br.readLine();
                String email = br.readLine();
                String telephone = br.readLine();
                String address = br.readLine();
                String city = br.readLine();
                String state = br.readLine();
                String zipcode = br.readLine();
                String ternurated = br.readLine();
                String strDate = br.readLine();

                Calendar hiredDate = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                hiredDate.setTime(sdf.parse(strDate));

                Professor professor = new Professor(firstName, middle, lastName, email, telephone, address, city, state, zipcode, ternurated, hiredDate);
                professors.add(professor);

                read = br.readLine();
                if(read == null)
                    break;
            }
            br.close();
        } catch(IOException ex){
            System.out.println("IOException at Professor Data: " + ex);
        }
        return professors;
    }

    
    /** 
     * loadCourseData-- From specific file take Course Data
     * 
     * @author Andres Quintana
     * @param input
     * @param students
     * @param professors
     * @param max_Professor
     * @param max_Student
     * @return ArrayList<CourseSchedule>
     * @throws Exception
     */
    public static ArrayList<CourseSchedule> loadCourseData(File input, ArrayList<Student> students, ArrayList<Professor> professors
                                                          , int max_Professor, int max_Student) throws Exception {
        ArrayList<CourseSchedule> allCourses = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(input));
            String read = br.readLine(); // Jump first line

            // Get Course Data from file
            while (!read.equals(null)) {
                String department = br.readLine();
                String code = br.readLine();
                String description = br.readLine();

                Course course = new Course(department, code, description);

                int minSize = Integer.parseInt(br.readLine());
                int maxSize = Integer.parseInt(br.readLine());
                int numSessions = Integer.parseInt(br.readLine());

                File inputMatch = new File("Files/Input/StudentWishSchedule.txt");
                ArrayList<Session> sessionSet = new ArrayList<>();

                // Find Department Professors
                ArrayList<Professor> fitCourse = new ArrayList<>();
                for(int i = 0; i < professors.size(); i++)
                    if(department.equals(professors.get(i).getTenurated()))
                        fitCourse.add(professors.get(i));

                // Fill sessions
                sessionSet = matchData(inputMatch, students, fitCourse, course.getId(), numSessions, maxSize, max_Professor, max_Student);
                SessionSet sessions = new SessionSet(sessionSet);

                // Set Course Schedule
                CourseSchedule courseSchedule = new CourseSchedule(course, minSize, maxSize, sessions);
                allCourses.add(courseSchedule);

                read = br.readLine();
                if(read == null)
                    break;
            }
            br.close();
        } catch(IOException ex){
            System.out.println("IOException at Course Data: " + ex);
        }
        return allCourses;
    }

    
    /** 
     * matchData-- From specific file take Session Data, Student wish list, and then match it based on parameters.
     * 
     * @author Andres Quintana
     * @param input
     * @param students
     * @param professors
     * @param course
     * @param max_Sessions
     * @param max
     * @param max_Professor
     * @param max_Student
     * @return ArrayList<Session>
     * @throws Exception
     */
    public static ArrayList<Session> matchData(File input, ArrayList<Student> students, ArrayList<Professor> professors, String course
                                              , int max_Sessions, int max, int max_Professor, int max_Student) throws Exception {
        StudentSet fillCourse = new StudentSet(new ArrayList<>());
        ArrayList<Session> sessions = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(input));
            String read = br.readLine(); // Jump first line
            
            // Get Data form file
            while (read != null) {
                String firstName = br.readLine();
                String middle = br.readLine();
                String lastName = br.readLine();
                String fullName = firstName + " " + middle + " " + lastName;
                
                // Get list of students for this course
                String wishCourse = null;
                while (!read.equals(null)) {
                    wishCourse = br.readLine();
                    if(wishCourse == null)
                        break;
                    if(wishCourse.equals(","))
                        break;
                    
                    if(course.equals(wishCourse)){
                        for(int i = 0; i < students.size(); i++){
                            if (fullName.equals(students.get(i).getFullName())){
                                fillCourse.addPerson(students.get(i));
                            }
                        }
                    }
                }
                if(wishCourse == null)
                    break;
            }
            // Set students than fullfill the requirmnets to the sessions
            sessions = fillCourse.fillSessions(max_Sessions, max, max_Student);

            // Set profesors to each sessions (Professors can't teach the same course more than once)
            for(int i = 0; i < sessions.size(); i++){
                outerlopp:
                for(int j = 0; j < professors.size(); j++){
                    if(sessions.size() != 0) {
                        if(professors.get(j).isValid(max_Professor)) {
                            sessions.get(i).setProfessor(professors.get(j));
                            professors.remove(professors.get(j));
                            break outerlopp;
                        }
                    }
                }
            }
            br.close();
        } catch(IOException ex){
            System.out.println("IOException at Session Data: " + ex);
        }
        return sessions;
    }
}