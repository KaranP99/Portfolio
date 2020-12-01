/**
 * The PG class represents postgraduate student at a university.
 * It holds relevant details of a student.
 * 
 * @author Yang He
 * @version Aug 2018
 */
public class PG extends Student
{

    // list of course IDs registered by the student
    private Staff supervisor;   
    public PG(String sid, String name, boolean isMale)
    {
        super(sid, name, isMale);
    }

    /**
     * Assign a given supervisor to the student.
     */
    public void assignSupervisor(Staff s)
    {

        this.supervisor = s;
    }

    /**
     * Return the supervisor of the student.
     */
    public Staff getSupervisor()
    {
        return supervisor;
    }

    /**
     * Print the student's details to the output terminal.
     * e.g.  
     * Student ID: S01    Name: Cathy Lee   Gender: Female
     * Supervisor: Jane Brown      
     */
    public void print()
    {
        super.print();
        if (supervisor != null) {

            System.out.println("Supervisor: " + supervisor.getID() + " " + supervisor.getName());
        }
    }
}
