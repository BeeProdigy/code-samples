
/**
 * Ask the user for information regarding their trip and will calculate how much
 * it will cost for either a round trip or a one way trip.
 * 
 * @author (Kristal VanEtten) 
 * @version (October 25, 2017)
 */
import java.util.Formatter;
import java.util.Scanner;
public class main
{
    public static void main (String [] args)
    {
        //Introduction
        external_methods useExternal = new external_methods(); //Bring in the external class
        useExternal.display_dashes(60);
        System.out.println("             VanEtten's Trip Calculator");
        System.out.println();
        System.out.println("Enter information about your destination and two cars.");
        System.out.println("This program will compute the cost of the trip for");
        System.out.println("one way and round trip.");
        useExternal.display_dashes(60);
        
        Scanner stdIn = new Scanner (System.in);
        String destination;
        System.out.print("Enter destination: ");
        destination = stdIn.nextLine();
        
        //Ask for the information
        //declare values and bring in external methods
        double miles, mpg1, mpg2;
        double oneway1, oneway2, roundtrip1, roundtrip2, cost;
        String model1, model2;
        compute_cost useCompute = new compute_cost();
        
        //read in values from user
        miles = useExternal.getPosInt("Enter miles to destination: ");
        cost = useExternal.getPosInt("Enter the cost per gallon: ");
        System.out.println();
        System.out.print("Enter first Vehicle model name: ");
        model1 = stdIn.next();
        mpg1 = useExternal.getPosInt("Enter MPG for this car: ");
        System.out.println();
        System.out.print("Enter second Vehicle model name: ");
        model2 = stdIn.next();
        mpg2 = useExternal.getPosInt("Enter MPG for this car: ");
        
        //compute how many gallons the car used
        double gallons1 = useCompute.getGallons(mpg1, miles);
        double gallons2 = useCompute.getGallons(mpg2, miles);

        //find how much it would cost to go to the destination one-way
        oneway1 = useCompute.getOneway(mpg1, miles, cost);
        oneway2 = useCompute.getOneway(mpg2, miles, cost);
        
        //find how much it will cost to go the destination round-trip
        roundtrip1 = useCompute.getRoundtrip(mpg1, miles, cost);
        roundtrip2 = useCompute.getRoundtrip(mpg2, miles, cost);
        
        
        //Print out the results
        useExternal.display_dashes(65);
        System.out.println("             Trip Calculator to : " + destination);
        System.out.println("                           Miles: " + miles);
        System.out.println("                 Cost Per Gallon: " + cost);
        System.out.println("      Model Car      MPG    Gallons Used     One-Way  Round-Trip");
        useExternal.display_dashes(65);
        System.out.println();
        System.out.printf("%14s %9.2f %12.2f %13.2f %12.2f\n", model1, mpg1, gallons1, oneway1, roundtrip1); 
        System.out.printf("%14s %9.2f %12.2f %13.2f %12.2f\n", model2, mpg2, gallons2, oneway2, roundtrip2); 
        System.out.println();
        useExternal.display_dashes(65);
    }

}//end of class
/**
 * 
============================================================
             VanEtten's Trip Calculator

Enter information about your destination and two cars.
This program will compute the cost of the trip for
one way and round trip.
============================================================
Enter destination: Walt Disney World
Enter miles to destination: -100
Your real number must be positive (above zero). -1000
Your real number must be positive (above zero). 1200
Enter the cost per gallon: 2.39

Enter first Vehicle model name: Explorer
Enter MPG for this car: 20

Enter second Vehicle model name: Subaru Outback
Enter MPG for this car: 30
=================================================================
             Trip Calculator to : Walt Disney World
                           Miles: 1200.0
                 Cost Per Gallon: 2.39
      Model Car      MPG    Gallons Used     One-Way  Round-Trip
=================================================================

      Explorer     20.00        60.00        143.40       286.80
        Subaru     30.00        40.00         95.60       191.20

=================================================================


============================================================
             VanEtten's Trip Calculator

Enter information about your destination and two cars.
This program will compute the cost of the trip for
one way and round trip.
============================================================
Enter destination: Chicago
Enter miles to destination: 199
Enter the cost per gallon: 2.43

Enter first Vehicle model name: Mazda
Enter MPG for this car: 26

Enter second Vehicle model name: Cherokee
Enter MPG for this car: 23
=================================================================
             Trip Calculator to : Chicago
                           Miles: 199.0
                 Cost Per Gallon: 2.43
      Model Car      MPG    Gallons Used     One-Way  Round-Trip
=================================================================

         Mazda     26.00         7.65         18.60        37.20
      Cherokee     23.00         8.65         21.02        42.05

=================================================================
 * 
 */
