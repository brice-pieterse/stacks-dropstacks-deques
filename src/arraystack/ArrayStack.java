package arraystack;

// Author: Brice Pieterse

// An implementation of ArrayStack where top is the current index of the top element on the stack, not the next available index on the stack

// This implementation does not decrease capacity if it has expanded to allow space for more elements, before popping those additional elements off the stack. The extra capacity will remain even if no longer needed.

import java.util.Arrays;

import utils.EmptyCollectionException;
import utils.StackADT;

public class ArrayStack<T> implements StackADT<T> {

    private T[] stack;
    // the current index of the top element in the stack
    private Integer top = null;
    private static int DEFAULT_CAPACITY = 100;

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity){
        stack = (T[]) new Object[initialCapacity];
    }

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }


    public void push(T element){
        int index;
        if (size() == stack.length){
            expandCapacity();
        }
        index = (top != null ? top.intValue() + 1 : 0);
        stack[index] = element;
        top = index;
    }


    public T pop() throws EmptyCollectionException {
        if(top != null){
            T temp = stack[top];
            stack[top] = null;
            if(top > 0)
                top--;
            else top = null;
            return temp;
        }
        else throw new EmptyCollectionException("ArrayStack");
    }


    public T peek() throws EmptyCollectionException {
        if(top != null){
            return stack[top];
        }
        else throw new EmptyCollectionException("ArrayStack");
    }


    public int size(){
        return top != null ? top.intValue() + 1 : 0;
    }


    public boolean isEmpty(){
        return top == null ? true : false;
    }


    public String toString(){
        return Arrays.toString(stack);
    }


    private void expandCapacity(){
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

}