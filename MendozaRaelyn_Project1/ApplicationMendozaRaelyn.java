//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 1
//Application Class

import java.util.Scanner;

public class ApplicationMendozaRaelyn {
    public static void main(String[] args) {
        System.out.println("Hello, welcome to the Office Manager Application. Let's begin!\n");

        //list of commands the user can use
        String commands = "Here are a list of commands to use: \n" +
                "'help' - lists the commands for the program. \n" +
                "'quit' - ends the program. \n" +
                "'add' - add an employee to your office. \n" +
                "'remove' - remove an employee from your office. \n" +
                "'find' - find an employee's information. \n" +
                "'list' - prints a list of all employees in your office. \n" +
                "'size' - tells you how many employees are in your office. \n" +
                "'full' - tells you if you have filled your office completely. \n" +
                "'empty' - tells you if your office is empty or not. \n";

        System.out.println(commands);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter how many employees you have: ");
        int capacity = in.nextInt();

        MendozaRaelyn_ListADT<MendozaRaelyn_Employee> employeesList = new MendozaRaelyn_ListADT<MendozaRaelyn_Employee>(capacity);

        String userChoice = "";
        System.out.println();
        while(!"quit".equalsIgnoreCase(userChoice)){
            System.out.print("What would you like do: ");
            userChoice = in.next();
            System.out.println();
            if("help".equalsIgnoreCase(userChoice)){
                System.out.println(commands);
            } else if ("add".equalsIgnoreCase(userChoice)) {
                System.out.print("What is the employee name: ");
                String employeeName = in.next();

                System.out.print("What is the department the employee works in: ");
                String department = in.next();

                System.out.print("What is the employee's salary: ");
                double salary = in.nextDouble();

                MendozaRaelyn_Employee employee = new MendozaRaelyn_Employee(employeeName, department, salary);
                employeesList.add(employee);
            } else if ("remove".equalsIgnoreCase(userChoice)) {
                System.out.print("Enter the name of the employee you would like to remove: ");
                String empName = in.next();
                employeesList.remove(empName);
            }else if ("find".equalsIgnoreCase(userChoice)){
                System.out.print("What is the name of the employee you are searching for: ");
                String name = in.next();
                int i = employeesList.find(name);
                System.out.println("Here is the employee's information: \n" + employeesList.get(i).toString());
            } else if ("list".equalsIgnoreCase(userChoice)) {
                employeesList.list();
            }else if ("size".equalsIgnoreCase(userChoice)) {
                int size = employeesList.size();
                System.out.println("Your office has " + size + " employees. \n");
            }else if ("full".equalsIgnoreCase(userChoice)) {
                boolean full = employeesList.isFull();

                if(full){
                    System.out.println("Your office is full.");
                }else{
                    System.out.println("Your office is not full yet.");
                }
            }else if ("empty".equalsIgnoreCase(userChoice)) {
                boolean empty = employeesList.isEmpty();

                if(empty){
                    System.out.println("Your office is empty.");
                }else{
                    System.out.println("Your office is not empty.");
                }
            }else{
                System.out.println("Please choose an option from the list of commands. If unsure of commands, type 'help'.\n");
            }
        }

    }
}
