
/**
 * Write a description of class Teacher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teacher extends Person
{
    private String subjName;
    private int salary;
    
    public Teacher ()
    {
        super ( );
        subjName = "No subject";
        salary = 0;
    }
    public Teacher (String initialfName, String initiallName, String initialsubjName, int initialsalary)
    {
        super (initialfName, initiallName);
        subjName = initialsubjName;
        salary = initialsalary;
    }
    public void reset (String newfName, String newlName, String newsubjName, int newsalary)
    {
        setName (newfName, newlName);
        subjName = newsubjName;
        salary = newsalary;
    }
    public String getsubjName ()
    {
        return subjName;
    }
    public int getsalary ()
    {
        return salary;
    }
    public void setInfo(String newsubjName, int newsalary)
    {
        subjName = newsubjName;
        salary = newsalary;
    }
    public void displayteachDetails ()
    {
        System.out.println(getfName () + " " + getlName ());
        System.out.println(subjName + " " + "$" + salary);
        System.out.println();
    }
}
