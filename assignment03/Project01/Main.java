
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main (String [] args)
    {
        Student s = new Student ();
        s.setName("Luain", "Farrow");
        s.setInfo(72094, "Mathematics", "Mr. Liasalor");
        
        s.displayStudDetails ();
        
        Student a = new Student ();
        a.setName("Sebastian", "Lawton");
        a.setInfo(81934, "Music", "Mr. Arkwright");
        
        a.displayStudDetails();
        
        Teacher t = new Teacher ();
        t.setName("Levina", "Samborne");
        t.setInfo("Music Therapy", 60000);
        
        t.displayteachDetails();
        
        Teacher b = new Teacher ();
        b.setName("Avenir", "Bellegarde");
        b.setInfo("Physics", 55000);
        
        b.displayteachDetails();
        
    }
}
