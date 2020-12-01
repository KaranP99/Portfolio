/**
 *  A class that maintains information about an instrument.
 * 
 * @description  Yang He 
 * @version August 2018
 */
public class Instrument
{
    private String id;           // Unique ID 
    private String type;         // instrument type
    private String description;  // instrument details, e.g. maker, size etc.    
    private boolean onloan;      // A flag indicating the status of the instrument

    private static int nextID = 1;  // A static variable for generating a unique ID
    
    /**
     * Create a new instrument with the given type and description
     * 
     * @param type  Instrument's type
     * @param description Instrument's description
     */
    public Instrument(String type, String description)
    {
        id = "Instrument#" + nextID;
        this.type = type;
        this.description = description;
        onloan = false;
        nextID++;
    }

    /**
     * Get the instrument ID.
     * 
     * @return The instrument ID.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Get the instrument type.
     * 
     * @return The type of the instrument.
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * Get the instrument description.
     * 
     * @return The description of the instrument.
     */
    public String getDescription()
    {
        return description;
    }
        
    /**
     * Check if the instrument is on loan
     * 
     * @return true if the instrument is on load, false otherwise
     */
    public boolean isOnLoan()
    {
        return onloan;
    }
    
    /**
     * Mark the instrument as on loan.
     */
    public void rented()
    {
        onloan = true;
    }
    
    /**
     * Mark the instrument as returned.
     */
    public void returned()
    {
        onloan = false;
    }
     
    /**
     * Print the details of the instrument
     */
    public void print()
    {
        String details = id  + ": " +  type + " (" + description;
        if (isOnLoan()) {
            details += ". It is on loan)";
        }
        else {    
            details += ". It is available)";
        }
        System.out.println(details);
    } 

}
