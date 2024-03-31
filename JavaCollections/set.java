import java.util.*;

/*
 * 
 * HashSet --> Implements Set (Order of insertion of objects is not maintained.) All operations are performed in O(1)
 * LinkedHashSet --> Implements Set and LinkedList (Order of insertion of objects is maintained.)
 * 
 * TreeSet --> Implements Set(Order of Objects is Sorted.) All operations are performed in O(log n).
 * 
 */

public class set {
    public static void main(String[] args) {

        Set<Integer> st = new TreeSet<>();

        st.add(34);
        st.add(98);
        st.add(45);
        st.add(12);
        st.add(62);
        st.add(98);
        st.add(45);

        // [34, 98, 12, 45, 62]
        System.out.println(st);
        
        st.remove(98);
        
        System.out.println(st);

        if(st.contains(65))     System.out.println("65 is Present");
        else    System.out.println("65 is not present.");

        if(st.isEmpty())    System.out.println("Set is Empty");

        int n = st.size();

        st.clear();
                
    }  
}
