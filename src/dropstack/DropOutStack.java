package dropstack;

// Author: Brice Pieterse
// A linked implementation of a fixed size stack. Elements at the bottom of the stack drop off as new elements join the already full stack.

import java.util.Arrays;

import utils.EmptyCollectionException;
import utils.LinearNode;
import utils.StackADT;

public class DropOutStack<T> implements StackADT<T> {

    static private int DEFAULT_MAX_CAPACITY = 10; 
    private int maxCapacity;
    private int count = 0;

    private LinearNode<T> head = null;

    // variable pointing to the last element so we can easily remove it
    private LinearNode<T> tail = null;


    public DropOutStack(int capacity){
        if (capacity < 1){
            maxCapacity = 1;
        } 
        else {
            maxCapacity = capacity;
        }
    }

    public DropOutStack(){
        this(DEFAULT_MAX_CAPACITY);
    }


    // pushes a new element to the stack, removes old element links to make room for new ones
    // updates our second to last reference
    public void push(T elem){

        // stack is full, remove the bottom element
        if(count == maxCapacity){
            // removes the bottom element
            tail = tail.getPrev();
            tail.setNext(null);
            count--;
        }

        if(count == 0){
            head = new LinearNode<T>(elem);
            tail = head;
        }
        else {
            LinearNode<T> temp = head;
            head = new LinearNode<T>(elem);
            head.setNext(temp);
            temp.setPrev(head);
        }

        count++;
    }



    // returns the top element on the stack and updates our top reference
    public T pop() throws EmptyCollectionException {
        if(count == 0){
            throw new EmptyCollectionException("Drop out stack");
        }

        LinearNode<T> temp = head;
        head = temp.getNext();

        if(head != null){
            head.setPrev(null);
        }

        if (count == 1){
            tail = head;
        }

        count--;

        return temp.getElem();
    }



    public T peek(){
        return head.getElem();
    }

    
    public int size(){
        return count;
    }


    public boolean isEmpty(){
        return count == 0 ? true : false;
    }


    @SuppressWarnings("unchecked")
    // returns a string representation of the stack in array form, with index 0 being the top of the stack
    public String toString(){
        T[] arr = (T[]) new Object[count];
        LinearNode<T> current = head;
        int index = 0;

        while(current != null){
            arr[index] = current.getElem();
            current = current.getNext();
            index++;
        }

        return Arrays.toString(arr);
    }

}
