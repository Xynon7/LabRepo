
/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Lab1b
{
    
    // data members

    /** Constructor: calls method readFile that reads the doubles
     * contained in the file "<code>filename</code>" and computes the
     * average of the elements.
     @param filename name of the file containing doubles.
    */
    public Lab1b(String filename)
    {
    	readFile(filename);
    }

    /** Reads double from a file named <code>filename</code> and
     * computes the average of the elements contained in the file
     * Added on 8/31/2017
     * @param filename name of the file containing the doubles
     * @author Chase Clawson
     * @since 1.0
     * @version 1.0
     */
    public void readFile(String filename)
    {
    	try
		{
		    File inputFile = new File(filename);
		    Scanner input = new Scanner(inputFile);
		    int count = 0;
		    double sum = 0;
		    double average = 0;
		    // iterate through the inputs, and add them to the sum
		    while (input.hasNextDouble())
		    {
		    	count++;
		    	sum += input.nextDouble();
		    }
		    
		    // Find the Average, the sum of the elements over the number of elements
		    average = sum / count;
	
			//output results
			System.out.printf("The average value in the input file is " + Double.toString(average));
			input.close();
		} 
		catch (IOException e)
		{
			System.err.println("IOException in reading input file!!!");
		}	
    } //end readFile()
    
    

    /** main : creates a Lab1b Object with the filename passed in
     * argument*/
    public static void main(String[] args)
    {
		if (args.length == 0)
		    System.err.println("enter the data file name!");
		else
		    new Lab1b(args[0]);
    } //end main
    
} //end class Lab1b
