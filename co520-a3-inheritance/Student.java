
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - replace the example below with your own
    // the student ID
    private String sid;
    
    // the student's full name
    private String name;

    // the student's gender
    private boolean isMale;

    
    
    public Student(String sid, String name, boolean isMale)
    {
        
        this.sid = sid;
        this.name = name;        
        this.isMale= isMale;
        
    }
    
    /**
     * Return the student ID of this student.
     */
    public String getSID()
    {
        return sid;
    }
    
    /**
     * Return the name of this student.
     */
    public String getName()
    {
        return name;
    }
        
    /**
     * Return the String "Male" if the student is male, otherwise "Female".
     */
    public String getGender()
    {
        if (isMale) { 
            return "Male";
        } else {
            return "Female";
        }   
    }    
    
    public void print()
    {
      System.out.println("ID: " + sid + "   Name: " + name + "   Gender: " + getGender());
    }
}
