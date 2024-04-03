import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
 * If there is no possible substring then print -1.
*/

public class Longest_substring_with_atmost_K_distinct_char {

    /*
     * BRUTE FORCE APPROACH:
     * Generate all possible substrings and check for the number of unique characters in the substring.
     * Simultaneously keep updating the maxLen too.
     * Time Complexity: O(N*N)
     * Space Complexity: O(26) ~ O(1)
     */
    public static int longestkSubstr(String s, int k) {

        int maxLen = 0, maxCnt = 0;

        for (int l = 0; l < s.length(); l++) {
            int cnt = 0;
            int[] hash = new int[26];
            Arrays.fill(hash, -1);

            for (int r = l; r < s.length(); r++) {
                int idx = s.charAt(r) - 97;
                if (hash[idx] == -1) {
                    cnt++;
                    hash[idx] = 1;
                }

                if (cnt > k)
                    break;

                if (maxLen < r - l + 1) {
                    maxLen = r - l + 1;
                    maxCnt = cnt;
                }
            }
        }
        return maxCnt == k ? maxLen : -1;
    }

    /*
     * BETTER APPROACH 
     * Using sliding window & 2 pointers, iterate in the substring and keep storing the character and its count in the map.
     * If the size of the map is greater than k, then increment the left pointer till one character is reduced.
     * Time Complexity: O(N + N)
     * Space Complexity: O(log(26))
     */
    public static int longestkSubstr2(String s, int k) {

        int maxLen = 0, n = s.length();
        Map<Character, Integer> mpp = new HashMap<>();

        for (int left = 0, right = 0; right < n; right++) {
            mpp.put(s.charAt(right), mpp.getOrDefault(s.charAt(right), 0) + 1);

            while (mpp.size() > k) {
                mpp.put(s.charAt(left), mpp.get(s.charAt(left)) - 1);
                if (mpp.get(s.charAt(left)) == 0)
                    mpp.remove(s.charAt(left));
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        if (mpp.size() != k)
            return -1;
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String s = sc.next();

        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();

        System.out.println("Longest Substring with atmost K distinct character is : " + longestkSubstr2(s, k));

        sc.close();
    }
}
