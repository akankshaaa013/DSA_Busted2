import java.util.Scanner;

/*
 * BRUTE FORCE:
 * Generate all possible subarrays using nested loops and check for the condition.
 * Time Complexity : O(N*N)
 */
public class Maximum_consecutive_1s {
    public static int findMaxConsecutiveOnes(int[] nums, int k) {

        int maxLen = 0, n = nums.length;

        for (int l = 0; l < n; l++) {
            int zeroes = 0;
            for (int r = l; r < n; r++) {
                if (nums[r] == 0)
                    zeroes++;

                if (zeroes > k)
                    break;

                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen;
    }

    /*
     * BETTER APPROACH : 
     * Keep expanding the window until and unless the count of zeroes is <= k. Once greater than k, then keep 
     * shrinking it unless the condition is satisfied again.
     * 
     * Time Complexity : O(N + N)
     * Space Complexity: O(1)
     */
    public static int longestOnes(int[] nums, int k) {

        int n = nums.length, zeroes = 0, maxLen = 0;

        for (int left = 0, right = 0; right < n; right++) {
            if (nums[right] == 0)
                zeroes++;

            if (zeroes > k) {
                if (nums[left] == 0)
                    zeroes--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
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
        System.out.println("Maximum number of consecutive ones when u can flip atmost k 0's are : "
                + longestOnes(arr, k));

        sc.close();

    }
}
