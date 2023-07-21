//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 1
//Employee Object Class


public class MendozaRaelyn_Employee {
    //instance variables
    private String employeeName;
    private String department;

    private double salary;

    //constructor for the object
    public MendozaRaelyn_Employee(String employeeName, String department, double salary){
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    //getters
    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    //setters
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return ("\nName: " + this.getEmployeeName() + " \nDepartment: " + getDepartment() + " \nSalary: " + getSalary() + "\n");
    }
}
