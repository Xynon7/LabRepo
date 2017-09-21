package lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Chase Clawson
 * This program takes in a file of student names, creates a seat map,
 * and allows the user to input a seat location and find out what student sits there.
 */

public class SeatMapper
{

    public static void main(String[] args)
    {
        SeatMapper lr = new SeatMapper();
        
        //Creating the seat map and coordinate variables
        String[][] seatMap;
        int row = 0;
        int column = 0;
        
        //Reading file for names and then creating the seat map
        seatMap = lr.SetSeats(lr.GetNames());
        
        //Retrieving the user input of what location they want to check
        boolean gettingInput = true;
        while (gettingInput)
        {
            try
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter the location of a seat to retrieve the student's name. (eg. 1,2 will get the second seat in the first row):");
                String[] coords = br.readLine().split(",");
                row = Integer.parseInt(coords[0]) - 1;
                column = Integer.parseInt(coords[1]) - 1;
                gettingInput = false;
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid row and column (eg. 1,1)");
            }
        }
        
        //Print what students sits in the inputted seat, if any
        try
        {
            System.out.println(seatMap[column][row]);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("That is an empty seat.");
        }
    }

    //Method that reads the given file, splits it into names based on lines, and returns the list of names
    public ArrayList<String> GetNames()
    {
        ArrayList<String> studentNames = new ArrayList<String>();
        try
        {
            File inputFile = new File("names.dat");
            Scanner s = new Scanner(inputFile);
            while (s.hasNextLine())
            {
                String studentName = s.nextLine();
                studentNames.add(studentName);
            }
            s.close();
            return studentNames;
        }
        catch (IOException e)
        {
            System.err.printf("Error while reading file");
            return studentNames;
        }
    }

    //Method that takes in a list of names and assigns them to seats in a 2D array based on a row size.
    public String[][] SetSeats(ArrayList<String> studentNames)
    {
        int rowSize = 5;
        int columnSize = studentNames.size() / rowSize;
        String[][] seats = new String[rowSize][columnSize];
        int rowPosition = 0;
        int columnPosition = 0;
        
        for(String student : studentNames)
        {
            seats[columnPosition][rowPosition] = student;
            columnPosition++;
            if (columnPosition == rowSize)
            {
                columnPosition = 0;
                rowPosition++;
            }
        }
        
        return seats;
    }
}
