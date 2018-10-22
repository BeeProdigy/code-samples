
/**
 * Kristal VanEtten E01194732
 * COSC 221 Winter 2018
 * Lab assignment #1
 * 
 * A program that converts decimals to binary and vice versa.
 */
import java.util.Scanner;
public class Unisigned_converter
{
    public static void main (String args [])
    {
        //import scanner class and declare/intitialize variables
        Scanner stdIn = new Scanner (System.in);
        int response;
        
        //display menu for use
        System.out.println("Enter 1 to convert an unsigned decimal to a binary equivalent");
        System.out.println("Enter 2 to convert a binary equivalent to a decimal");
        System.out.println("Enter any other integer to quit ");
        System.out.println("Please enter your choice: ");
        response = stdIn.nextInt();
        
        //perform action based on 
        
        //display menu for user
        System.out.print("Please enter a decimal between 0 and 225: ");
        int deci = stdIn.nextInt(); //get unsigned decimal from user
        System.out.println("The binary equivalent is: " + deciToBin(deci)); //display binary equivalent
        System.out.println("Original decimal is: " + binToDeci(deciToBin(deci))); //
        //System.out.print("Please enter an 8-bit binary number: ");
        //String bin = stdIn.next();
        //System.out.print("The decimal equivalent is: " + binToDeci(bin));
    }
    /**
     * @param - x = 
     * @return
     */
    public static String deciToBin (int x)
    {
        String bin = "";
        int rem;
        for (int i = 0; i < 8; i++)
        {
            rem = x%2;
            x = x/2;
            bin = rem + bin;
        }
        return bin;
    }
    public static int binToDeci (String x)
    {
        int num = 0;
        for (int i = 7; i >= 0; i--)
        {
            if (x.charAt(i) == '1')
                num = num + (int) Math.pow(2,7-i);
        }
        return num;
    }
}//end class
/**
 * Sample Ouput
 */
