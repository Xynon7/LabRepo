package lab10;

public class RequiredAssignment
{	
	public static void main(String[] args)
	{
		RequiredAssignment reqAssign = new RequiredAssignment();
		BonusAssignment bonAssign = new BonusAssignment();
		
		int largestPalindrome = reqAssign.findLargestPalindrome(1000, 9999);
		long sumOfOddFibo = bonAssign.findSumOfFibos();
		
		System.out.println(largestPalindrome);
		System.out.println(sumOfOddFibo);
	}

	public int findLargestPalindrome(int smallestNum, int largestNum)
	{
		int largestPalindrome = 0;
		for (int firstNum = 9999; firstNum > 1000; firstNum--)
		{
			for (int secondNum = 9999; secondNum > 1000; secondNum--)
			{
				int newNum = firstNum * secondNum;
				if (newNum > largestPalindrome)
				{
					if (checkPalindrome(newNum))
					{
						largestPalindrome = newNum;
					}
				}
			}
		}
		return largestPalindrome;
	}
	
	public boolean checkPalindrome(Integer possPalindrome)
	{
		char[] numToCheck = possPalindrome.toString().toCharArray();
		int leftSideIndex = 0;
		int rightSideIndex =  numToCheck.length - 1;
		boolean isPalindrome = false;
		
		if (numToCheck[leftSideIndex] == numToCheck[rightSideIndex])
		{
			isPalindrome = true;
			while (leftSideIndex != rightSideIndex && isPalindrome)
			{
				leftSideIndex++;
				if (leftSideIndex == rightSideIndex)
				{
					break;
				}
				rightSideIndex--;
				
				if (numToCheck[leftSideIndex] == numToCheck[rightSideIndex])
				{
					isPalindrome = true;
				}
				else
				{
					isPalindrome = false;
				}
			}
		}
			
		return isPalindrome;
	}
}
