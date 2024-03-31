import java.util.*;

/*
 * 
 * PriorityQueue<Integer> pq = new PriorityQueue<>();
 * 
 * to reverse order pass Comparator.reverseOrder() to constructor.
 * 
 * METHODS DISCUSSED :
 * 
 * pq.offer()
 * pq.poll()
 * pq.peek()
 * pq.isEmpty()
 * pq.clear()
 * 
 */
public class priorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.offer(10);
        pq.offer(15);
        pq.offer(20);
        pq.offer(5);

        System.out.println(pq);

        System.out.println(pq.poll());

        System.out.println(pq.peek());
    }
    
}
