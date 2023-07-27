package dropstack;

// Author: Brice Pieterse
// Driver class for testing the drop out stack

import utils.EmptyCollectionException;

public class DropOutStackDriver {
    public static void main(String[] args){
        DropOutStack<String> dStack = new DropOutStack<String>(5);

        dStack.push("Brice");
        dStack.push("Sam");
        dStack.push("Nicole");
        dStack.push("Tom");
        dStack.push("Todd");

        System.out.println(dStack.toString()); // Todd, Tom, Nicole, Sam, Brice

        // drop out stack will begin dropping elements now
        dStack.push("Amanda");
        dStack.push("Max");

        System.out.println(dStack.toString()); // Max, Amanda, Todd, Tom, Nicole

        dStack.pop();
        dStack.pop();
        dStack.pop();
        dStack.pop();
        dStack.pop();

        try {
            dStack.pop();
        }
        catch(EmptyCollectionException e){
            System.out.println("Empty: " + e.getMessage()); // empty
        }
    }
}
