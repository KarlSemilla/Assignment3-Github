import java.io.*;
public class Client
{
    public static void main(String args[]) throws IOException
    {
        // define necessary variables here
        Payroll p = new Payroll();
        p.loadData();
        p.printEmployeeInfo("Sally");
        p.deleteEmployeeProfile("Sally");
        p.printEmployeeInfo("Sally");
        // place here the code for the processing requirements
        System.out.println ("Thank you for using the Payroll Processing System");
    }
    
   
    //   The Payroll processing menu
     
    public static void showMenu()
    {
        System.out.println("\nMENU:");
        System.out.println("A - Add a new employee");
        System.out.println("I - Print information of an individual employee");
        System.out.println("D - Remove an employee from payroll");
        System.out.println("S - calculate and print the weekly pay of an employee");
        System.out.println("P - prints salary report");
        System.out.println("W - End of week processing");
        System.out.println();
        System.out.println("Q - Quit the system");
    }

}
