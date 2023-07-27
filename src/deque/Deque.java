package deque;
import java.util.Arrays;
import utils.EmptyCollectionException;
import utils.LinearNode;

// Author: Brice Pieterse
// Linked implementation of a double ended queue

public class Deque<T> implements DequeADT<T> {

    LinearNode<T> head;
    LinearNode<T> tail;
    int count;
    

    public Deque(){
        head = null;
        tail = null;
        count = 0;
    }


    // adds to the front of the queue
    // if no tail exist, inits both tail and head to be the same element
    public void addFirst(T elem){
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


    // adds to the rear of the queue
    // if no tail exist, inits both tail and head to be the same element
    public void addLast(T elem){
        // we have no elements, add a head first
        if(count == 0){
            head = new LinearNode<T>(elem);
            tail = head;
        } 
        else {
            LinearNode<T> temp = new LinearNode<T>(elem);
            tail.setNext(temp);
            temp.setPrev(tail);
            tail = temp;
        }

        count++;
    }


    // removes an element from the front of the queue
    // if head == tail, removes both
    public T removeFirst() throws EmptyCollectionException {
        LinearNode<T> removed;
        if(count == 0){
            throw new EmptyCollectionException("Deque");
        }
        removed = head;
        head = head.getNext();

        if(head != null){
            head.setPrev(null);
        }

        if (count == 1){
            tail = head;
        }

        count--;

        return removed.getElem();
    }


    // removes an element from the rear of the queue
    // if head == tail, removes both
    public T removeLast() throws EmptyCollectionException {
        LinearNode<T> removed;
        if(count == 0){
            throw new EmptyCollectionException("Deque");
        }
        removed = tail;
        tail = tail.getPrev();

        if(tail != null){
            tail.setNext(null);
        }

        if (count == 1){
            tail = head;
        }

        count--;

        return removed.getElem();
    }


    // shows the element at the front of the queue
    public T first() throws EmptyCollectionException {
        if(count == 0){
            throw new EmptyCollectionException("Deque");
        } 
        else return head.getElem();  
    }


    // shows the element at the rear of the queue
    public T last() throws EmptyCollectionException {
        if(count == 0){
            throw new EmptyCollectionException("Deque");
        } 
        else return tail.getElem();  
    }


    public int size(){
        return count;
    }


    public boolean isEmpty(){
        if(count > 0){
            return false;
        }
        return true;
    }


    @SuppressWarnings("unchecked")
    public String toString(){
        T[] arr = (T[]) new Object[count];

        LinearNode<T> current = head;
        int index = 0;

        while(current != null){
            arr[index] = current.getElem();
            //System.out.println(current.getElem());
            current = current.getNext();
            index++;
        }

        return Arrays.toString(arr);
    }

}
