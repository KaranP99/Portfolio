import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class Database provide facility to store all registations made by students on courses.
 * 
 * @author Yang He
 * @version Aug 2018
 */
public class Database
{
    // private ArrayList<UG> ugList;
    // private ArrayList<PG> pgList;
    private ArrayList<Student> studentList;
    private ArrayList<Staff> staffList;
    private ArrayList<Course> courses;
    private final int MAX_COURSES = 8;

    /**
     * Construct an empty Database.
     */
    public Database()
    {
        studentList = new ArrayList<Student>();
        // pgList = new ArrayList<PG>();
        staffList = new ArrayList<Staff>(); 
        courses = new ArrayList<Course>();
    }

    /**
     * Add a new staff.
     * @param st The staff to be added.
     */
    public void addStaff(Staff s)
    {
        staffList.add(s);
    }

    /**
     * Add a new course.
     * @param c The course to be added.
     */
    public void addCourse(Course c)
    {
        courses.add(c);        
    }

    /**
     * Add a new undergradute student.
     * @param u The undergradute student to be added.
     */
    public void addStudent(Student student)
    {
        studentList.add(student);
    }

    // /**
    // * Add a new postgradute student.
    // * @param u The postgradute student to be added.
    // */
    // public void addPG(PG p)
    // {
    // studentList.add(p);
    // }

    /**
     * Print details of all staff in the database.
     */
    public void printAllStaff()
    {
        System.out.println("List of all staff:");
        for (Staff st: staffList) {
            st.print();
        }
        System.out.println();
    }

    /**
     * Print details of all courses in the database.
     */
    public void printAllCourses()
    {
        System.out.println("List of all courses:");
        for (Course c: courses) {
            c.print();
        }
        System.out.println();
    }

    /**
     * Print details of all students in the database.
     */
    public void printAllStudents()
    {
        System.out.println("List of all students:");
        for (Student studentlist: studentList) {
            if (studentlist instanceof UG) {
                studentlist.print();
            } else if (studentlist instanceof PG){
                studentlist.print();
            }
            System.out.println();
        }

    }

    /**
     * Registrate an undergradute student on a course.
     * @param u The given undergradute student.
     * @param c The given course.
     */
    public void registration(Student s, Course c)
    {
        if (studentList.contains(s)&&courses.contains(c)){
            if(s instanceof UG){
                UG newStu = (UG)s;
                if (newStu.getCourseIDs().contains(c.getCID())){
                    System.out.println("Student is already registered");
                }else{
                    newStu.registerOn(c);

                }
            } else{
                System.out.println("Student is not an undergraduate");
            }
        }
    }

    public int printID(String CID){
        int total = 0;
        if(courseidcheck(CID)){
            for (Student studentlist: studentList) {
                if(studentlist instanceof UG){
                    UG s = (UG)studentlist;
                    if (s.getCourseIDs().contains(CID)){
                        studentlist.print();
                        total++;
                    }
                }
            }
        }else {
            System.out.println("The Course ID is not valid");
        }
        return total;
    }

    public boolean courseidcheck(String courseID){
        boolean check = false;
        for(Course CID: courses){

            if (CID.getCID().contains(courseID)){
                check=  true;
            } else{
                check = false;
            }
        } 
        return check;
    }

    /**
     * Print the details of all undergraduate students who have registered on at lease one course.
     */
    public void printAllRegistration()
    {
        System.out.println("List of all student registrations:");
        for (Student studentlist: studentList) {
            if (studentlist instanceof UG) {
                studentlist.print();
            } 
        }
        System.out.println();
    }

    public void PGSupervisor(String CID)
    {
        for(Student studentlist: studentList){
            if (studentlist instanceof PG){
            PG s = (PG)studentlist;
            if(s.getSupervisor().getID().equals(CID)){
                System.out.println("Name: " + studentlist.getName()+ "ID: "+ studentlist.getSID());
            }
        }
        }
    }
}
