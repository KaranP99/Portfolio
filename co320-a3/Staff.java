/**
 * The Staff class represents an academic member of staff at university of Kent.
 * It holds relevant details of a member of staff.
 * 
 * @author Yang He
 * @version 2018.09.20
 */
public class Staff
{
    // the stafft ID
    private String sid;

    // the staff's full name
    private String name;

    /**
     * Create a new member of staff with a given ID and name.
     * 
     * @param  sid    A staff id
     * @param  name   A staff name
     */
    public Staff(String sid, String name)
    {
        this.sid = sid;
        this.name = name;        
    }

    /**
     * Get the full name of the staff member.
     * 
     * @return the full name of the staff member
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this member of staff.
     * 
     * @param name  A staff name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the staff ID
     * 
     * @return  The staff ID.
     */
    public String getSID()
    {
        return sid;
    }
}
