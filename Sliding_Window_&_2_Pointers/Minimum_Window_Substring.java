import java.util.Scanner;
import java.util.Arrays;

public class Minimum_Window_Substring {

    /*
    * T.C : O(N + N)
    * S.C : O(256)
    */ 
    public static String minWindow(String s, String t) {

        int n = s.length(), m = t.length();
        int cnt = 0, minLen = 100000000, stIndex = -1, endIndex = -1;

        if(m > n)   return "";

        int[] hash = new int[256];
        Arrays.fill(hash, 0);

        for(int i = 0; i < m; i++)      hash[t.charAt(i)]++;

        for(int left = 0, right = 0; right < n; right++)
        {
            if(hash[s.charAt(right)] > 0)  cnt++;
            hash[s.charAt(right)]--;

            while(cnt == m)
            {
                if(minLen > (right - left + 1))
                {
                    minLen = right - left + 1;
                    stIndex = left;
                    endIndex = right;
                }

                hash[s.charAt(left)]++;

                if(hash[s.charAt(left)] > 0)    cnt--;
                left++;
            }
        }
        if(stIndex == -1 || endIndex == -1) return "";
        return s.substring(stIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the value of s & t : ");
        String s = sc.next();
        String t = sc.next();

        System.out.println("Minimum window substring is : " + minWindow(s, t));
        sc.close();
    }
}
