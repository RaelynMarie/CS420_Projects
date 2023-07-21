//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 4
//MendozaRaelyn_BST Application class

import java.util.Scanner;
import java.io.*;

public class MendozaRaelyn_BST_Application {
    private static int capacity;

    public static void main(String[] args) throws MendozaRaelyn_StackUnderflowException, MendozaRaelyn_StackOverflowException {
        System.out.println("Hello, welcome to the Office Manager Application. Let's begin!\n");

        //list of commands the user can use
        String commands = "Here are a list of commands to use: \n" +
                "'help' - lists the commands for the program. \n" +
                "'quit' - ends the program. \n" +
                "'add' - add an employee to your office. \n" +
                "'remove' - remove an employee from your office. \n" +
                "'contains' - check if an employee is in your office. \n" +
                "'size' - tells you how many employees are in your office. \n" +
                "'inorder' - gives you a list of all current employees. \n";

        System.out.println(commands);

        MendozaRaelyn_BST employeeTree = new MendozaRaelyn_BST();

        try{
            FileInputStream file = new FileInputStream("InputData.txt");
            Scanner in = new Scanner(file);
            String cap = in.nextLine();
            capacity = Integer.parseInt(cap);
            while(in.hasNextLine()){
                String line = in.nextLine();
                String[] details = line.split(",");
                String employeeName = details[0];
                String department = details[1];
                double salary = Double.parseDouble(details[2]);
                MendozaRaelyn_Employee e = new MendozaRaelyn_Employee(employeeName, department, salary);
                employeeTree.add(e);
            }
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        try {
            File output = new File("OutputData.txt");
            FileWriter writer = new FileWriter(output);

            Scanner userIn = new Scanner(System.in);

            String userChoice = "";

            System.out.println();

            while(!"quit".equalsIgnoreCase(userChoice)){
                System.out.print("What would you like do: ");
                userChoice = userIn.next();
                System.out.println();

                if("help".equalsIgnoreCase(userChoice)){
                    System.out.println(commands);
                } else if ("add".equalsIgnoreCase(userChoice)) {
                    System.out.print("What is the employee name: ");
                    String employeeName = userIn.next();

                    System.out.print("What is the department the employee works in: ");
                    String department = userIn.next();

                    System.out.print("What is the employee's salary: ");
                    double salary = userIn.nextDouble();

                    MendozaRaelyn_Employee employee = new MendozaRaelyn_Employee(employeeName, department, salary);
                    writer.write("\nAdding Employee...");
                    boolean successful = employeeTree.add(employee);
                    if (successful){
                        writer.write(employee + " was added.\n");
                        System.out.println(employee + " was added.\n");
                    }else{
                        writer.write(employee + " was not added.\n");
                        System.out.println(employee + " was not added.\n");
                    }
                } else if ("remove".equalsIgnoreCase(userChoice)) {
                    System.out.print("What is the employee name: ");
                    String employeeName = userIn.next();

                    System.out.print("What is the department the employee works in: ");
                    String department = userIn.next();

                    System.out.print("What is the employee's salary: ");
                    double salary = userIn.nextDouble();

                    MendozaRaelyn_Employee employee = new MendozaRaelyn_Employee(employeeName, department, salary);
                    writer.write("\nRemoving Employee...");
                    boolean successful = employeeTree.remove(employee);

                    if (successful){
                        writer.write(employee + " was removed.\n");
                        System.out.println(employee + " was removed.\n");
                    }else{
                        writer.write(employee + " was not removed.\n");
                        System.out.println(employee + " was not removed.\n");
                    }
                }else if ("contains".equalsIgnoreCase(userChoice)){
                    System.out.print("What is the employee name: ");
                    String employeeName = userIn.next();

                    System.out.print("What is the department the employee works in: ");
                    String department = userIn.next();

                    System.out.print("What is the employee's salary: ");
                    double salary = userIn.nextDouble();

                    MendozaRaelyn_Employee e = new MendozaRaelyn_Employee(employeeName, department, salary);
                    writer.write("\nFinding Employee...");

                    boolean successful = employeeTree.contains(e);

                    if(successful == true){
                        writer.write(e.toString() + " was found.\n");
                        System.out.println(e.toString() + " was found.\n");
                    }else{
                        writer.write(e.toString() + " was not found.\n");
                        System.out.println(e.toString() + " was not found.\n");
                    }
                } else if ("size".equalsIgnoreCase(userChoice)) {
                    int size = employeeTree.size();
                    writer.write("\nYour office has " + size + " employees. \n");
                    System.out.println("Your office has " + size + " employees. \n");
                }else if ("inorder".equalsIgnoreCase(userChoice)) {
                    writer.write("\nInorder Traversal:\n");
                    System.out.println("Inorder Traversal:\n");
                    employeeTree.inOrder(writer, capacity);
                }else{
                    if("quit".equalsIgnoreCase(userChoice)){
                        System.out.println("\nQuitting the program now.\n");
                    }else{
                        System.out.println("\nPlease choose an option from the list of commands. If unsure of commands, type 'help'.\n");
                    }
                }
            }
        }catch (IOException e){
            System.out.println("File could not be written.\n");
        }

    }
}
