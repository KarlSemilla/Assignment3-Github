import java.io.*;
import java.util.*;
public class Client
{
    public static void main(String args[]) throws IOException
    {
        // define necessary variables here
        Payroll p = new Payroll();
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        p.loadData();
        // place here the code for the processing requirements
        showMenu();
        System.out.println("Please choose one of the menu options: ");
        String inputChoice = keyboard.next().toUpperCase();
        char choice = inputChoice.charAt(0);
        while(choice != 'Q')
        {
            switch(choice)
            {
                case 'A': System.out.println("Add a new employee:"); input = p.askUser(); p.addEmployee(input); break;
                case 'I': System.out.println("Print Info of Individual Employee:"); break;
                case 'D': System.out.println("Remove an Employee from Payroll:"); break;
                case 'S': System.out.println("Caculate and Print the weekly pay of an employee:"); break;
                case 'P': System.out.println("prints salary report"); break;
                case 'w': System.out.println("End of week processing"); break;
                default:
                System.out.println("Invalid Choice.");

            }
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
        System.out.println("P - prints salary report");
        System.out.println("W - End of week processing");
        System.out.println();
        System.out.println("Q - Quit the system");
    }

}
