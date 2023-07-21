//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 4
//Binary Search Tree class

import java.io.FileWriter;
import java.io.IOException;

public class MendozaRaelyn_BST<T extends MendozaRaelyn_Employee> implements MendozaRaelyn_BST_Interface<T> {
    private MendozaRaelyn_BST_Node_Class<T> root; //reference to root of the tree
    private boolean found; //used by remove

    public MendozaRaelyn_BST(){
        root = null;
        //this.comp = comp;
    }

    @Override
    public boolean isFull(){
        return false; //link based adt never full
    }

    @Override
    public boolean isEmpty(){
        //return true if MendozaRaelyn_BST is empty
        return root==null;
    }

    @Override
    public int size(){
        //returns the number of elements in the MendozaRaelyn_BST
        return sizeRec(root);
    }

    public int sizeRec(MendozaRaelyn_BST_Node_Class<T> node){
        if(node == null){
            return 0;
        }else{
            return 1+ sizeRec(node.getLeft()) + sizeRec(node.getRight());
        }
    }

    @Override
    public boolean contains(T target){
        //return true if bst contains a node with info i such that comp.compare(target, i) == 0
        //else false
        return containsRec(target, root);
    }

    public boolean containsRec(T target, MendozaRaelyn_BST_Node_Class<T> node){
        if(node==null){
            return false; //target not found
        } else if (target.getSalary() < node.getInfo().getSalary()) {
            return containsRec(target, node.getLeft()); //search left subtree
        } else if (target.getSalary() > node.getInfo().getSalary()) {
            return containsRec(target, node.getRight()); //search right subtree
        }else if (target.getEmployeeName().equalsIgnoreCase(node.getInfo().getEmployeeName())  && target.getDepartment().equalsIgnoreCase(node.getInfo().getDepartment()) ){
            return true; //target is found
        }else{
            return false; //target not found
        }
    }

    @Override
    public boolean add(T v){
        //add element to bst
        root = addRec(v, root);
        return true;
    }

    public MendozaRaelyn_BST_Node_Class<T> addRec(T v, MendozaRaelyn_BST_Node_Class<T> node){
        //add element to bst
        if(node == null){
            //add in place
            node = new MendozaRaelyn_BST_Node_Class<T>(v);
        } else if (v.getSalary() < node.getInfo().getSalary()){
            node.setLeft(addRec(v, node.getLeft())); //add in left subtree
        }else {
            node.setRight(addRec(v, node.getRight())); //add in right subtree
        }
        return node;
    }

    @Override
    public boolean remove(T v) throws MendozaRaelyn_StackUnderflowException {
        root = removeRec(v, root);
        return found;
    }

    public MendozaRaelyn_BST_Node_Class<T> removeRec(T v, MendozaRaelyn_BST_Node_Class<T> node){
        //remove node from bst
        if(node == null){
            found = false;
        } else if (node.getInfo().getSalary() > v.getSalary()) {
            node.setLeft(removeRec(v, node.getLeft())); //search left subtree
        } else if (node.getInfo().getSalary() < v.getSalary()) {
            node.setRight(removeRec(v, node.getRight())); //search right subtree
        }else {
            node = removeNode(node);
            found = true;
        }
        return node;
    }

    public MendozaRaelyn_BST_Node_Class<T> removeNode(MendozaRaelyn_BST_Node_Class<T> node){
        if(node.getLeft() == null && node.getRight() == null){
            return null;
        } else if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        }else{
            T predecessor = getPredecessor(node);
            node.setInfo(predecessor);
            node.setLeft(removeRec(predecessor, node.getLeft()));
        }
        return node;
    }

    private T getPredecessor(MendozaRaelyn_BST_Node_Class<T> subtree){
        //return the info held in the rightmost node of subtree
        MendozaRaelyn_BST_Node_Class<T> temp = subtree;
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp.getInfo();
    }

    @Override
    public void inOrder(FileWriter writer, int capacity) throws MendozaRaelyn_StackOverflowException, MendozaRaelyn_StackUnderflowException, IOException{
        MendozaRaelyn_StackADT<T> s = new MendozaRaelyn_StackADT<>(capacity);
        inOrderRec(root, s);
        if(s.isEmpty()){
            String empty = "Your office has no employees.";
            writer.write(empty + "\n");
        }
        while(!s.isEmpty()){
            String emp = s.pop();
            System.out.println(emp);
            writer.write(emp + "\n");
        }
        writer.flush();
    };


    private void inOrderRec(MendozaRaelyn_BST_Node_Class<T> node, MendozaRaelyn_StackADT<T> s) throws MendozaRaelyn_StackOverflowException {
        //push the elements from the subtree rooted at node into s in inOrder
        if(node != null){
            inOrderRec(node.getLeft(), s);
            s.push(node.getInfo());
            inOrderRec(node.getRight(), s);
        }
    }
}