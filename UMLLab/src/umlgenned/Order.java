/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/
package umlgenned;

import java.sql.Date;

// line 14 "main.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private double orderPrice;
  private Date orderDate;
  private boolean completed;

  //Order Associations
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(double aOrderPrice, Date aOrderDate, boolean aCompleted, Customer aCustomer)
  {
    orderPrice = aOrderPrice;
    orderDate = aOrderDate;
    completed = aCompleted;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create order due to customer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrderPrice(double aOrderPrice)
  {
    boolean wasSet = false;
    orderPrice = aOrderPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderDate(Date aOrderDate)
  {
    boolean wasSet = false;
    orderDate = aOrderDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setCompleted(boolean aCompleted)
  {
    boolean wasSet = false;
    completed = aCompleted;
    wasSet = true;
    return wasSet;
  }

  public double getOrderPrice()
  {
    return orderPrice;
  }

  public Date getOrderDate()
  {
    return orderDate;
  }

  public boolean getCompleted()
  {
    return completed;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeOrder(this);
    }
    customer.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer placeholderCustomer = customer;
    this.customer = null;
    placeholderCustomer.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderPrice" + ":" + getOrderPrice()+ "," +
            "completed" + ":" + getCompleted()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "orderDate" + "=" + (getOrderDate() != null ? !getOrderDate().equals(this)  ? getOrderDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}