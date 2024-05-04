import java.util.*;

public class IthBits {

    public static void ithbit(int n, int k)
    {
        // Using left shift operator
        // return (n & 1 << (k - 1)) != 0;
        
        // Using right shift operator
        boolean ans = ((n >> k) & 1) == 1;

        if(ans)  System.out.println("Ith bit is set");
        else     System.out.println("Ith bit is not set");
    }

    public static void setithbit(int n, int k)
    {
        System.out.println((1 << k - 1) | n);
    }
    
    public static void clearithbit(int n, int k)
    {
        System.out.println(~(1 << k - 1) & n);
    }
    
    
    public static void toggleithbit(int n, int k)
    {
        System.out.println(n ^ (1 << k - 1));
    }

    public static void clearLastSetBitFromRight(int n)
    {
        System.out.println(n & (n - 1));
    }
    
    public static void powerOf2(int n)
    {
        if((n & (n - 1)) == 0)
        {
            System.out.println("N is Power of 2");
        }
        else    System.out.println("N is not Power of 2");
    }

    public static void countSetBits(int n)
    {
        int cnt = 0;

        while(n != 1)
        {
            cnt += (n & 1);
            n = n >> 1;
            // System.out.println(cnt);
        }

        if(n == 1)  cnt++;

        System.out.println("Number of set bits : " + cnt);
    }
    
    public static void countSetBits2(int n)
    {
        int cnt = 0;

        while(n != 0)
        {
            n = n & (n-1);
            cnt++;
        }

        System.out.println("Number of set bits : " + cnt);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter x and k");

        int x = sc.nextInt();
        // int k = sc.nextInt();

        countSetBits2(x);
        
        sc.close();   
    }
}
