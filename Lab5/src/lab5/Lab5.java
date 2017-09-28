package lab5;

import java.io.IOException;
import java.util.Scanner;

public class Lab5
{
	public static void main(String[] args)
	{
		//Initialize class and scanner
		Lab5 lab = new Lab5();
		Scanner inputScanner = new Scanner(System.in);
		
		//Get user input
		System.out.println("Please enter the word or phrase you suspect is a palindrome:");
		String stringToCheck = inputScanner.next();
		
		//Convert string input to a char array to manipulate
		char[] charsToCheck = new char[stringToCheck.length()];
		for (int i = 0; i < stringToCheck.length(); i++)
		{
			charsToCheck[i] = stringToCheck.charAt(i);
		}
		
		//Check if the string is indeed a palindrome
 		boolean isAPalindrome = lab.IsAPalindrome(charsToCheck);
 		
 		//Print whether the string was a palindrome. If it wasn't, a not is added after the is.
		System.out.print("This word is ");
		if (!isAPalindrome)
		{
			System.out.print("not ");
		}
		System.out.print("a palindrome.");
		
		//Wait for user to press enter and exit the program
		System.out.println("Press enter to exit the program.");
		try
		{
			System.in.read();
		}
		catch (IOException ioe)
		{
			System.out.print("What did you do?");
		}
	}
	
	//Recursively checks if a set of chars is a palindrome
	public boolean IsAPalindrome(char[] charsToCheck)
	{
		//if there is only one or zero chars, it is definitely a palindrome
		if (charsToCheck.length < 2)
		{
			return true;
		}
		//If the first and last chars are the same, recurse the method without the first and last chars to continue the check
		else if (charsToCheck[charsToCheck.length - 1] == charsToCheck[0])
		{
			char[] newCharsToCheck = new char[charsToCheck.length - 2];
			for (int i = 1; i < newCharsToCheck.length + 1; i++)
			{
				newCharsToCheck[i - 1] = charsToCheck[i];
			}
			return IsAPalindrome(newCharsToCheck);
		}
		//If the first and last aren't the same, it ain't a palindrome
		else
		{
			return false;
		}
	}
}
