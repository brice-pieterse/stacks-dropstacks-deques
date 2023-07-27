package utils;

// An abstract data type representing a stack

public interface StackADT<T> {
    public void push(T element);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public int size();
    public String toString();
}