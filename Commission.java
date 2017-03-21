public class Commission extends Employee
{
    private int employWeeks;
    private double weeklySales;
    private double yearlySales;
    private double comRate;
    
    public Commission()
    {
    
    }
    
    public Commission(String name, String num, String dept, char type)
    {
        super(name, num, dept, type);
        employWeeks = 0;
        yearlySales = 0.0;
        comRate = 0.0;
    }
    
    public double getEmployWeeks()
    {
        return employWeeks;
    }
    
    public double getWeeklySales()
    {
        return weeklySales;
    }
    
    public double getYearlySales()
    {
        return yearlySales;
    }
    
    public double getComRate()
    {
        return comRate;
    }
    
    public void setEmployWeeks(int empWeeks)
    {
        employWeeks = empWeeks;
    }
    
    public void setWeeklySales(double wkSales)
    {
        weeklySales = wkSales;
    }
    
    public void setComRate(double commissionRate)
    {
        comRate = commissionRate;
    }
    
    public String toString()
    {
        return "";
    }
    
    public void writeData()
    {
        
    }
}
