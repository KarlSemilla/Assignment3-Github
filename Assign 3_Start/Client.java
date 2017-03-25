import java.io.*;
import java.util.*;
/**
 * Description: This is the menu class which the client will access all the options.
 * 
 * @author Karl Semilla / Marlon Fallorin 
 * Date Created:
 * Last Modified:
 */
public class Client
{
    public static void main(String args[]) throws IOException
    {
        // define necessary variables here
        Payroll p = new Payroll();
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println("Please enter the text file that you wish to load.");
        String loadFile = keyboard.next();
        loadFile = loadFile + ".txt";
        System.out.println(loadFile);
        p.loadData(loadFile);
        //p.printEmployeeInfo("111-111-111");
        //p.deleteEmployeeProfile("111-111-111");
        //p.printEmployeeInfo("111-111-111");
        //p.printEmployeeInfo("222-222-222");
        //p.printWeeklySalary("222-222-222");
        //p.printWeeklyReport();
        //p.printTopSellers();
        //p.endOfWeek();
        // place here the code for the processing requirements
        showMenu();
        System.out.println("Please choose one of the menu options: ");
        String inputChoice = keyboard.next().toUpperCase();
        char choice = inputChoice.charAt(0);
        while(choice != 'Q')
        {
            switch(choice)
            {
                case 'A': System.out.println("Add a new employee. Please enter the ID (Example 111-111-111):"); input = p.askUser(); p.addEmployee(input); break;
                case 'I': System.out.println("Print Info of Individual Employee. Please enter the ID (Example 111-111-111):"); input = p.askUser(); p.printEmployeeInfo(input); break;
                case 'D': System.out.println("Remove an Employee from Payroll. Please enter the ID (Example 111-111-111):"); input = p.askUser(); p.deleteEmployeeProfile(input); break;
                case 'S': System.out.println("Caculate and Print the weekly pay of an employee. Please enter the ID (Example 111-111-111):");input = p.askUser(); p.printWeeklySalary(input); break;
                case 'T': System.out.println("Print: Commission Employees who are Top Sellers:"); p.printTopSellers(); break;
                case 'P': System.out.println("prints salary report"); p.printWeeklyReport(); break;
                case 'W': System.out.println("End of week processing"); p.endOfWeek(); break;
                default:
                System.out.println("Invalid Choice.");

            }
            showMenu();
            System.out.println("Please choose one of the menu options: ");
            inputChoice = keyboard.next().toUpperCase();
            choice = inputChoice.charAt(0);
        }
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
        System.out.println("T - This prints the list of Commission employees who are topSellers");
        System.out.println("P - prints salary report");
        System.out.println("W - End of week processing");
        System.out.println();
        System.out.println("Q - Quit the system");
    }

}
