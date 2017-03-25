/**
 * Description: Commission class
 * 
 * @author  Karl Semilla / Marlon Fallorin 
 * Date Created:
 * Last Modified:
 */
public class Commission extends Employee
{
    private int employWeeks;
    private double baseSalary;
    private double weeklySales;
    private double yearlySales;
    private double comRate;

    //default constructor
    public Commission()
    {
        super();
        employWeeks = 0;
        baseSalary = 0.0;
        weeklySales = 0.0;
        yearlySales = 0.0;
        comRate = 0.0;
    }

    public Commission(String name, String num, String dept, int employWks,
    double bSalary, double wSales, double ySales, double cRate)
    {
        super(name, num, dept);
        employWeeks = employWks;
        baseSalary = bSalary;
        weeklySales = wSales;
        yearlySales = ySales;
        comRate = cRate;
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

    //This will check the to see who is in the top seller. 
    public boolean topSeller()
    {
        boolean topSeller = false;
        if(weeklySales < 1500.0){
            topSeller = true;
        }
        return topSeller;
    }
    
    //Calculate the weekly salary
    public double calcWeeklySalary()
    {
        double salary = baseSalary + (comRate * weeklySales);
        return salary;
    }

    public String toString()
    {
        String result = super.toString() + "C" + " " + employWeeks + "   " + baseSalary + "   " + weeklySales + "   " + yearlySales + "   " + comRate;
        
        return result;
    }

    public void weeklyReport()
    {
        super.weeklyReport();
        System.out.print("Commission" + " " + "$" + baseSalary + "\n");
    }   

    public void writeData()
    {
        super.writeData();
        System.out.print("Employee weeks to date: " + employWeeks + "\n"
            + "Employee sales this week: " + employWeeks + "\n"
            + "Employee yearly sales: " + yearlySales + "\n"
            + "Employee commission rate: " + comRate + "\n"
            + "Employee is a top seller: " + topSeller() + "\n");
            
        System.out.println();
    }
    
    public void endOfWeek()
    {
        weeklySales = 0.0;
        employWeeks++;
    }
}
