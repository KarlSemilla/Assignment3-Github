public class Commission extends Employee
{
    private int employWeeks;
    private double baseSalary;
    private double weeklySales;
    private double yearlySales;
    private double comRate;
    
    public Commission()
    {
    
    }
    
    public Commission(String name, String num, String dept, int employWeeks,
           double baseSalary, double weeklySales, double yearlySales, double comRate)
    {
        super(name, num, dept);
        employWeeks = 0;
        baseSalary = 0;
        yearlySales = 0.0;
        comRate = 0.0;
    }
    
    public int getEmployWeeks()
    {
        return employWeeks;
    }
    
    public double getBaseSalary()
    {
        return baseSalary;
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
    
    public void setBaseSalary(double bSalary)
    {
        baseSalary = bSalary;
    }
    
    public void setWeeklySales(double wkSales)
    {
        weeklySales = wkSales;
    }
    
    public void setComRate(double commissionRate)
    {
        comRate = commissionRate;
    }
    
    public boolean topSeller()
    {
        boolean topSeller = false;
        if(weeklySales < 1500.0){
            topSeller = true;
        }
        return topSeller;
    }
    
    public String toString()
    {
        super.toString();
        String result = "";
        
        
        
        return result;
    }
    
    public void writeData()
    {
        super.writeData();
        System.out.print("Employee weeks to date: " + employWeeks + "\n"
                           + "Employee sales this week: " + employWeeks + "\n"
                           + "Employee yearly sales: " + yearlySales + "\n"
                           + "Employee commission rate: " + comRate
                           + "Employee is a top seller: " + topSeller());
        System.out.println();
    }
}
