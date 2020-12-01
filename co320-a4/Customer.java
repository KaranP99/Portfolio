import java.util.ArrayList;

/**
 * The Customer class represents a customer in a local library.
 * It holds relevant details of a customer.
 * 
 * @author Yang He
 * @version  Oct 2018
 */
public class Customer
{
    private String id;              // Customer's ID
    private String name;            // Customer's name 
    private ArrayList<Instrument> instruments;  // instruments rented by the customer
    
    /**
     * Create a new customer with a given ID and name.  
     * 
     * @param id   Customer's ID
     * @param name Customer's name 
     */
    public Customer(String id, String name)
    {
        this.id = id;
        this.name = name;
        instruments = new ArrayList<>();
    }

    /**
     * Get the customer's ID.
     * 
     * @return The ID of the customer.
     */
    public String getCID()
    {
        return id;
    }
    
    /**
     * Get the customer's name.
     * 
     * @return The name of the customer.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the list of instruments rented by the customer.
     * 
     * @return The list of instruments rented by the customer.
     */
    public ArrayList<Instrument> getInstruments()
    {
        return instruments;
    }
    
    /**
     * Rents an instrument.
     * 
     * @param A given instrument.
     */
    public void rentInstrument(Instrument a)
    {
        a.rented();
        instruments.add(a);        
    }
    
    /**
     * Returns an instrument.
     * 
     * @param A given instrument.
     */
    public void returnInstrument(Instrument a)
    {   
        
        a.returned();
        instruments.remove(a);
    }
    
    /**
     * Returns the number of instruments rented by the customer
     * 
     * @return The number of instruments rented by the customer
     */
    public int numberOfInstruments()
    {   
        return instruments.size();
    }
    
    /**
     * Check if the customer has rented an instrument of the given type
     * 
     * @param The instrument type
     * @return The instrument matching the given type rented by the customer 
     */
    public Instrument getInstrumentRented(String type)
    {   
        Instrument foundOne = null;
        int index = 0;
        while (index < instruments.size() && foundOne == null) {
            Instrument a = instruments.get(index);
            if (a.getType().equals(type)) {
                foundOne =  a;
            }
            index++;
        }
        return foundOne;
    }
    
    /**
     * Print the details of the customer: 
     * ID, name and the number of instruments rented           
     */
    public void print()
    {
        String info = "ID: " + id + "  Name: " + name + " (rented ";
        if (numberOfInstruments() == 0) {
            info = info + "none.)";
        }
        else {
            info = info + numberOfInstruments() + " instruments)";
        }
        System.out.println(info);
    }    
}
