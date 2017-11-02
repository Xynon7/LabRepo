package lab10;

public class BonusAssignment
{
	int[] nextTwoFibos = new int[2];
	
	public long findSumOfFibos()
	{
		long sum = 0;
		int[] nextHundredFibos = new int[100];
		nextTwoFibos[0] = 0;
		nextTwoFibos[1] = 1;
		int index = 0;
		
		while (nextHundredFibos[index] < 2000000000)
		{
			if ((nextHundredFibos[index] % 2) != 0)
			{
				sum += nextHundredFibos[index];
			}
			
			index++;
			
			if (index == 100)
			{
				index = 0;
				nextHundredFibos = genNextHundred();
			}
		}
		
		return sum;
	}
	
	private int[] genNextHundred()
	{
		int index = 2;
		int[] nextSet = new int[100];
		
		nextSet[0] = nextTwoFibos[0];
		nextSet[1] = nextTwoFibos[1];
		
		while(index < 100)
		{
			nextSet[index] = nextSet[index-1] + nextSet[index-2];
			index++;
		}
		
		nextTwoFibos[0] = nextSet[98] + nextSet[99];
		nextTwoFibos[1] = nextSet[99] + nextTwoFibos[0];
		
		return nextSet;
	}
}
