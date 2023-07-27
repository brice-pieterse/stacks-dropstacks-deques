package arraystack;

import utils.EmptyCollectionException;

// Author: Brice Pieterse
// Driver class for testing the arraystack class

public class ArrayStackDriver {
    public static void main(String[] args){
        ArrayStack<String> arrayS = new ArrayStack<String>(2);

        String base = "a";

        arrayS.push(copyString(base, 1));
        arrayS.push(copyString(base, 2));
        arrayS.push(copyString(base, 3)); // array stack will expand capacity now
        arrayS.push(copyString(base, 4)); // array stack will expand capacity now

        System.out.println(arrayS.toString()); // a, aa, aaa, aaaa

        // uses the new implementation of top
        System.out.println(arrayS.peek()); // aaaa -> element referenced by the 'top' index in ArrayStack

        arrayS.pop();

        // uses the new implementation of top
        System.out.println(arrayS.peek()); // aaa -> element referenced by the 'top' index in ArrayStack

        System.out.println(arrayS.size()); // 3

        arrayS.pop();
        arrayS.pop();
        arrayS.pop();

        // uses the new implementation of top
        System.out.println(arrayS.size()); // 0

        try {
            arrayS.pop();
        }
        catch(EmptyCollectionException e){
            System.out.println("Is Empty? " + arrayS.isEmpty());
            System.out.println(e.getMessage());
        }

        arrayS.push("That's all");
        arrayS.push("folks!");

        System.out.println(arrayS.size()); // 2

        System.out.println(arrayS.toString());
    }

    
    private static String copyString(String copy, int times){
        String s = "";
        int index = 0;
        while (index < times){
            s += copy;
            index++;
        }
        return s;
    }

}