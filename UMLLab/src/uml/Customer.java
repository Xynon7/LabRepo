package uml;

public class Customer
{
	private String name;
	private Order[] orders;
	private Account[] accounts;
	private String address;

	public String getName()
	{
		return name;
	}
	public Order[] retrieveOrderList()
	{
		return orders;
	}
	public Account[] retrieveCustomerAccounts()
	{
		return accounts;
	}
	public String getAddress()
	{
		return address;
	}
}
