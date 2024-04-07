import java.util.Scanner;
import java.util.*;

public class Number_of_subarray_with_K_distinct_counts {

    public static int solve(int[] nums, int k)
    {
        Map<Integer, Integer> mpp = new HashMap<>();
        int cnt = 0;

        for(int left = 0, right = 0; right < nums.length; right++)
        {
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);

            while(mpp.size() > k)
            {
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                if(mpp.get(nums[left]) == 0)    mpp.remove(nums[left]);
                left++;
            }

            cnt += (right - left + 1);
        }
        return cnt;
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();

        System.out.println("Number of subarrays with K different integers are : " + subarraysWithKDistinct(arr, k));

        sc.close();
    }
}
