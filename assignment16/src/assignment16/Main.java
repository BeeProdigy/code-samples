package assignment16;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main (String [] args) {
		int i = 0;
		try {
			int num [] = readfile("input.txt");
		    int size = readfile("input.txt").length;
            System.out.println(size);
            for (i = 1; i < num.length; i++){
            	if (num [i] == -1){
            		System.out.println(i);
            	}
            }
            double factorials [];
    		factorials = new double [i];
    		for (int j = 0; j < num.length; j++){
    			try {
                	if (num [j] < 1){
                		throw new TooSmallNumberException((int) num [j]);
                	} else if (num [j] >= 100){
                		throw new TooBigNumberException((int) num [j]);
                	} else {
                		factorials [j] = (double) factorial(num [j]);
                	}
                } catch (TooSmallNumberException e){
                	factorials [j] = -1;
                	System.out.println(e.getMessage());
                } catch (TooBigNumberException e){
                	System.out.println(e.getMessage());
                	for (int k = 0; k < j; k++){
                		System.out.println(factorials [k]);
                	}
                	System.exit(1);
                }
    		}
			} catch (IOException e){
				System.exit(1);
				}
            /** try {
            	double numb = 100;
            	if (numb < 1){
            		throw new TooSmallNumberException((int) numb);
            	} else if (numb >= 100){
            		throw new TooBigNumberException((int) numb);
            	} else {
            		double facCheck = factorial(numb);
                	System.out.println(facCheck);
            	}
            } catch (TooSmallNumberException e){
            	System.out.println(e.getMessage());
            } catch (TooBigNumberException e){
            	System.out.println(e.getMessage());
            }
			} catch (IOException e){
				System.exit(1);
				} */
		}
	public static int [] readfile(String filename) throws IOException{
        int x = 0;
        int lineNum [];
        try{
        	
            FileReader reader = new FileReader(filename);
            BufferedReader inputStream = new BufferedReader(reader);
            
            String line = inputStream.readLine();
            while (line != null){
                line = inputStream.readLine();
                x++;
            }
            inputStream.close();
            //System.out.print(x);
            
        }catch (IOException e){
        	// System.out.println(e.getMessage());
            System.out.println(filename + " (No such file or directory)");
        }
        lineNum = new int [x];
        
        FileReader reader2 = new FileReader(filename);
        BufferedReader inputStream2 = new BufferedReader(reader2);
            
        for (int i = 0; i < lineNum.length; i++){
        	try {
            	lineNum [i] = Integer.parseInt(inputStream2.readLine());
        	} catch (Exception e){
            	lineNum [i] = -1;
            }
        }
            inputStream2.close(); 
        
        return lineNum;
    }
	public static double factorial (double number) throws TooSmallNumberException, TooBigNumberException{
		// double factorial = number * (number - 1) * (number - 2) * .... * 1
		double fac = 1;
		double i = 1;
		if (number == 0){
			return 1;
		} else {
			fac = (number*factorial(number-1));
		}
		return fac;
	}
}
