import java.util.*;

/*
 * ArrayDeque<Integer> dq = new ArrayDeque<>();
 *
 * METHODS DISCUSSED:
 * 
 * offer()
 * offerFirst()
 * offerLast()
 * 
 * peek()
 * peekFirst()
 * peekLast()
 * 
 * poll()
 * pollFirst()
 * pollLast()
 * 
 * isEmpty()
 * size()
 */

public class deque {
    public static void main(String[] args) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // Adds the element to the rear end of the queue.
        dq.offer(20);
        
        // Adds the element to the first end of the queue.
        dq.offerFirst(100);
        dq.offerFirst(400);
        
        // Adds the element to the last end of the queue.
        dq.offerLast(1000);
        dq.offerLast(4999);

        // Peeks the first element from the front end of the queue.
        System.out.println(dq.peekFirst());
        
        // Peeks the last element from the rear end of the queue.
        System.out.println(dq.peekLast());

        System.out.println();

        // Removes the 1st element from the front end.
        System.out.println(dq.poll());

        // Removes the 1st element from the front end.
        System.out.println(dq.pollFirst());
        
        // Removes the last element from the rear end.
        System.out.println(dq.pollLast());  
    }
}
