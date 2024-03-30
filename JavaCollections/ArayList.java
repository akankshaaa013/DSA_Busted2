import java.util.*;

/*
 * METHODS DISCUSSED : 
 * 
 * List<Integer> li = new ArrayList<>();
 * 
 * li.add()
 * li.addAll()
 * li.clear()
 * li.get()
 * li.contains()
 * li.set()
 * li.size()
 * li.remove()
 * 
 * Iterator<Integer> it = li.iterator();
 * 
 */

public class ArayList {

    public static void main(String[] args) {

        // ArrayList of Integers.
        List<Integer> arr = new ArrayList<>();

        // Appends an element to the end of the list.
        arr.add(10);
        arr.add(20);

        for(int i = 30; i <= 50; i += 10)
        {
            arr.add(i);
        }

        // Appends an element to the specific index position.
        arr.add(3,60);

        List<Integer> newList = new ArrayList<>();
        
        newList.add(100);
        newList.add(110);
        newList.add(120);
        
        // Appends all the elements of newList into arr.
        arr.addAll(newList);
        
        System.out.println(arr);
        
        // get an element at the partiular index.
        System.out.println(arr.get(7));
        
        // Delete the element at index 3
        arr.remove(3);
        
        // Delete the element 100.
        arr.remove(Integer.valueOf(100));
        
        System.out.println(arr);
        
        // Deletes all the elements of the list
        newList.clear();
        
        // Changes the element at the particular position in the list.
        arr.set(3, 1000);
        
        System.out.println(arr);
        
        if(arr.contains(150) == true)    System.out.println("150 is present");
        else    System.out.println("150 is not present");


        // Calculates the size of the ArrayList.
        int n = arr.size();
        
        // Different ways to traverse in a ArrayList.

        // 1) foreach loop.
        for(int i : arr)
        {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 2) Using regular loop.
        for(int i = 0; i < n; i++)
        {
            arr.set(i, arr.get(i) + 20);
        }

        // 3) Using ITERATOR
        Iterator<Integer> it = arr.iterator();

        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

    }
}
