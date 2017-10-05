package uml;

public class Account
{
	private double balance;
	
	public double getAccountBalance()
	{
		return balance;
	}
	public void addToBalance(double amountToAdd)
	{
		balance += amountToAdd;
	}
	public void removeFromBalance(double amountToRemove)
	{
		balance -= amountToRemove;
	}
}
