import java.util.*;

public class Swap2Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter x and y : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("Before Swapping : ");
        System.out.println("a : " + x);
        System.out.println("b : " + y);
        
        x ^= y;
        y ^= x;
        x ^= y;
        
        System.out.println("After Swapping : ");
        System.out.println("a : " + x);
        System.out.println("b : " + y);
        sc.close();
    }
}
