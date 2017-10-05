package uml;

import java.util.Date;

public class Order
{
	private double orderPrice;
	private Date orderDate;
	private boolean completed;
	
	public double getOrderPrice()
	{
		return orderPrice;
	}
	public Date getDateOrdered()
	{
		return orderDate;
	}
	public void completeOrder()
	{
		completed = true;
	}
	public boolean isOrderComplete()
	{
		return completed;
	}
}
