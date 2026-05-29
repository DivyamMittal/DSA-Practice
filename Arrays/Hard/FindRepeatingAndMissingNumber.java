package Arrays.Hard;

public class FindRepeatingAndMissingNumber {
    /*
     * Given an integer array nums of size n containing values from [1, n] and each
     * value appears exactly once in the array, except for A, which appears twice
     * and B which is missing.
     * 
     * Return the values A and B, as an array of size 2, where A appears in the 0-th
     * index and B in the 1st index.
     * Input: nums = [3, 5, 4, 1, 1]
     * 
     * Output: [1, 2]
     */

    public static void main(String[] args) {
        int[] nums = { 3, 5, 4, 1, 1 };
        int[] ans = findMissingRepeatingNumbers(nums);

        System.out.println(ans[0] + " " + ans[1]);
    }

    // optimal Solution 1 (Using Math equation)
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        // S - SN
        long S = 0;
        long SN = (n * (n + 1)) / 2;

        // S2 - S2N (Square)
        long S2 = 0;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += ((long) nums[i] * (long) nums[i]);
        }

        long val1 = S - SN; // x-y
        long val2 = (S2 - S2N) / val1; // x + y

        long x = (val1 + val2) / 2;

        long y = x - val1;

        return new int[] { (int) x, (int) y };

    }

    // brute force
    // take 2 loops

    // better approach
    // using hash map
}
