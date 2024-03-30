import java.util.*;

/*
 * METHODS DISCUSSED:
 * Stack<Integer> st = new Stack<>();
 * 
 * st.push()
 * st.pop()
 * st.peek()
 * st.isEmpty()
 * st.size()
 * st.search()
 */

public class stack {
    
    public static void main(String[] args) {
     
        Stack<String> st = new Stack<>();

        st.push("One");
        st.push("Two");
        st.push("Three");
        st.push("Four");
        st.push("Five");

        System.out.println(st.peek());

        // Iterating in the Stack.
        for(String s : st)
        {
            System.out.print(s + "   ");
        }
        System.out.println();
        
        // Using Iterator to traverse in the stack.
        Iterator<String> it = st.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        System.out.println();
        System.out.println("One-based position for Two is " + st.search("Two"));
        
        int n = st.size();

        for(int i = 0; i < n; i++)
        {
            System.out.println(st.pop() + " Popped " + (i + 1) + ".");
        }

        if(st.isEmpty())    System.out.println("Stack is Empty.");
        else    System.out.println("Stack is not Empty.");

    }
}
