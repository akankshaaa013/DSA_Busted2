import java.util.Arrays;

public class patterns {

    //* PATTERN 1:
    // Window size is fixed. Though not asked lot but still can be used in problems like ---> Max sum/product of subarray of size k.
    public static int Constant_Window(int[] arr, int k)
    {
        int left = 0, right = k - 1;
        int sum = 0, maxSum = 0;

        for(int i = 0; i <= right; i++)
        {
            sum += arr[i];
        }

        while(right < arr.length - 1)
        {
            sum -= arr[left];
            left++;
            right++;
            sum += arr[right];

            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }


    //* PATTERN 2:
    //* Longest subarray or a substring that satisifes a particular condition.
    
    //* Que -> Return the subarray with sum atleast k;

    //* Step 1: Start with brute force. Generate all the subarrays or substrings.
    public static int[] step1(int[] arr, int k)
    {
        int maxLen = 0, r = 0, l = 0;;

        for(int left = 0; left < arr.length; left++)
        {
            int sum = 0;

            for(int right = left; right < arr.length; right++)
            {
                sum += arr[right];

                if(sum <= k && maxLen < (right - left + 1))
                {
                    maxLen = Math.max(maxLen, right - left + 1);
                    r = right;
                    l = left;
                }
                else    break;
            }
        }
        return Arrays.copyOfRange(arr, l, r + 1);
    }

    //* Step 2: Use Sliding window & 2 pointers approach.
    public static int[] step2(int[] arr, int k)
    {
        int left = 0, right = 0, sum = 0, la = -1, ra = -1;

        while(right < arr.length)
        {
            sum += arr[right];

            // Shrink the window.
            while(sum > k)
            {
                sum -= arr[left];
                left++;
            }

            if((right - left + 1) > (ra - la + 1))
            {
                la = left;
                ra = right;
            }
            right++;
        }
        return Arrays.copyOfRange(arr, la, ra + 1);
    }
    
    
    //* Step 3: Optimize the step 2 solution. (This optimization only works when we need to find the maximum length.)
    public static int step3(int[] arr, int k)
    {
        int left = 0, right = 0, sum = 0, maxLen = 0;

        while(right < arr.length)
        {
            sum += arr[right];

            // Shrink the window.
            if(sum > k)
            {
                sum -= arr[left];
                left++;
            }

            if(sum <= k)
            {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
    
    /*
     * PATTERN 3 : NO. OF SUBARRAYS THAT SATISFIES A PARTICULAR CONDITION.
     * 
     * Number of Subarrays with sum = k.
     * Find : 1) Number of subarray with sum <= k. --> x
     *        2) Number of subarray with sum > k. --> y
     *           return x -y
    */

    /*
     * PATTERN 4 : MINIMUM SIZE OF SUBARRAY THAT SATISFIES A PARTICULAR CONDITION.
     * 
     * Get the valid window and keep shrinking it while the condition is still satisfied.
     * Store the answer of the minimum shrinked window. 
    */

    public static void main(String[] args) {

        int[] arr = {2, 4, -1, 5, 10};
        int[] ans = step2(arr, 18);

        System.out.println("Length of the Maximum Subarray is : " + step3(arr, 18));
        
        for(int x : ans)    System.out.print(x + "   ");
    }
}
