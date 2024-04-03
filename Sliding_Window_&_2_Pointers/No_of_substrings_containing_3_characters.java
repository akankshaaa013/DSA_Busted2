import java.util.Arrays;
import java.util.Scanner;

public class No_of_substrings_containing_3_characters {

    /*
     * BRUTE SOLUTION:
     * Generate all substrings and count the substring that has all 3 character a, b and c.
     * Time Complexity: O(n*n)
     * Space Complexity: O(3) ~ O(1)
     */
    public static int numberOfSubstrings(String s) {

        int ans = 0, n = s.length();

        for (int l = 0; l < s.length(); l++) {
            int cnt = 0;
            int[] hash = new int[3];
            Arrays.fill(hash, -1);

            for (int r = l; r < s.length(); r++) {
                if (hash[s.charAt(r) - 'a'] == -1) {
                    cnt++;
                    hash[s.charAt(r) - 'a'] = 1;
                }

                if(cnt == 3)
                {
                    ans += (n - r);
                    break;
                }
            }
        }
        return ans;
    }


    /*
     * BETTER APPROACH:
     * Since for every character there is a substring that ends so we'll check if the window with the last character has
     * all 3 characters in it. If YES then smartly we'll add previous characters too.
     * SIMPLY DO A DRY RUN, YOU'LL FIGURE IT OUT.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int numberOfSubstrings2(String s) {

        int[] hash = new int[3];
        Arrays.fill(hash, -1);
        int n = s.length();
        int ans = 0;

        for(int right = 0; right < n; right++)
        {
            hash[s.charAt(right) - 'a'] = right;

            int minIdx = Math.min(hash[0], Math.min(hash[1], hash[2]));
            
            if(minIdx != -1)
            {
                ans += (1 + minIdx);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String s = sc.next();

        System.out.println("Number of Substring with 3 distinct character is : " + numberOfSubstrings2(s));

        sc.close();
    }

}
