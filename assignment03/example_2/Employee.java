import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Employee
{
    private String name;
    private Date hireDate;

    public Employee( )
    {
        name = "No name";
        hireDate = new Date();
    }

    /**
     Precondition: Neither theName nor theDate is null.
     */
    public Employee(String theName, Date theDate)
    {
        if (theName == null || theDate == null)
        {
            System.out.println("Fatal Error creating employee.");
            System.exit(0);
        }
        name = theName;
        hireDate = new Date(String.valueOf(theDate));
    }

    public Employee(Employee originalObject)
    {
        name = originalObject.name;
        hireDate = new Date(String.valueOf(originalObject.hireDate));
    }

    public String getName( )
    {
        return name;
    }

    public Date getHireDate( )
    {
        return new Date(String.valueOf(hireDate));
    }

    /**
     Precondition newName is not null.
     */
    public void setName(String newName)
    {
        if (newName == null)
        {
            System.out.println("Fatal Error setting employee name.");
            System.exit(0);
        }
        else
            name = newName;
    }

    /**
     Precondition newDate is not null.
     */
    public void setHireDate(Date newDate)
    {
        if (newDate == null)
        {
            System.out.println("Fatal Error setting employee hire date.");
            System.exit(0);
        }
        else
            hireDate = new Date(String.valueOf(newDate));
    }


    public String toString( )
    {
        return (name + " " + hireDate.toString( ));
    }


    public boolean equals(Employee otherEmployee)
    {
        return (name.equals(otherEmployee.name)
                && hireDate.equals(otherEmployee.hireDate));
    }

    private long calculateDuration(){
        Date today = new Date();
        long milliseconds = hireDate.getTime() - today.getTime();
        return milliseconds;
    }
}