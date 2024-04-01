import java.util.Scanner;

public class Maximum_points_you_can_obtain_from_N_cards {
    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int sum = 0, maxSum = 0;

        int i = 0, j = 0;
        for (i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        maxSum = sum;

        i = k - 1;

        for (j = n - 1; j >= n - k; j--) {
            sum -= cardPoints[i];
            i--;
            sum += cardPoints[j];

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value of k : ");

        int k = sc.nextInt();

        sc.close();

        System.out.println("Maximum points you can obtain is : " + maxScore(arr, k));

    }
}
