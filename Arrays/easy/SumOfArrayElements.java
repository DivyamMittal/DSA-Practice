package Arrays.easy;

public class SumOfArrayElements {

    public static void main(String[] args) {
        // Given an array arr of size n, the task is to find the sum of all the elements
        // in the array.

        // Example 1
        // Input: n=5, arr = [1,2,3,4,5]

        // Output: 15

        int[] arr = { 1, 2, 3, 4, 5 };
        int ans = 0;

        for (int i : arr) {
            ans += i;
        }

        System.out.println(ans);
    }
}