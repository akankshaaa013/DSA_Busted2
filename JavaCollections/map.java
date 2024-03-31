import java.util.*;

/*
 * TreeMap --> Keys are accessed in the sorted order.
 * 
 * Map<String, Integer> mpp = new HashMap<>();
 *  
 * METHODS DISCUSSED BELOW:
 * 
 * mpp.put()
 * mpp.putIfAbsent()
 * mpp.put(x, mpp.getOrDefault(x, ...))
 * 
 * mpp.get()
 * mpp.containsKey()
 * mpp.containsValue()
 * 
 * mpp.size()
 * mpp.keySet()     // Iterate in the key set
 * mpp.values()     // Iterate in the values
 * 
 * for(Map.Entry<String, Integer> e : mpp.entrySet())   {}
 * 
 * mpp.remove()
 * mpp.isEmpty()
 * mpp.clear()
 */

public class map {
    public static void main(String[] args) {
        
        Map<String, Integer> mpp = new TreeMap<>();

        mpp.put("One",1);
        mpp.put("Two",2);
        mpp.put("Three",3);
        mpp.put("Four",4);

        mpp.put("Five", mpp.getOrDefault("Five", 5)); 
        mpp.put("Six", mpp.getOrDefault("Six", 6));
        
        System.out.println(mpp.get("Five"));
        
        System.out.println("Size of map : " + mpp.size());
        
        if(mpp.containsKey("Three"))    System.out.println("3 is present.");
        else    System.out.println("Absent");
        
        mpp.putIfAbsent("Thirty-Three", 33);

        if(mpp.containsValue(35))   System.out.println("35 is present.");
        else    System.out.println("Absent");

        mpp.remove("Three");
        
        System.out.println(mpp);
        System.out.println();

        //* Iterating in the whole map.
        for(Map.Entry<String, Integer> e : mpp.entrySet())
        {
            System.out.println(e);

            // System.out.println(e.getKey());
            // System.out.println(e.getValue());
        }

        //* Iterating in the keys of the map.
        for(String key : mpp.keySet())
        {
            // Prints all the keys.
            System.out.println(key);
        }
        
        //* Iterating in the values of the map.
        for(Integer x : mpp.values())
        {
            // prints all the values
            System.out.println(x);
        }
    }
}
