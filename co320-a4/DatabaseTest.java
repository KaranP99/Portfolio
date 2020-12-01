import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DatabaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DatabaseTest
{    
    Database myDatabase;
    Instrument b1, b2, b3, b4, b5, b6, b7;
    Customer c1,c2,c3, c4;
        
    /**
     * Default constructor for test class DatabaseTest
     */
    public DatabaseTest()
    {
       
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {       
        myDatabase = new Database();
        
        c1 = new Customer("C001", "Carl Jones");
        c2 = new Customer("C002", "Jenny Brown");
        c3 = new Customer("C003", "Alan West");
        c4 = new Customer("Test", "Not a Customer");
        
        b1 = new Instrument("piano", "Steinway");
        b2 = new Instrument("violin", "Stradivari");
        b3 = new Instrument("piano", "Yamaha");
        b4 = new Instrument("cello", "Stradivari");
    }
    
    @Test
    public void addNewCustomerTest()
    {
        System.out.println("#####################");
        System.out.println("### Test addNewCustomer  ###");
        System.out.println("#####################");
        System.out.println("Positive testing:");
        System.out.println("(1) Add the 1st customer " + c1.getCID());
        myDatabase.newCustomer(c1);
        System.out.println("(2) Add the 2nd customer " + c2.getCID());
        myDatabase.newCustomer(c2);
        
        System.out.println("------------------------------------------------");
        System.out.println("Negative testing:");
        System.out.println("(1) Add the 1st Customer again");
        myDatabase.newCustomer(c1);
        System.out.println("(2) Add a null");
        myDatabase.newCustomer(null);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddInstrument()
    {      
        System.out.println("#####################");
        System.out.println("### Test addInstrument  ###");
        System.out.println("#####################");
        System.out.println("Positive testing:");
        System.out.println("(1) Add the 1st instrument " + b1.getID());
        myDatabase.addInstrument(b1);
        System.out.println("(2) Add the 2nd instrument " + b2.getID());
        myDatabase.addInstrument(b2);
        System.out.println("(3) Add the 3rd instrument with the same type as the 1st one");
        myDatabase.addInstrument(b3);
        
        System.out.println("------------------------------------------------");
        System.out.println("Negative testing:");
        System.out.println("(1) Add the 1st instrument again");
        myDatabase.addInstrument(b1);
        System.out.println("(2) Add a null");
        myDatabase.addInstrument(null);
               
        System.out.println("------------------------------------------------");
        System.out.println("List of instruments in the database:");
        myDatabase.printInstrumentDetails();
        
    }
    
    
    
}

