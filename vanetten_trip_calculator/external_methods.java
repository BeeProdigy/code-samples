
/**
 * Methods useful for all classes
 * 
 * @author (Kristal VanEtten) 
 * @version (October 25, 2017)
 */
import java.util.Scanner;
public class external_methods
{
    /**
     * getPosInt will keep the user from entering a negative integer.
     * @param: value < 0
     * @return: value
     */
    public static double getPosInt (String str)
    {
        Scanner stdIn = new Scanner (System.in);
        System.out.print(str);
        double value = stdIn.nextDouble();
        while (value < 0)
        {
            System.out.print("Your real number must be positive (above zero). ");
            value = stdIn.nextInt();
        }
        return value;
    }
    /**
     * *********** display_dashes (n) **************
     * This method will display a specified number of dashes.
     * 
     * @param: n - The number of dashes
     * @return: void/nothing to return
     */
    public static void display_dashes (int n)
    {
        for (int i = 0; i < n; i++)
        System.out.print("=");
        
        //Finish off the row of dashes with a carriage return
        System.out.println();
    }//end of the method display_dashes (int n)
}
