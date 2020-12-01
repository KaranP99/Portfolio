/**
 * The Student class represents a student at a university.
 * It holds relevant details of a student.
 * 
 * @Karan Patel, KP482
 * @05/11/2018
 */
public class Student
{
    // The student ID
    private String sid;
    
    // The student's name
    private String name;

    // The student's gender
    private boolean isMale;

    // A list of course IDs taken by the student, e.g. CO320 CO322
    private String courses;
    
    /**
     * Create a new student with a given ID, name and gender. 
     * 
     * @param  sid     A student ID
     * @param  name    A student name
     * @param  isMale  A student is male or not
     */
    public Student(String sid, String name,  boolean isMale)
    {       
       this.sid = sid;
       this.name = name;
       this.isMale = isMale;
       
       courses = courses;
    }

    /**
     * Get the student ID of this student
     * 
     * @return the student ID of this student.
     */
    public String getSID() // Getter method in the type String 
    {
        return sid;// Returning the student ID
    }
    
    /**
     * Get  the name of this student.
     * 
     * @return  the name of this student.
     */
    public String getName() // Getter method in the type String
    {
        return name;// Returning the name
    }

    /**
     * Set a new name for this student.
     * 
     * @param name  A new name for this student
     */
    public void setName(String newname) // This method is a mutator and does not return anything
    {
       name = newname;// Assigning the new variable "newname" declared within the brackets to a already existing variable "name"
    }
         
    /**
     * Get the gender of the student, i.e. "Male" or "Female"
     * 
     * @return The String "Male" if the student is male, 
     *         otherwise "Female".
     */
    public String getGender() // The method uses an accessor and a return is needed
    {    
        if (isMale == true){ // This if-statement will check to see if the student is male.
        return ("Male") ;// If the student is male, male will be printed in the terminal. 
    }
        else{// Otherwise the student is female and female will be printed in the terminal. 
        return ("Female");
    }
    }
        
    /**
     * Print the student's details, 
     * i.e. id, name, gender and a list of course IDs, 
     * to the output terminal,
     * e.g.  Student ID: S01   Name: Cathy Lee   Gender: Female   
     *       Courses: CO320 CO322
     */
    public void print() // This method does not need a return hence void was used
    {// This part of the code will print the students details. It prints the students ID, their name, gender and their courses
        System.out.println("Student ID: "+ sid);
        System.out.println("Name: "+ name); 
        System.out.println("Courses: " + courses); 
    }
    
    
    /**
     * This is a new method class to register the students on a given course.
     * The code will first check to see if the course is full 
     */
    public void courseRegistration(Course newStudentReg)// The method is void as theres no need for a return and the input is called studentReg of type Course
    {   // This part of the code first check to see if there are spaces in the course
        //if there is no spaces left there will be a message printed reading - Course Full
        if (newStudentReg.getStudentNos() >= 80){
            System.out.println("Course Full");
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
        else{
            // If there is a space on the course there will be a message printed reading - Student Registered
            System.out.println("Student Registered");
            // The line below will print multiple dashes to seperate out the lines in the terminal
            System.out.println("--------------------------------------------------------------------------------------------------------");
            // The line below will add the student to the total number of students using a mutator 
            newStudentReg.setStudentNos(newStudentReg.getStudentNos() + 1);
        }
    }
}
