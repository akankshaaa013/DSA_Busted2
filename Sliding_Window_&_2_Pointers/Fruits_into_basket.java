import java.util.Arrays;
import java.util.Scanner;

public class Fruits_into_basket {

    /*
     * BRUTE APPROACH:
     * Try all possible combinations where no. of unique trees is only 2.
     * Time Complexity: O(n*n)
     * Space Complexity: O(n)
     */
    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int n = fruits.length;

        for(int l = 0; l < n; l++)
        {
            int[] hash = new int[n];
            int cnt = 0;

            for(int r = l; r < n; r++)
            {
                if(hash[fruits[r]] == 0)    cnt++;

                if(cnt > 2)     break;

                hash[fruits[r]]++;

                maxFruits = Math.max(maxFruits, r-l+1);
            }
        }
        return maxFruits;
    }

    /*
     * BETTER APPROACH USING SLIDING WINDOW AND 2 POINTERS
     * Pick 1 fruits each from tree (but there will only be 2 types of tree). If tree type exceeds drop the previous fruits of 
     * one type of tree and then pick the next ones.
     * Time Complexity : O(n + n)
     * Space Complexity : O(n)
     */
    public static int totalFruit2(int[] fruits) {
        
        int maxFruits = 0, cnt = 0;
        int n = fruits.length;

        int[] hash = new int[n];
        Arrays.fill(hash, 0);

        for(int l = 0, r = 0; r < n; r++)
        {
            if(hash[fruits[r]] == 0)    cnt++;

            while(cnt > 2)
            {
                hash[fruits[l]]--;
                if(hash[fruits[l]] == 0)    cnt--;
                l++;
            }
            maxFruits = Math.max(maxFruits, r-l+1);
            hash[fruits[r]]++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Maximum number of fruits you can pick are : " + totalFruit2(arr));

        sc.close();

    }
    
}
