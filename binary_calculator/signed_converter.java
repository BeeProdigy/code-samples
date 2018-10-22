
/**
 * 
 * Kristal VanEtten
 * COSC 221 Winter 2018
 * Decimal/Binary Converter
 * 
 * A program that converts signed decimals to binary and vice versa.
 */
import java.io.*;
import java.util.Scanner;
public class signed_converter
{
    public static void main (String args [])
    {
        //import scanner class and declare/initiliaze variables
        Scanner stdIn = new Scanner (System.in);
        int response;
        
        //display menu for use
        System.out.println("Enter 1 to convert a decimal to a binary equivalent");
        System.out.println("Enter 2 to convert a binary to a decimal equivalent");
        System.out.println("Enter any other digit to quit the program.");
        System.out.print("Please enter your choice: ");
        response = stdIn.nextInt();
        
        //make conversion based on user's input
        while (response == 1 || response == 2)
        {
            switch (response)
            {
                case 1: //for decimal to binary
                    System.out.println();
                    System.out.print("Please enter a decimal between -127 and 127: ");
                    int deci = stdIn.nextInt();
                    System.out.println("The binary equivalent is: " + deciToBin(deci)); //display binary equivalent
                    System.out.println();
                    break;
                
                case 2: //for binary to decimal
                    System.out.println();
                    System.out.print("Please enter an 8-bit binary number: ");
                    String bin = stdIn.next();
                    System.out.println("The decimal equivalent is: " + binToDeci(bin));
                    System.out.println();
                    break;

            }
            //show the menu to the user again after making conversion
            System.out.println("Enter 1 to convert an decimal to a binary equivalent");
            System.out.println("Enter 2 to convert a binary equivalent to a decimal");
            System.out.println("Enter 3 to quit program");
            System.out.print("Please enter your choice: ");
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
            /** first code attempt
            for (count = 0; count >= 7; count ++)
            {
                arBin [count] = swiBin.charAt (count);
            }
            count = 8;
            do
            {
                if (arBin [count] == '0')
                {
                    arBin [count] = 1;
                    carry = 0;
                }
                else
                {
                    arBin [count] = 0;
                    carry = 1;
                }
                count ++;
            }while (carry == 1 && count < 0);
            
            //putting the switched bits in bin
            String b = new String (arBin);
            for (i = 0; i < 7; i++)
            {
                bin = bin + b;
            }
            //bin = b;*/
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
}//end of class
/**
 * ******** OUTPUT SAMPLE ********
Enter 1 to convert a decimal to a binary equivalent
Enter 2 to convert a binary to a decimal equivalent
Enter any other digit to quit the program.
1

Please enter a decimal between -127 and 127: 1
The binary equivalent is: 00000001

Enter 1 to convert an decimal to a binary equivalent
Enter 2 to convert a binary equivalent to a decimal
Enter 3 to quit program
Please enter your choice: 1

Please enter a decimal between -127 and 127: -16
The binary equivalent is: 11110000

Enter 1 to convert an decimal to a binary equivalent
Enter 2 to convert a binary equivalent to a decimal
Enter 3 to quit program
Please enter your choice: 2

Please enter an 8-bit binary number: 11110000
The decimal equivalent is: -16

Enter 1 to convert an decimal to a binary equivalent
Enter 2 to convert a binary equivalent to a decimal
Enter 3 to quit program
Please enter your choice: 1

Please enter a decimal between -127 and 127: -18
The binary equivalent is: 11101110

Enter 1 to convert an decimal to a binary equivalent
Enter 2 to convert a binary equivalent to a decimal
Enter 3 to quit program
Please enter your choice: 2

Please enter an 8-bit binary number: 11101110
The decimal equivalent is: -18

Enter 1 to convert an decimal to a binary equivalent
Enter 2 to convert a binary equivalent to a decimal
Enter 3 to quit program
Please enter your choice: 3

System is terminating!
 */
