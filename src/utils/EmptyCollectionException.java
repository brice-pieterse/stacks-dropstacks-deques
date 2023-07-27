package utils;

// An exception that can be thrown when we try to access or perform operations on an empty collection

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException (String collection){
        super("The " + collection + " is empty");
    } 
}
