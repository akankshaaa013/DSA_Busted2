import java.util.Arrays;
import java.util.Scanner;

/*
 * BRUTE FORCE APPROACH:
 * Generate all the substrings. For each substring, compute the maxFreq(freq of character that appears to be most) and then 
 * compute the ((change = n - maxFreq)). Here change will signify the max characters u need to change. 
 * Then compare change with K. if less than or equal then the substring is valid and so update the length accordingly.
 * 
 * Time Complexity: O(n*n)
 * Space Complexity: O(26) 
 */
public class Longest_repeating_character_replacement {
    public static int characterReplacement(String s, int k) {

        int maxLen = 0;

        int[] hash = new int[26];

        for (int l = 0; l < s.length(); l++) {
            Arrays.fill(hash, 0);
            int maxFreq = 0;
            for (int r = l; r < s.length(); r++) {
                hash[s.charAt(r) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

                int change = (r - l + 1) - maxFreq;

                if (change <= k) {
                    maxLen = Math.max(maxLen, (r - l + 1));
                }
            }
        }
        return maxLen;
    }

    /*
     * BETTER APPROACH USING SLIDING WINDOW & 2 POINTERS
     * Time Complexity : O(n * 26 + n * 26)
     * Space Complexity: O(2n)
     */
    public static int characterReplacement2(String s, int k) {

        int n = s.length();
        int[] hash = new int[26];
        int maxFreq = 0, change = 0, maxLen = 0;
        Arrays.fill(hash, 0);

        for (int left = 0, right = 0; right < n; right++) {
            hash[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            change = (right - left + 1) - maxFreq;

            while (change > k) {
                hash[s.charAt(left) - 'A']--;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                left++;
                change = (right - left + 1) - maxFreq;
            }
            maxLen = Math.max(maxLen, (right - left + 1));
        }
        return maxLen;
    }

    /*
     * OPTIMAL APPROACH USING SLIDING WINDOW & 2 POINTERS
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     */
    public static int characterReplacement3(String s, int k) {

        int n = s.length();
        int[] hash = new int[26];
        int maxFreq = 0, change = 0, maxLen = 0;
        Arrays.fill(hash, 0);

        for (int left = 0, right = 0; right < n; right++) {
            hash[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            change = (right - left + 1) - maxFreq;

            if (change > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
                change = (right - left + 1) - maxFreq;
            }
            maxLen = Math.max(maxLen, (right - left + 1));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String s = sc.next();

        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();

        System.out.println(
                "The length of the longest substring containing the same letter you can get after performing K operations "
                        + characterReplacement2(s, k));

        sc.close();
    }
}
