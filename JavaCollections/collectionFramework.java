import java.util.*;

public class collectionFramework {
    public static void main(String[] args) {
        
        List<Integer> li = new ArrayList<>();

        for(int i = 1; i <= 100; i *= 3)
        {
            li.add(i);
        }

        li.add(9);
        li.add(8);

        System.out.println(li);

        System.out.println("Min : " + Collections.min(li));

        System.out.println("Max : " + Collections.max(li));

        System.out.println("Frequency of 9 : " + Collections.frequency(li, 9));

        Collections.sort(li, Comparator.reverseOrder());

        System.out.println(li);

    }    
}
