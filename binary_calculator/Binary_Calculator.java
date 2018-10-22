
/**
 * 
 * Kristal VanEtten
 * COSC 221 Winter 2018
 * Binary Calculator
 * 
 * A program that subtracts and adds binary numbers, giving the output/answer in binary and decimal form.
 */
import java.io.*;
import java.util.Scanner;
public class Binary_Calculator
{
    public static void main (String args [])
    {
        //import scanner class and declare/initiliaze variables
        Scanner stdIn = new Scanner (System.in);
        int response;
        
        //display menu for use
        System.out.println("Enter 1 to add two binary numbers");
        System.out.println("Enter 2 to subtract two binary numbers");
        System.out.println("Enter any other digit to quit the program.");
        System.out.print("Make your decision: ");
        response = stdIn.nextInt();
        
        //make conversion based on user's input
        while (response == 1 || response == 2)
        {
            switch (response)
            {
                case 1: //for decimal to binary
                    System.out.println();
                    System.out.print("Please enter two binary numbers: ");
                    String x = stdIn.next();
                    String y = stdIn.next();
                    String addTotal = addBin (x,y);
                    System.out.println("      " + x + "(" + binToDeci(x) + ")");
                    System.out.println("      " + "+" + y + "(" + binToDeci(y) + ")");
                    System.out.println("-----------------");
                    System.out.println("       " + addTotal + "(" + binToDeci(addTotal) + ")");
                    System.out.println();
                    break;
                
                case 2: //for binary to decimal
                    System.out.println();
                    System.out.print("Please enter two binary numbers: ");
                    x = stdIn.next();
                    y = stdIn.next();
                    String subTotal = subBin (x,y);
                    System.out.println("      " + x + "(" + binToDeci(x) + ")");
                    System.out.println("      " + "-" + y + "(" + binToDeci(y) + ")");
                    System.out.println("-----------------");
                    System.out.println("     " + subTotal + "(" + binToDeci(subTotal) + ")");
                    System.out.println();
                    break;

            }
            //show the menu to the user again after making conversion
            System.out.println("Enter 1 to add two binary numbers");
            System.out.println("Enter 2 to subtract two binary numbers");
            System.out.println("Enter any other digit to quit the program.");
            System.out.print("Make your decision: ");
            response = stdIn.nextInt();

        }
        
        //announce to the user that the system is ending
        System.out.println();
        System.out.println("System is terminating!");

    }
    /**
     * Method for converting a decimal number to its binary equivalent
     * @param x - decimal input by user
     * @return bin - binary equivalent to decimal number
     */
    public static String deciToBin (int x)
    {
        //declare and initialize variables
        char [] arBin = new char [9];
        int carry = 0;
        int count;
        int i;
        String rbin = "";
        int length = rbin.length ();
        int rem;
        String bin = "";
        String swiBin = "";
        
        if (x > 0)
        {
            //converting to binary
            for (i = 0; i < 8; i++)
            {
                rem = x%2;
                x = x/2;
                bin = rem + bin;
            }
        }
        else
        {
            //making the number positive
            x = Math.abs(x);
            
            //converting to binary
            for (i = 0; i < 8; i++)
            {
                rem = x%2;
                x = x/2;
                rbin = rem + rbin;
            }
            
            //flipping the bits
            for (i = 0; i <= 7; i++)
            {
                if (rbin.charAt (i) == '1')
                {
                    swiBin = swiBin + 0;
                }
                else
                {
                    swiBin = swiBin + 1;
                }
            }
            
            //adding one to binary
            int num = 0;
            for (i = 7; i >= 0; i--)
            {
                if (swiBin.charAt(i) == '1')
                    num = num + (int) Math.pow (2, 7-i);
            }
            num = num + 1;
            
            for (i = 0; i < 8; i++)
            {
                rem = num%2;
                num = num/2;
                bin = rem + bin;
            }
        }
        return bin;
    }
    /**
     * Method for converting a binary number to it's decimal equivalent
     * @param x - binary input by user
     * @return - num = decimal equivalent to binary number
     */
    public static int binToDeci(String x)
    {
        //declare and initilaize variables
        int num = 0;
        char [] arBin = new char [9];
        int carry = 0;
        int count;
        int i;
        String rbin = "";
        int length = rbin.length ();
        int rem;
        String bin = "";
        String swiBin = "";
        if (x.charAt (0) == '0')
        {
            for (i = 7; i >= 0; i--)
            {
                if (x.charAt(i) == '1')
                    num = num + (int) Math.pow (2, 7-i);
            }
        }
        else
        {
            //flipping the bits
            for (i = 0; i <= 7; i++)
            {
                if (x.charAt (i) == '1')
                {
                    swiBin = swiBin + 0;
                }
                else
                {
                    swiBin = swiBin + 1;
                }
            }
            
            //convert to deci
            for (i = 7; i >= 0; i--)
            {
                if (swiBin.charAt(i) == '1')
                    num = num + (int) Math.pow (2, 7-i);
            }
            //make negative
            num = num + 1;
            num = num * -1;
        }
        return num;
    }
    /**
     * Method for adding binary numbers
     * @param x & y - input by user
     * @return addTotal - sum of the two binaries
     */
    public static String addBin (String x, String y)
    {
        //declare variables
        String addTotal = "";
        
        int carry = 0;
        for (int i = 7; i >= 0; i--)
        {
            if (carry == 0)
            {
                if (x.charAt (i) == '1' && y.charAt (i) == '1')
                {
                    addTotal += 0;
                    carry = 1;
                }
                else if (x.charAt (i) == '1' && y.charAt (i) == '0')
                {
                    addTotal += 1;
                    carry = 0;
                }
                else if (x.charAt (i) == '0' && y.charAt (i) == '1')
                {
                    addTotal += 1;
                    carry = 0;
                }
                else if (x.charAt (i) == '0' && y.charAt (i) == '0')
                {
                    addTotal += 0;
                    carry = 0;
                }
            }
            else if (carry == 1)
            {
                if (x.charAt (i) == '1' && y.charAt (i) == '1')
                {
                    addTotal += 1;
                    carry = 1;
                }
                else if (x.charAt (i) == '1' && y.charAt (i) == '0')
                {
                    addTotal += 0;
                    carry = 1;
                }
                else if (x.charAt (i) == '0' && y.charAt (i) == '0')
                {
                    addTotal += 1;
                    carry = 0;
                }
                else if (x.charAt (i) == '0' && y.charAt (i) == '1')
                {
                    addTotal += 0;
                    carry = 1;
                }
            }
        }
        
        //reverse string because the if loop tacked on the bits backwards
        String reverse = "";
        for (int i = addTotal. length() - 1; i >= 0; i--)
        {
            reverse = reverse + addTotal.charAt (i);
        }
        String total = reverse;
        return total;
    }
    /**
     * Method for subracting binary numbers
     * @para x & y - input by user
     * @return subTotal - subtraction of the two binaries
     */
    public static String subBin (String x, String y)
    {
        //declare variables
        String subTotal = "";
        
        //flipping the second string's bits and adding one to make it a negative number
        String swiBin = "";
        for (int i = 0; i <= 7; i++)
        {
            if (y.charAt (i) == '1')
            {
                swiBin = swiBin + 0;
            }
            else
            {
                swiBin = swiBin + 1;
            }
            }
        //adding one to binary
        int num = 0;
        for (int i = 7; i >= 0; i--)
        {
            if (swiBin.charAt(i) == '1')
            num = num + (int) Math.pow (2, 7-i);
        }
        num = num + 1;    
        String bin = "";
        int rem;
        for (int i = 0; i < 8; i++)
        {
            rem = num%2;
            num = num/2;
            bin = rem + bin;
        }
        subTotal = addBin (x, bin);
        return subTotal;
    }
}//end of class
/**
 * SAMPLE INPUT/OUTPUT
*********************************
Enter 1 to add two binary numbers
Enter 2 to subtract two binary numbers
Enter any other digit to quit the program.
Make your decision: 1

Please enter two binary numbers: 11111111 00000001
      11111111(-1)
      +00000001(1)
-----------------
       00000000(0)

Enter 1 to add two binary numbers
Enter 2 to subtract two binary numbers
Enter any other digit to quit the program.
Make your decision: 2

Please enter two binary numbers: 10000001 00000001
      10000001(-127)
      -00000001(1)
-----------------
     10000000(-128)

Enter 1 to add two binary numbers
Enter 2 to subtract two binary numbers
Enter any other digit to quit the program.
Make your decision: 3

System is terminating!
 */