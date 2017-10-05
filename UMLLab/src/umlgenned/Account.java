/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/
package umlgenned;


// line 8 "main.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private double balance;

  //Account Associations
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(double aBalance, Customer aCustomer)
  {
    balance = aBalance;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create account due to customer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBalance(double aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public double getBalance()
  {
    return balance;
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
      existingCustomer.removeAccount(this);
    }
    customer.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer placeholderCustomer = customer;
    this.customer = null;
    placeholderCustomer.removeAccount(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "balance" + ":" + getBalance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}