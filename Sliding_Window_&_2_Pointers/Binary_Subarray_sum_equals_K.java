import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Binary_Subarray_sum_equals_K {

    // BRUTE -> Time Complexity : O(n*n)
    public static int subarraySum2(int[] nums, int k) {
        
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                cnt++;
            }
        }
        return cnt;
    }
    
    // OPTIMAL -> Time Complexity : O(n) Using Sliding Window & Prefix sum technique.
    public static int subarraySum(int[] nums, int k) {

        int cnt = 0, sum = 0;

        Map<Integer, Integer> mpp = new HashMap<>();

        mpp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int preSum = sum - k;

            if (mpp.containsKey(preSum)) {
                cnt += mpp.get(preSum);
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
    
    // MOST OPTIMAL SOLUTION : Time Complexity : O(2n)
    // Space Complexity : O(1).

    public static int solve(int[] nums, int goal)
    {
        int n = nums.length, cnt = 0, sum = 0;

        if(goal < 0)    return 0;

        for(int left = 0, right = 0; right < n; right++)
        {
            sum += nums[right];

            while(sum > goal)
            {
                sum -= nums[left];
                left++;
            }

            cnt += (right - left + 1);
        }
        return cnt;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        return solve(nums, goal) - solve(nums, goal - 1);
        
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

        System.out.println("Number of subarrays whose sum is equal to K is : " + numSubarraysWithSum(arr, k));

        sc.close();
    }
}
