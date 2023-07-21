//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 3
//StackADT Class with Generics
public class MendozaRaelyn_StackADTGenerics<T> implements MendozaRaelyn_StackInterfaceGenerics<T> {
    private T[] employeesList; //array of employee objects
    private int index;

    public MendozaRaelyn_StackADTGenerics(int capacity){
        employeesList = (T[]) new Object[capacity];
        index = 0;
    }

    public boolean isEmpty() {
        return (index == 0);
    }

    public boolean isFull() {
        return (index == employeesList.length);
    }

    public void push(T v) throws MendozaRaelyn_StackOverflowException {
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

    public T top() throws MendozaRaelyn_StackUnderflowException {
        if(isEmpty())
        {
            throw new MendozaRaelyn_StackUnderflowException("Top attempted on an empty stack");
        }
        else
        {
            return employeesList[index-1];
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
