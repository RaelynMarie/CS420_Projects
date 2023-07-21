//Raelyn Mendoza
//CS 420 - Object-Oriented Design
//Project 4
//MendozaRaelyn_BST Node Class with Generics
public class MendozaRaelyn_BST_Node_Class<T> {

    //instance variables
    private T info; //the info in a bst node
    private MendozaRaelyn_BST_Node_Class<T> left; //link to left child
    private MendozaRaelyn_BST_Node_Class<T> right; //link to right child

    //constructor
     public MendozaRaelyn_BST_Node_Class(T info){
         this.info = info;
         left = null;
         right = null;
     }

     //getters and setters

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public MendozaRaelyn_BST_Node_Class<T> getLeft() {
        return left;
    }

    public void setLeft(MendozaRaelyn_BST_Node_Class<T> left) {
        this.left = left;
    }

    public MendozaRaelyn_BST_Node_Class<T> getRight() {
        return right;
    }

    public void setRight(MendozaRaelyn_BST_Node_Class<T> right) {
        this.right = right;
    }
}
