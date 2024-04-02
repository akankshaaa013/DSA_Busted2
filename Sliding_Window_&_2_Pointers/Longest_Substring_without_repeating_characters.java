import java.util.Arrays;
import java.util.Scanner;

public class Longest_Substring_without_repeating_characters {

    /*
     * BRUTE APPROACH:
     * Generate all possible substrings using nested loops and chck if all the characters are unique.
     * Time Complexity : O(n*n)
     * Space Complexity : O(256)
    */
    public static int lengthOfLongestSubstring(String s) {

        int maxLen = 0, n = s.length();

        for(int left = 0; left < n; left++)
        {
            int[] hash = new int[256];
            for(int right = left; right < n; right++)
            {
                char c = s.charAt(right);
                if(hash[c] == 1)    break;

                maxLen = Math.max(maxLen, (right - left + 1));
                hash[c]++;
            }
        }
        return maxLen;        
    }

    /*
     * BETTER APPROACH:
     * Through sliding window technique, keep expanding the window. But everytime do a check if the character was 
     * already seen. If yes, then where was it seen. Update the left pointer accordingly.
     * Time Complexity : O(n)
     * Space Complexity : O(256) ~ O(1)
    */
    public static int lengthOfLongestSubstring2(String s) {

        int maxLen = 0;

        // hash[] array to store the index of the character last seen.
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        for(int left = 0, right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);

            // To check if the character was last seen and if yes then if it falls within the considered substring i.e., left <= hash[c] <= right;
            if(hash[c] != -1 && hash[c] >= left)
            {
                left = hash[c] + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            hash[c] = right;
        }

        return maxLen;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String s = sc.next();

        sc.close();

        System.out.println("Length of Longest substring without the repeating character is : " + lengthOfLongestSubstring2(s));

    }

}
