//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 2
//Application Class

import java.util.Scanner;

public class ApplicationMendozaRaelyn {
    public static void main(String[] args) {
        System.out.println("Hello, welcome to the Office Manager Application. Let's begin!\n");

        //list of commands the user can use
        String commands = "Here are a list of commands to use: \n" +
                "'help' - lists the commands for the program. \n" +
                "'quit' - ends the program. \n" +
                "'push' - add an employee to your office. \n" +
                "'pop' - remove an employee from your office. \n" +
                "'top' - gives the employee's information that was last added. \n" +
                "'size' - tells you how many employees are in your office. \n" +
                "'list' - gives you a list of all current employees. \n";

        System.out.println(commands);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter how many employees you have: ");
        int capacity = in.nextInt();

        MendozaRaelyn_StackADT employeesList = new MendozaRaelyn_StackADT(capacity);

        String userChoice = "";
        System.out.println();
        while(!"quit".equalsIgnoreCase(userChoice)){
            System.out.print("What would you like do: ");
            userChoice = in.next();
            System.out.println();
            if("help".equalsIgnoreCase(userChoice)){
                System.out.println(commands);
            } else if ("push".equalsIgnoreCase(userChoice)) {
                System.out.print("What is the employee name: ");
                String employeeName = in.next();

                System.out.print("What is the department the employee works in: ");
                String department = in.next();

                System.out.print("What is the employee's salary: ");
                double salary = in.nextDouble();

                MendozaRaelyn_Employee employee = new MendozaRaelyn_Employee(employeeName, department, salary);
                try {
                    employeesList.push(employee);
                    System.out.println();
                } catch (MendozaRaelyn_StackOverflowException e) {
                    System.out.println(e.getMessage() );
                    System.out.println("Employee was not added." + "\n");
                }
            } else if ("pop".equalsIgnoreCase(userChoice)) {
                try {
                    String employee = employeesList.pop();
                    System.out.println("You removed the following employee from your office: \n" + employee);

                } catch (MendozaRaelyn_StackUnderflowException e) {
                    System.out.println(e.getMessage() + "\n");
                }
            }else if ("top".equalsIgnoreCase(userChoice)){
                try {
                    String lastEmployee = employeesList.top();
                    System.out.println("The last employee you entered was:\n" + lastEmployee);
                } catch (MendozaRaelyn_StackUnderflowException e) {
                    System.out.println(e.getMessage() + "\n");
                }
            } else if ("size".equalsIgnoreCase(userChoice)) {
                int size = employeesList.size();
                System.out.println("Your office has " + size + " employees. \n");
            }else if ("list".equalsIgnoreCase(userChoice)) {
                System.out.println(employeesList.list());
            }else{
                if("quit".equalsIgnoreCase(userChoice)){
                    System.out.println("Quitting the program now.");
                }else{
                    System.out.println("Please choose an option from the list of commands. If unsure of commands, type 'help'.\n");
                }
            }
        }

    }
}
