package deque;


public interface DequeADT<T> {

    // Similar to Queue enqueue
    public void addLast(T elem);

    public void addFirst(T elem);
    
    public T removeLast();


    // Similar to Queue dequeue
    public T removeFirst();

    public T first();

    public T last();


    public boolean isEmpty();
    public int size();
    public String toString();

}
