/**
 * Write a description of class Test here.
 *
 * @author (Karan Patel)
 * @version (05/11/2018)
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        // initialise instance variables
        Staff john = new Staff("John1", "John ");
        Course co320 = new Course("co320 ", "Geography ", john);
        Student jason = new Student("Jason1 ", "Jason ", true);
        jason.courseRegistration(co320);
        
        jason.print();
        co320.print();
    }
    
}
