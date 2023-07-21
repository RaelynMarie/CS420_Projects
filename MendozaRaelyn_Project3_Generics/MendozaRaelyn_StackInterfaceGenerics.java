//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 3
//StackADT Interface with Generics
public interface MendozaRaelyn_StackInterfaceGenerics<T> {
    boolean isEmpty();   //check if stack is empty
    boolean isFull();    //check if stack is full
    void push(T element) throws MendozaRaelyn_StackOverflowException;    //push a value onto the stack
    String pop() throws MendozaRaelyn_StackUnderflowException;  //remove and return the element at the top of the stack
    T top() throws MendozaRaelyn_StackUnderflowException;  //return the top element at the top of the stack

    String list();   //returns a string representation of the stack
}
