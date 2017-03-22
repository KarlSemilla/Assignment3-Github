public class Salary extends Employee
{
    private double yearlySalary;

    public Salary()
    {
    
    }
    
    public Salary(String name, String num, String dept, double ySalary)
    {
        super(name, num, dept);
        yearlySalary = ySalary;
    }
    
    public double getYearlySalary()
    {
        return yearlySalary;
    }
    
    public void setYearlySalary(double yrSalary)
    {
        yearlySalary = yrSalary;
    }
    
    public double calcWeeklySalary()
    {
        double take = 0.0;
        take = yearlySalary * (1 / 52);
        return take;
    }
    
    public String toString()
    {
        return "";
    }
    
    public void writeData()
    {
        super.writeData();
        System.out.print("Employee yearly salary: " + yearlySalary);
        
        System.out.println();
    }
}
