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
}
