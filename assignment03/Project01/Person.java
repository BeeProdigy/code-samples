
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String fName; //the first name
    private String lName; //the last name
    
    Person ( )
    {   
        fName = "No name yet";
        lName = "No name yet";
    }
    public Person (String initialfName, String initiallName)
    {
        fName = initialfName;
        lName = initiallName;
    }
    public void setName (String newfName, String newlName)
    {
        fName = newfName;
        lName = newlName;
    }
    public String getfName ()
    {
        return fName;
    }
    public String getlName ()
    {
        return lName;
    }
    public void displayDetails()
    {
        System.out.print(fName + " " + lName);
    }
}
