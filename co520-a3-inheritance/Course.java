/**
 * The Course class represents a course run at a university.
 * It holds relevant details of a course.
 * 
 * @author Yang He
 * @version Aug 2018
 */
public class Course
{
    // the course ID
    private String cid;
    
    // the course title
    private String title;
    
    // the course convenor
    private Staff convenor;
    
    /**
     * Create a new course with a given ID, title and convenor.
     */
    public Course(String cid, String title, Staff convenor)
    {
        this.cid = cid;
        this.title = title;
        this.convenor = convenor;
    }

    /**
     * Return the course ID of this course.
     */
    public String getCID()
    {
        return cid;
    }
    
    /**
     * Return the title of this course
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Set a new title for this course.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

        /**
     * Return the convenor of this course
     */
    public Staff getConvenor()
    {
        return convenor;
    }

    /**
     * Set a new convenor for this course.
     */
    public void setConvenor(Staff convenor)
    {
        this.convenor = convenor;
    }

    /**
     * Print the course details, i.e. course id, title and name of the convenor, to the output terminal.
     */
    public void print()
    {
        System.out.println("Course ID: " + cid + 
               "   Title: " + title + "  Convenor: " + convenor.getName());
    }
}
