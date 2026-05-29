package Arrays.easy;

public class LargestNumber {
    // BruteForce Approach -> Sort the array then return the last element

    // Optimal Approach -> Use max = arr[0] then traverse the array and check with
    // max

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };

        System.err.println(largestNumber(arr));
    }

    /// TC - O(n) | SC - O(1)
    public static int largestNumber(int[] arr) {
        if (arr.length <= 0)
            return 0;
        int max = arr[0];

        for (int i : arr) {
            if (i > max)
                max = i;
        }
        return max;
    }

}