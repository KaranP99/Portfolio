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
    public void testAll()
    {
        Staff staff1 = new Staff("Staff1", "Clarkson", "M3-1");
        Staff staff2 = new Staff("Staff2", "Smith", "M3-2"); 
        Staff staff3 = new Staff("Staff3", "West", "M3-3");
        
        Course c1 = new Course("CO320", "OOP", staff1);
        Course c2 = new Course("CO520", "Further OOP", staff2);
        
        UG ug1 = new UG("ug01", "Alan", true);
        UG ug2 = new UG("ug02", "Caitlin", false);
        UG ug3 = new UG("ug03", "David", true);
        UG ug4 = new UG("ug04", "Helen", false);
        
        PG pg1 = new PG("pg01", "Brian", true);       
        PG pg2 = new PG("pg02", "Jane", false);
        PG pg3 = new PG("pg03", "Oscar", true);
        pg1.assignSupervisor(staff1);
        pg2.assignSupervisor(staff1);
        pg3.assignSupervisor(staff3);        
      
        Database db = new Database();
        db.addStaff(staff1);        
        db.addStaff(staff2);
        db.addStaff(staff3);
        db.printAllStaff();
        
        db.addCourse(c1);        
        db.addCourse(c2);
        db.printAllCourses();
        
        db.addStudent(ug1);        
        db.addStudent(ug2);                
        db.addStudent(ug3);        
        db.addStudent(ug4);        
        db.addStudent(pg1);        
        db.addStudent(pg2);    
        db.addStudent(pg3);
        db.printAllStudents();

        db.registration(ug1, c1);
        db.registration(ug1, c2);
        db.registration(ug2, c1);
        db.registration(ug2, c2);
        db.registration(ug3, c1);        
        db.printAllRegistration();
    }
}

