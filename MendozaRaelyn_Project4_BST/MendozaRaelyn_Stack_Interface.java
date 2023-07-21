//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 4
//MendozaRaelyn_Stack_Interface Class with Generics
public interface MendozaRaelyn_Stack_Interface<T>{
    boolean isEmpty();   //check if stack is empty
    boolean isFull();    //check if stack is full
    void push(T element) throws MendozaRaelyn_StackOverflowException;    //push a value onto the stack
    String pop() throws MendozaRaelyn_StackUnderflowException;  //remove and return the element at the top of the stack
    T top() throws MendozaRaelyn_StackUnderflowException;  //return the top element at the top of the stack

    String list();   //returns a string representation of the stack
}
