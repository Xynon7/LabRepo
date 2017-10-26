package lab9;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class DelimiterCheck
{
	
	public boolean check(String delimitedString)
	{
		char[] arrayOfDelimitedString = delimitedString.toCharArray();
		Stack<Character> delimiterStack = new Stack<Character>();
		
		for (int i = 0; i < arrayOfDelimitedString.length; i++)
		{
			char charToTest = arrayOfDelimitedString[i];
			if (charToTest == '{' || charToTest == '[' || charToTest == '(')
			{
				delimiterStack.push(charToTest);
			}
			else if (charToTest == '}')
			{
				if (delimiterStack.isEmpty())
				{
					System.out.println("False check: Missing Opening Delimiter");
				}
				else
				{
					char possibleBracketOpener = delimiterStack.pop();
				
					if (possibleBracketOpener != '{')
					{
						System.out.println("False check: Mismatched Open and Close Delimiters");
						return false;
					}
				}
			}
			else if (charToTest == ']')
			{
				if (delimiterStack.isEmpty())
				{
					System.out.println("False check: Missing Opening Delimiter");
					return false;
				}
				else
				{
					char possibleBracketOpener = delimiterStack.pop();
					
					if (possibleBracketOpener != '[')
					{
						System.out.println("False check: Mismatched Open and Close Delimiters");
						return false;
					}
				}
			}
			else if (charToTest == ')')
			{
				if (delimiterStack.isEmpty())
				{
					System.out.println("False check: Missing Opening Delimiter");
				}
				else
				{
					char possibleBracketOpener = delimiterStack.pop();
					
					if (possibleBracketOpener != '(')
					{
						System.out.println("False check: Mismatched Open and Close Delimiters");
						return false;
					}	
				}
			}
		}
		
		if (!delimiterStack.isEmpty())
		{
			System.out.println("False check: Missing Closing Delimiter");
			return false;
		}
		
		System.out.println("True check: No Mismatches");
		return true;
	}
	
	@Test
	public void delimiterCheckTest()
	{
		assertTrue(check("{bladibla}"));
		assertTrue(check("{bla[di]bla}"));
		assertTrue(check("{bla(dibla)}"));
		assertFalse(check("{notdibla"));
		assertFalse(check("notdibla]"));
		assertFalse(check("no(tdib()la"));
		assertFalse(check("{notdib)la"));
	}

}
