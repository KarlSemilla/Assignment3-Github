import java.util.*;
import java.io.*;
public class Payroll
{
    private ArrayList<Employee> emp = new ArrayList<Employee>();

    public void loadData() throws IOException
    {
        Scanner empFile = new Scanner(new File("in.txt"));

        Employee employ = new Employee();
        Employee hour = new Hourly();
        Employee salary = new Salary();
        Employee com = new Commission();

        int i = 0;
        while(empFile.hasNext()){
            String name = empFile.next();
            String ID = empFile.next();
            String dept = empFile.next();
            String type = empFile.next();

            if(type.equalsIgnoreCase("H")){
                hour = new Hourly(name, ID, dept, empFile.nextDouble(), empFile.nextDouble());

                emp.add(hour);
            }
            else if(type.equalsIgnoreCase("S")){
                salary = new Salary(name, ID, dept, empFile.nextDouble());

                emp.add(salary);
            }
            else{
                com = new Commission(name, ID, dept, empFile.nextInt(), empFile.nextDouble(),
                    empFile.nextDouble(), empFile.nextDouble(), empFile.nextDouble());

                emp.add(com);
            }
            i++;
        }
        empFile.close();
    }

    public Employee validateName(String name)
    {        
        Employee foundName = null;

        for(int i = 0; i < emp.size(); i++)
        {
            if (emp.get(i).getName().equals(name))
            {
                foundName = emp.get(i);
            }        
        }

        return foundName;
    }

    public void addEmployee(String name)
    {
        Employee check = null;
        check = validateName(name);

        if(check != null){
            System.out.println("Employee cannot be created. Employee already exists.");
        }
        else{
            System.out.println("Employee was not found. New employee will be created.");
            scanInfo(name);
            System.out.println("Employee: " + name + " was created.");
        }
    }

    public void scanInfo(String name)
    {
        Scanner scan = new Scanner(System.in);
        Employee hour = new Hourly();
        Employee salary = new Salary();
        Employee commission = new Commission();

        System.out.println("Enter employee ID: ");
        String ID = scan.nextLine();
        System.out.println("Enter employee's department: ");
        String dept = scan.nextLine();
        System.out.println("Enter the employee's pay type(hourly, salary, commission): ");
        String type = scan.nextLine();
        if(type.equalsIgnoreCase("H") || type.equalsIgnoreCase("Hourly")){
            System.out.println("Enter the amount of hours the employee has worked: ");
            double hoursWorked = scan.nextDouble();
            System.out.println("Enter the hourly rate of the employee: ");
            double hourlyRate = scan.nextDouble();

            hour = (new Hourly(name, ID, dept, hoursWorked, hourlyRate));
            emp.add(hour);
        }
        else if(type.equalsIgnoreCase("S") || type.equalsIgnoreCase("Salary")){
            System.out.println("Enter the employee's yearly salary: ");
            double yearlySal = scan.nextDouble();
            salary = (new Salary(name, ID, dept, yearlySal));
            emp.add(salary);
        }
        else if(type.equalsIgnoreCase("C") || type.equalsIgnoreCase("Commission")){
            System.out.println("Enter the weeks the employee has worked this month: ");
            int employeeWeeks = scan.nextInt();
            System.out.println("Enter the employee's base salary: ");
            double bSalary = scan.nextDouble();
            System.out.println("Enter the employee's weekly sales: ");
            double weekSales = scan.nextDouble();
            System.out.println("Enter the employee's yearly sales: ");
            double yrSales = scan.nextDouble();
            System.out.println("Enter the employee's commission rate: " );
            double cRate = scan.nextDouble();
            commission = (new Commission(name, ID, dept, employeeWeeks, bSalary,
                    weekSales, yrSales, cRate));
            emp.add(commission);
        }
        else
            System.out.println("Please enter hourly (or h), salary (or s), or commision (or c)");

    }

    public void printEmployeeInfo(String name)
    {
        Employee check = null;
        check = validateName(name);
        if(check != null){
            check.writeData();
        }
        else
            System.out.println("Employee: " + name + ", could not be found.");
    }

    public void deleteEmployeeProfile(String name)
    {
        Scanner scan = new Scanner(System.in);
        Employee check = null;
        check = validateName(name);
        String user = "";
        int pos = 0;
        int i = 0;
        if(check != null){
            System.out.print("Delete user " + name + " from the system?(Y/N): ");
            user = scan.next();
            while(i == 0){
                if(user.equalsIgnoreCase("y")){
                    System.out.println("Employee " + name + " will be deleted.");
                    pos = employeePosition(name);
                    emp.remove(pos);
                    i++;
                }
                else if(user.equalsIgnoreCase("n")){
                    System.out.println("Employee " + "'" + name + "'" + " will not be deleted.");
                    i++;
                }
            }
        }
    }

    public int employeePosition(String name){
        int y = 0;
        for(int i = 0; i < emp.size(); i++){
            if (emp.get(i).getName().equals(name))
            {
                y = i;
            }  
        }

        return y;
    }
}