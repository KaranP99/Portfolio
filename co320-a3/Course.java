/**
 * The Course class represents a course run at a university.
 * It holds relevant details of a course.
 * 
 * @author Yang He
 * @version 2018.09.20
 */
public class Course
{
    // the course ID
    private String cid;
    
    // the course title
    private String title;
    
    // the course convenor
    private Staff convenor;
    
    // number of students on the course
    private int studentNos;
    
    /**
     * Create a new course with a given ID, title and convenor.
     * 
     * @param  cid     A course ID
     * @param  title   A course title
     * @param  convenor   An object of Staff
     */
    public Course(String cid, String title, Staff convenor)
    {
        this.cid = cid;
        this.title = title;
        this.convenor = convenor;
        studentNos = 0;  // Default 
    }

    /**
     * Get the course ID.
     * 
     * @return  The course ID.
     */
    public String getCID()
    {
        return cid;
    }
    
    /**
     * Get the course title
     * 
     * @return The course title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Get the course convenor
     * 
     * @return  The course convenor
     */
    public Staff getConvenor()
    {
        return convenor;
    }

    /**
     * Set a new convenor for this course.
     * 
     * @param convenor  An object of Staff
     */
    public void setConvenor(Staff convenor)
    {
        this.convenor = convenor;
    }
    
    /**
     * Get the number of students on the course
     * 
     * @return  The number of students on the course
     */
    public int getStudentNos()
    {
         return studentNos;
    }

    /**
     * Set the number of students on the course.
     * 
     * @param  number  Number of students on the course.
     */
    public void setStudentNos(int number)
    {
        studentNos = number;
    }

    /**
     * Print the course details to the output terminal.
     */
    public void print()
    {
        System.out.println(cid + " - " + title);
        System.out.println("Convenor: " + convenor.getName());
        System.out.println("Total number of students: "+ studentNos);
        System.out.println("----------------------------------");
    }
}
