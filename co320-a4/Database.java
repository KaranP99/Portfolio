import java.util.ArrayList;

/**
 * Write a description of class Database here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Database
{
    private ArrayList<Customer> customers;      // A list of customers
    private ArrayList<Instrument> instruments;  // A list of instruments
    
    // The maximum number of instruments a customer is allowed to rent
    public final int MAX_NUM_INSTRUMENTS = 3;  
    
    /**
     * Constructor for objects of class Database
     */
    public Database()
    {
        customers = new ArrayList<>();
        instruments = new ArrayList<>();
    }
   
    //////////////////////////////////////////////////////////////////////////////////////////
    // Start of your code 
    
    public void print()
    {
        for(Customer c : customers){// specifing the type and ArrayList 
            c.print();// printing the elements of the customer ArrayList
        }
    }
    
    public int NumberOfInstruments(String typeofinstrument)
    {   int count = 0;//starts an index from 0
        for(Instrument I : instruments){// specifing the type and ArrayList 
            if(I.getType().equals(typeofinstrument)){//using an "if" statement to get the instrument type and to see if it is equal to the inputted type of instrument
            ++count;}// adds 1 to the index if the instrument type is the same as the inputted type
        }
        return count;// returns the total number of the count
    }
    
    public void newCustomer(Customer AddNewCustomer)
    { 
        if (AddNewCustomer == null) {// checking to see if the entered new customer is null
            System.out.println("It is null.");// prints a message if the inputted customer is null
        }
        else
        {
        if(!isCustomer(AddNewCustomer)&&(uniqueCID(AddNewCustomer.getCID()) )){// checks to see if the inputted customer is already in the database and checks if they have a unique ID
            customers.add(AddNewCustomer);// if the above statement is true it will add the inputted customer to the customer database/ArrayList
            System.out.println("Customer Added");//prints a message when the customer is added
            }  
        else{
            System.out.println("This person is not a customer or does not have a unique ID");//printing an error message as the 2nd "if" statement has failed
        }
        }
    } 
    
    public Instrument typeOfInstrument(String typeOfInstrument)
    {
        for (Instrument typeofinst: instruments) {// specifing the type and ArrayList
            if (typeofinst.getType().equals(typeOfInstrument)&& typeofinst.isOnLoan() ==false)//checking to see if the inputted instrument type is already in the database and to see if it is on loan
            return typeofinst;// returns the type of instrument 
        }
        System.out.println("The Instrument is not avaliable or is on loan");// prints message if the instrument is not available
        return null; // returns null as the instrument is unavailable
    }

    public void printCustomerLoan(String customerLoan)
    {
        for(Customer c : customers){// specifing the type and ArrayList
            if(c.equals(customerLoan)){// checking if the customer entered is in the database
                c.print();//prints the customer details
                c.getInstruments();// prints the instrument details
            }
        }
    }
        
    public void rentAnInstrument(Customer chosenCustomer, String typeOfInstrument)
    {
        for (Instrument I: instruments) {// specifing the type and ArrayList
        if((isCustomer(chosenCustomer)!=true) && (I.getType()==typeOfInstrument) && (I.isOnLoan() != true)){// checking to see if the customer entered is actually a customer, checks the type of the instrument and checks if its on loan or not
            chosenCustomer.rentInstrument(I);// rents the instrument to the customer 
            System.out.println("Customer "+ chosenCustomer.getName()+" with ID: " + chosenCustomer.getCID()+ "" + "has successfully rented the following Instruments: "+ typeOfInstrument);// prints the details of the customer and the instrument they rented 
        } else {
            System.out.println("Instrument not avaliable to rent");//prints a message to show the instrument is not available 
        }
    }
    }
    // End of your code 
    //////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Add a new instrument into the the database
     * 
     * @param newInstrument A given instrument to be added into the database
     */
    public void addInstrument(Instrument newInstrument) 
    {
        // Check if newInstrument is null
        if (newInstrument == null) {
            System.out.println("It is null."); 
        }
        else {        
            // Check if newInstrument is already in the database
            if (instruments.contains(newInstrument)) {
                System.out.println(newInstrument.getID() + " is already in the database."); 
            }
            else {
                instruments.add(newInstrument);        
            }
        }
    }
              
    /**    
     * Print the details of all instruments 
     */
    public void printInstrumentDetails() 
    {
        for (Instrument b: instruments) {
            b.print();
        }      
    }   
    
    /**
     * A customer returns an instrument
     * 
     * @param aCustomer   An object of Customer
     * @param ID          The ID of a instrument
     * 
     */
    public void returnInstrument(Customer aCustomer, String ID) 
    {
        // Check if the given aCustomer is a registered customer of the database 
        if (!isCustomer(aCustomer)) {
            System.out.println("This person is not a customer.");
        }
        else {                
            Instrument instrumentRented = aCustomer.getInstrumentRented(ID);
            
            // Check if the given customer has actually rented the instrument 
            if (instrumentRented == null) {
                System.out.println(aCustomer.getCID() + " has not rented the instrument: " + ID);
            }
            else {
                aCustomer.returnInstrument(instrumentRented); 
                System.out.println(aCustomer.getCID() + " has now returned the instrument: " + ID);
            }
        }
    }
    
    /**
     * Check if a given customer is a registered customer in the database
     * 
     * @param aCustomer A given customer
     * @return true if aCustomer is in the list customers, otherwise false
     */
    public boolean isCustomer(Customer aCustomer) 
    {
        return customers.contains(aCustomer);
    }
    
    /**
     * Check if the given customer ID is unique
     * 
     * @param mid A given customer ID
     * @return true if the given mid is not assigned to any customers in the database
     * otherwise false
     */
    public boolean uniqueCID(String cid) 
    {
        boolean isUnique = true;
        int index = 0;
        while (index < customers.size() && isUnique) {
            Customer c = customers.get(index);
            if (c.getCID().equals(cid)) {                
                isUnique = false;
            }
            index++;
        }
        return isUnique;
    }  
}
