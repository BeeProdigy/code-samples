
/**
 * Here's a method to do the boring grunt work.
 * 
 * @author (Kristal VanEtten) 
 * @version (October 25, 2017)
 */
import java.util.Scanner;
public class compute_cost
{
    /**
     * @param: y - miles, x - mpg
     * @return: number of gallons used
     */
    public static double getGallons (double x, double y)
    {
        return (y/x);
    }
    /**
     * @param: x - MPG, y - miles, z - costs
     * @return: costs it takes to make the trip one way
     */
    public static double getOneway (double x, double y, double z)
    {
        return (y/x) * z;
    }
    /**
     * @param: x - MPG, y - miles, z - costs
     * @return: costs it takes to make it roundtrip
     */
    public static double getRoundtrip (double x, double y, double z)
    {
        return ((y/x) * z) * 2;
    }
}
