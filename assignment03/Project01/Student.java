
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Student extends Person
{
    private int studID;
    private String course;
    private String tName; //teacher name
    
    public Student ()
    {
        super ( );
        studID = 0;
        course = "No course";
        tName = "No name";
    }
    public Student (String initialfName, String initiallName, int initialstudID, String initialcourse, String intialtName)
    {
        super (initialfName, initiallName);
        studID = initialstudID;
        course = initialcourse;
        tName = intialtName;
    }
    public void reset (String newfName, String newlName, int newstudID, String newcourse, String newtName)
    {
        setName (newfName, newlName);
        studID = newstudID;
        course = newcourse;
        tName = newtName;
    }
    public int getstudID ()
    {
        return studID;
    }
    public String getcourse ()
    {
        return course;
    }
    public String gettName ()
    {
        return tName;
    }
    public void setInfo (int newstudID, String newcourse, String newtName)
    {
        studID = newstudID;
        course = newcourse;
        tName = newtName;
    }
    public void displayStudDetails ()
    {
        System.out.println(getfName() + " " + getlName () + " " + studID);
        System.out.println(course + " " + tName);
        System.out.println();
    }
}
