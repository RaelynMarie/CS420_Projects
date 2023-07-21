//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 2
//StackADT Class
public class MendozaRaelyn_StackADT implements MendozaRaelyn_StackInterface {
    private MendozaRaelyn_Employee[] employeesList; //array of employee objects
    private int index;

    public MendozaRaelyn_StackADT(int capacity){
        employeesList = new MendozaRaelyn_Employee[capacity];
        index = 0;
    }

    public boolean isEmpty() {
        return (index == 0);
    }

    public boolean isFull() {
        return (index == employeesList.length);
    }

    public void push(MendozaRaelyn_Employee v) throws MendozaRaelyn_StackOverflowException {
        if(isFull())
        {
            throw new MendozaRaelyn_StackOverflowException("Push attempted on a full stack");
        }
        else
        {
            employeesList[index] = v;
            index++;
        }
    }

    public String pop() throws MendozaRaelyn_StackUnderflowException {
        if(isEmpty())
        {
            throw new MendozaRaelyn_StackUnderflowException("Pop attempted on an empty stack");
        }
        else
        {
            String popped = employeesList[index-1].toString();
            employeesList[index-1] = null;
            index--;
            return popped;
        }
    }

    public String top() throws MendozaRaelyn_StackUnderflowException {
        if(isEmpty())
        {
            throw new MendozaRaelyn_StackUnderflowException("Top attempted on an empty stack");
        }
        else
        {
            return employeesList[index-1].toString();
        }
    }

    public int size() {
        return index;
    }

    public String list()
    {
        if(isEmpty()){
            return "Your office does not currently have any employees.\n";
        }else{
            String stackContent = "The content of the stack from the top to bottom is\n";

            for(int i = index - 1; i >= 0; i--)
            {
                stackContent += employeesList[i] + "\n";

            }
            return stackContent;
        }

    }
}
