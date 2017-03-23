public class Hourly extends Employee
{
    private double hoursWorked;
    private double hourlyRate;
    private double salary;

    public Hourly()
    {
        super();
        hoursWorked = 0.0;
        hourlyRate = 0.0;
        salary = 0.0;
    }

    public Hourly(String name, String num, String dept, double hrRate, double hrWorked)
    {
        super(name, num, dept);
        hourlyRate = hrRate;
        hoursWorked = hrWorked;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public double getHourlyRate()
    {
        return hourlyRate;
    }

    public void setHoursWorked(double hrWork)
    {
        hourlyRate = hrWork;
    }

    public void setHourlyRate(double hrRate)
    {
        hourlyRate = hrRate;
    }

    public double calcWeeklySalary()
    {
        double overtimeHrs = 0.0;
        double overtimeRate = 0.0;
        if(hoursWorked > 40.0){
            overtimeHrs = hoursWorked - 40.0;
            overtimeRate = (hourlyRate * 1.5);
            hoursWorked = 40.0;
            salary = (hoursWorked * hourlyRate) + (overtimeHrs * overtimeRate);
        }
        else{
            salary = hourlyRate * hoursWorked;
        }
        return salary;
    }

    public String toString()
    {
        return "";
    }

    public void weeklyReport()
    {
        super.weeklyReport();
        System.out.print("Hourly" + " " + "$" + calcWeeklySalary() + "\n");
    }

    public void writeData()
    {
        super.writeData();
        System.out.print("Employee hours worked this week: " + hoursWorked + "\n"
            + "Employee hourly rate: " + hourlyRate);

        System.out.println();      
    }
}
