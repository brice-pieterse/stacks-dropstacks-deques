package utils;

// A data type used for maintaining references in linked structures

public class LinearNode<T>{

    private LinearNode<T> next;
    private LinearNode<T> prev;
    private T element;
    
    public LinearNode(){
        next = null;
        prev = null;
        element = null;
    }
    
    public LinearNode(T elem){
        next = null;
        prev = null;
        element = elem;
    }
    
    public LinearNode<T> getNext(){
        return next;
    }

    public LinearNode<T> getPrev(){
        return prev;
    }
    
    public void setNext(LinearNode<T> node){
        next = node;
    }

    public void setPrev(LinearNode<T> node){
        prev = node;
    }

    public T getElem(){
        return element;
    }
    
}