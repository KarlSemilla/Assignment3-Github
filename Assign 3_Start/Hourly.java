public class Hourly extends Employee
{
    private int hoursWorked;
    private double hourlyRate;
    
    public Hourly()
    {
    
    }
    
    public Hourly(String name, String num, String dept, char type)
    {
        super(name, num, dept, type);
        hoursWorked = 0;
        hourlyRate = 0.0;
    }
    
    public int getHoursWorked()
    {
        return hoursWorked;
    }
    
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
    public void setHoursWorked(int hrWork)
    {
        hourlyRate = hrWork;
    }
    
    public void setHourlyRate(double hrRate)
    {
        hourlyRate = hrRate;
    }
    
    public double calcWeeklySalary()
    {
        int overtimeHrs = 0;
        double overtimeRate = 0.0;
        double salary = 0.0;
        if(hoursWorked < 40){
            overtimeHrs = hoursWorked - 40;
            overtimeRate = (hourlyRate * 0.5) + hourlyRate;
            salary = overtimeHrs * overtimeRate;
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
    
    public void writeData()
    {
        super.writeData();
        System.out.print("Employee hours worked this week: " + hoursWorked + "\n"
                          + "Employee hourly rate: " + hourlyRate);
                          
        System.out.println();      
    }
}
