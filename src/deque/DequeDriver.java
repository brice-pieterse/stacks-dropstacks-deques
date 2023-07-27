package deque;

import utils.EmptyCollectionException;

// Author: Brice Pieterse
// Driver class for testing the double ended queue

public class DequeDriver {
    public static void main(String[] args){
        Deque<String> deque = new Deque<String>();

        String base = "a";

        deque.addFirst(copyString(base, 1)); // a
        deque.addFirst(copyString(base, 2)); // aa, a
        deque.addLast(copyString(base, 3)); // aa, a, aaa
        deque.addLast(copyString(base, 4)); // aa, a, aaa, aaaa
        deque.addFirst(copyString(base, 5)); // aaaaa, aa, a, aaa, aaaa

        System.out.println(deque.toString());
        System.out.println(deque.size()); // 5
        System.out.println(deque.first()); // aaaaa
        System.out.println(deque.last()); // aaaa

        deque.removeFirst(); // aa, a, aaa, aaaa
        deque.removeLast(); // aa, a, aaa

        System.out.println(deque.toString()); // aa, a, aaa
        System.out.println(deque.size()); // 3
        System.out.println(deque.first()); // aa
        System.out.println(deque.last()); // aaa

        deque.removeLast(); // aa, a
        deque.removeLast(); // aa

        System.out.println(deque.toString()); // aa
        System.out.println(deque.size()); // 1
        System.out.println(deque.first()); // aa
        System.out.println(deque.last()); // aa

        deque.removeLast();

        try {
            deque.removeFirst();
        }
        catch(EmptyCollectionException e){
            System.out.println(e.getMessage()); // empty
        }
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
