public class Employee
{
    protected String name;
    protected String num;
    protected String dept;
    protected String type;

    public Employee()
    {
        name = "";
        num = "";
        dept = "";
        type = "";
    }

    public Employee(String empName, String ID, String department)
    {
        name = empName;
        num = ID;
        dept = department;
    }

    public String getName()
    {
        return name;
    }

    public String getNum()
    {
        return num;
    }

    public String getDept()
    {
        return dept;
    }

    public String getType()
    {
        return type;
    }

    public void setName(String empName)
    {
        name = empName;
    }

    public void setNum(String empNum)
    {
        num = empNum;
    } 

    public void setDept(String department)
    {
        dept = department;
    }

    public boolean equals(Employee e)
    {   
        boolean check = false;
        if(e.getNum() == num){
            check = true;
        }
        return check;
    }
    
    public double calcWeeklySalary()
    {
        return 0;
    }
    
    public boolean topSeller()
    {
        return false;
    }
    
    public String toString()
    {
        String result;
        
        result = name + "   " + num + "   " + dept + " ";

        return result;
    }
    
    public void weeklyReport()
    {
        System.out.print(name + "   " + num + "   " + dept + "   ");
    }

    public void writeData()
    {
        System.out.println("Employee Name: " + name + "\n"
                            + "Employee ID: " + num + "\n"
                            + "Department: " + dept);
    }
    
    public void endOfWeek()
    {
        
    }
}
