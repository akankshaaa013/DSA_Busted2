import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5, 10, 9, 7, 8, 6};
        
        Arrays.parallelSort(arr);

        System.out.println(Arrays.binarySearch(arr, 10));

        // Arrays.fill(arr, 10);

        for(int x : arr)
        {
            System.out.print(x + "   ");
        }
    } 
}
