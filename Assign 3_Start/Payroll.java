import java.util.*;
import java.io.*;
/**
 * Description: The payroll class will access the employee class and the children classes here. 
 * 
 * @author  Karl Semilla / Marlon Fallorin 
 * Date Created:
 * Last Modified:
 */
public class Payroll
{
    private ArrayList<Employee> emp = new ArrayList<Employee>();

    public void loadData(String loadFile) throws IOException
    {
        Scanner empFile = new Scanner(new File(loadFile));

        Employee employ = new Employee();
        Employee hour = new Hourly();
        Employee salary = new Salary();
        Employee com = new Commission();

        double uni = 0.0;
        int i = 0;
        while(empFile.hasNext()){
            String name = empFile.next();
            String ID = empFile.next();
            String dept = empFile.next();
            String type = empFile.next();

            if(type.equalsIgnoreCase("H")){
                //uni = enterValues(type);
                hour = new Hourly(name, ID, dept, empFile.nextDouble(),empFile.nextDouble());

                emp.add(hour);
            }
            else if(type.equalsIgnoreCase("S")){
                salary = new Salary(name, ID, dept, empFile.nextDouble());

                emp.add(salary);
            }
            else{
                //uni = enterValues(type);
                com = new Commission(name, ID, dept, empFile.nextInt(),empFile.nextDouble(),
                    empFile.nextDouble(), empFile.nextDouble(), empFile.nextDouble());

                emp.add(com);
            }
            i++;
        }
        empFile.close();
    }

    //     public double enterValues(String type)
    //     {
    //         Scanner scan = new Scanner(System.in);
    //         double fill = 0;
    //         if(type.equalsIgnoreCase("H")){
    //             System.out.println("Enter amount of hours the employee has worked: ");
    //             double hoursWorked = scan.nextDouble();
    //             fill = hoursWorked;
    //         }
    //         else if(type.equalsIgnoreCase("C")){
    //             System.out.println("Enter the weekly sales for this employee: ");
    //             double weeklySales = scan.nextDouble();
    //             fill = weeklySales;
    //         } 
    //         return fill;
    //     }

    //Will ask the user for input.
    public String askUser()
    {
        Scanner input = new Scanner(System.in);
        String info = input.next();
        return info;
    }

    //Validates the employee number. returns if they found the number
    public Employee validateNum(String num)
    {        
        Employee foundNum = null;

        for(int i = 0; i < emp.size(); i++)
        {
            if (emp.get(i).getNum().equals(num))
            {
                foundNum = emp.get(i);
            }        
        }

        return foundNum;
    }

    //Will check to see if the employee is already in the system. If not it will create a new employee.
    public void addEmployee(String num)
    {
        Employee check = null;
        check = validateNum(num);

        if(check != null){
            System.out.println("Employee cannot be created. Employee already exists.");
        }
        else{
            System.out.println("Employee was not found. New employee will be created.");
            scanInfo(num);
            System.out.println("Employee: " + num + " was created.");
        }
    }
    
    //If the employee has not been found. It will prompt this method to make a new employee.
    public void scanInfo(String num)
    {
        Scanner scan = new Scanner(System.in);
        Employee hour = new Hourly();
        Employee salary = new Salary();
        Employee commission = new Commission();

        System.out.println("Enter employee's name: ");
        String name = scan.nextLine();
        System.out.println("Enter employee's department: ");
        String dept = scan.nextLine();
        System.out.println("Enter the employee's pay type(hourly, salary, commission): ");
        String type = scan.nextLine();
        if(type.equalsIgnoreCase("H") || type.equalsIgnoreCase("Hourly")){
            System.out.println("Enter the amount of hours the employee has worked: ");
            double hoursWorked = scan.nextDouble();
            System.out.println("Enter the hourly rate of the employee: ");
            double hourlyRate = scan.nextDouble();

            hour = (new Hourly(name, num, dept, hoursWorked, hourlyRate));
            emp.add(hour);
        }
        else if(type.equalsIgnoreCase("S") || type.equalsIgnoreCase("Salary")){
            System.out.println("Enter the employee's yearly salary: ");
            double yearlySal = scan.nextDouble();
            salary = (new Salary(name, num, dept, yearlySal));
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
            commission = (new Commission(name, num, dept, employeeWeeks, bSalary,
                    weekSales, yrSales, cRate));
            emp.add(commission);
        }
        else
            System.out.println("Please enter hourly (or h), salary (or s), or commision (or c)");

    }

    //Will print out the employee info.
    public void printEmployeeInfo(String num)
    {
        Employee check = null;
        check = validateNum(num);
        if(check != null){
            check.writeData();
        }
        else
            System.out.println("Employee: " + num + ", could not be found.");
    }

    //Delete an individual employee profile.
    public void deleteEmployeeProfile(String num)
    {
        Scanner scan = new Scanner(System.in);
        Employee check = null;
        check = validateNum(num);
        String user = "";
        int pos = 0;
        int i = 0;
        if(check != null){
            System.out.print("Delete user " + num + " from the system?(Y/N): ");
            user = scan.next();
            while(i == 0){
                if(user.equalsIgnoreCase("y")){
                    System.out.println("Employee " + num + " will be deleted.");
                    pos = employeePosition(num);
                    emp.remove(pos);
                    i++;
                }
                else if(user.equalsIgnoreCase("n")){
                    System.out.println("Employee " + "'" + num + "'" + " will not be deleted.");
                    i++;
                }
                else
                    System.out.println("Please enter a valid employee number.");
            }
        }
    }

    public int employeePosition(String num){
        int y = 0;
        for(int i = 0; i < emp.size(); i++){
            if (emp.get(i).getNum().equals(num))
            {
                y = i;
            }  
        }

        return y;
    }

    //Prints the weekly salary
    public void printWeeklySalary(String num)
    {
        Employee check = null;
        check = validateNum(num);
        boolean verify = false;
        double sal = 0.0;
        int i = 0;
        if(check != null){
            while(i < emp.size()){
                if(emp.get(i).equals(check)){
                    sal = emp.get(i).calcWeeklySalary();
                    System.out.println("" + check.getName() + "'s weekly salary is: " + sal);
                }
                i++;
            }
        }
        else 
            System.out.println("Employee: " + num + " was not found.");
    }

    //Prints who are in the topsellers 
    public void printTopSellers()
    {
        boolean verify = false;
        for(int i = 0; i < emp.size(); i++){
            verify = emp.get(i).topSeller();
            if(verify == true){
                System.out.println(emp.get(i).getName());
            }
        }
    }

    //Prints out the weekly report.
    public void printWeeklyReport()
    {
        for(int i = 0; i < emp.size(); i++){
            emp.get(i).toString();
            emp.get(i).weeklyReport();
        }
    }

    //This will print out the end of week and will ask the user to create a file.
    public void endOfWeek() throws IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file to be created: ");
        String fileName = scan.next();
        fileName += ".txt";
        PrintWriter write = new PrintWriter(fileName);

        for(int i = 0; i < emp.size(); i++){
            emp.get(i).endOfWeek();
            write.print(emp.get(i).toString());
            if(i < emp.size()){
                write.println();
            }
        }
        System.out.println("File has finished writing.");
        write.close();
    }
}