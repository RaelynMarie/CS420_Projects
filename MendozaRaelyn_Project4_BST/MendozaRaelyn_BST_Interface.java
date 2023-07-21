//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 4
//MendozaRaelyn_BST Interface

import java.io.FileWriter;
import java.io.IOException;
public interface MendozaRaelyn_BST_Interface<T> {
    boolean isFull();
    boolean isEmpty();
    int size();
    boolean contains(T target);

    boolean add(T v);

    boolean remove(T v) throws MendozaRaelyn_StackUnderflowException;

    void inOrder(FileWriter writer, int capacity) throws MendozaRaelyn_StackOverflowException, MendozaRaelyn_StackUnderflowException, IOException;
}
