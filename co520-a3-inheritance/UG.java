import java.util.ArrayList;

/**
 * The UG class represents undergraduate student at a university.
 * It holds relevant details of a student.
 * 
 * @author Yang He
 * @version Aug 2018
 */
public class UG extends Student
{

    // list of course IDs that the student takes
    private ArrayList<String> courseIDs;

    /**
     * Create a new undergraduate student.
     */
    public UG(String sid, String name, boolean isMale)
    {
        super(sid, name, isMale);
        this.courseIDs = new ArrayList<String>();
    }
    
      
    /**
     * Return the list of course IDs taken by the student.
     */
    public ArrayList<String> getCourseIDs()
    {
        return courseIDs;
    }

    // register the student on a given course
    public void registerOn(Course c) {
        courseIDs.add(c.getCID());
    }
    
    /**
     * Print the student's details to the output terminal.
     * e.g.  Student ID: stud23    Name: Cathy Lee   Gender: Female
     *       Courses: CO320 CO323
     */
    public void print()
    {
        super.print();
        if (courseIDs.size() > 0) { 
            System.out.print("Courses: ");
            for (String cid: courseIDs) {
                System.out.print(cid + " ");
            }
            System.out.println();
        }
    }
}
