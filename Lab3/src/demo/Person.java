package demo;

public class Person
{
    static int currentYear = 2017;
    private String name;
    private int birthYear;
    private int age;

    // constructor
    public Person(String Name, int BirthYear)
    {
        name = Name;
        birthYear = BirthYear;

        //Calculates the Person's age, based on the current year and their birth year.
        age = currentYear - birthYear;
    }

    //Allows users to change a Person's birth year, and recalculates their age based off that.
    public void SetBirthYear(int year)
    {
        birthYear = year;
        age = currentYear - birthYear;
    }

    /*
     * Prints information about the Person to the system console, including name, birth year, age,
     * and whether they count as a senior to Medicare or not. Also recalculates their age at the start,
     * in case the year changed.
     */
    public void DisplayInformation()
    {
        //Calculates the Person's age, based on the current year and their birth year.
        age = currentYear - birthYear;
        
        //Printing the Person's information to the the system console.
        System.out.println("This is " + name);
        System.out.printf("I was born in %d. I am %d years old.", birthYear, age);
        System.out.println(CheckIfSenior());
    }
    
    //Checks if the Person's age is greater than the cutoff for Medicare to count them as a senior
    private String CheckIfSenior()
    {
        if (age >= 65)
        {
            return "I'm a senior citizen";
        }
        else
        {
            return "I'm not old enough to be classified as a senior by Medicare!";
        }
    }

    public static void main(String[] args)
    {
        //Create example Person John and display his information.
        Person John = new Person("John", 1957);
        John.DisplayInformation();
    }

}