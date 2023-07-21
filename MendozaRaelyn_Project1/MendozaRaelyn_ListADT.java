//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 1
//ListADT Class

public class MendozaRaelyn_ListADT<M> {
  private MendozaRaelyn_Employee[] employeesList; //array of employee objects
  private int index;
  private int numberOfEmployees;

  public MendozaRaelyn_ListADT(int cap)
  {
    employeesList = new MendozaRaelyn_Employee[cap];
    index = 0;
  }

  //returns size of array
  public int size(){
    return numberOfEmployees;
  }

  //checks if array is full
  public boolean isFull(){
    return (index == employeesList.length);
  }

  //checks if the array is empty
  public boolean isEmpty(){
    return(numberOfEmployees == 0);
  }

  //add an employee object to the list
  public void add(MendozaRaelyn_Employee employee)
  {
    if (!isFull()) {
      employeesList[index] = employee;
      index++;
      numberOfEmployees++;
      System.out.println(employee.getEmployeeName() + " was successfully added to your office. \n");
    }else{
      System.out.println("Your office is full. We will upgrade the size of your office and add your new employee.");

      //this creates a new array with increased size by 1
      MendozaRaelyn_Employee[] tempArray = new MendozaRaelyn_Employee[employeesList.length+1];

      // Copy the already elements to the new array
      System.arraycopy(employeesList, 0, tempArray, 0, numberOfEmployees);
      employeesList = tempArray;

      //then add the new employee
      employeesList[index] = employee;
      index++;
      numberOfEmployees++;
      System.out.println(employee.getEmployeeName() + " was successfully added to your office. \n");
    }
  }

  //finds an employee by name in the list of employee objects
  public int find(String empName){
    int empIndex = -1;
    for(int i = 0; i < numberOfEmployees; i++){
      if(employeesList[i].getEmployeeName().equalsIgnoreCase( empName)){
        empIndex = i;
      }
    }
    return empIndex;
  }

  //removes an employee by name from the list of employee objects
  public void remove(String empName){
    if (isEmpty()) {
      System.out.println("There are no employees in your office to remove. \n");
    } else {
      int i = find(empName);
      if (i == -1) {
        System.out.println("That employee does not work in your office. \n");
      } else {
        // Shift elements to the left starting from index i+1
        for (int j = i + 1; j < numberOfEmployees; j++) {
          employeesList[j - 1] = employeesList[j];
        }
        numberOfEmployees--;

        //this creates a new array with smaller size
        MendozaRaelyn_Employee[] tempArray = new MendozaRaelyn_Employee[numberOfEmployees];

        // Copy the remaining elements to the new array
        System.arraycopy(employeesList, 0, tempArray, 0, numberOfEmployees);
        employeesList = tempArray;

        System.out.println(empName + " was successfully removed from your office. \n");
      }
    }
  }

  public MendozaRaelyn_Employee get(int i){
    return employeesList[i];
  }

  public void list(){
    System.out.println("Here is a list of your employees: ");
    for(int i = 0; i < employeesList.length; i++){
      System.out.println(employeesList[i].toString());
    }

  }
}
