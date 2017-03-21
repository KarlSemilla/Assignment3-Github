public class Employee
{
    protected String name;
    protected String num;
    protected String dept;
    protected char type;

    public Employee()
    {

    }

    public Employee(String name, String num, String dept, char type)
    {
        name = "";
        num = "";
        dept = "";
        type = ' ';
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

    public char getType()
    {
        return type;
    }

    public void setName(String empName)
    {
        name = empName;
    }

    public void setEmpNum(String empNum)
    {
        num = empNum;
    } 

    public void setDept(String department)
    {
        dept = department;
    }

    public boolean topSeller()
    {
        boolean topSell = false;
        
        
    }
    
    public String toString()
    {
        return "";
    }

    public void writeData()
    {

    }
}
