/**
 * The Staff class represents an academic member of staff at university of Kent.
 * It holds relevant details of a member of staff.
 * 
 * @author Yang He
 * @version Aug 2018
 */
public class Staff
{
    // the staff ID
    private String id;
    
    // the staff's full name
    private String name;
    
    // the staff's office
    private String office;

    /**
     * Create a new staff
     */
    public Staff(String id, String name, String office)
    {
        this.id = id;
        this.name = name;        
        this.office = office;
    }

    /**
     * Return the staff's full name
     */
    public String getName()
    {
        return name;
   }

    /**
     * Return the staff ID of member of staff.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Print the details of this member of staff to the output terminal.
     */
    public void print()
    {
        System.out.println("ID: " + id + "   Name: " + name 
                         + " Office: " + office);
    }
}
