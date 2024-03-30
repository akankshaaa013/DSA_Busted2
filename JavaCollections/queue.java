import java.util.*;

/*
 * METHODS DISCUSSED BELOW:
 * 
 * Queue<Integer> q = new LinkedList<>();
 * 
 * q.offer()
 * q.poll()
 * q.isEmpty()
 * q.size()
 * q.peek()
 * q.element()
 * q.clear()
 */

public class queue {

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(12);
        q.offer(24);
        q.offer(36);
        q.offer(48);
        q.offer(60);
        q.offer(72);

        System.out.println(q);
        
        System.out.println(q.poll());

        System.out.println(q.peek());
        
        try{
            // Returns the head of the queue if it is not empty.
            System.out.println(q.element());
        }
        catch(Exception e)
        {
            System.err.println("Queue is Empty");
        }

        if(q.isEmpty())     System.out.println("Queue is Empty");
        else    System.out.println("Queue is not Empty");

        Iterator<Integer> it = q.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        q.clear();
    }
}
