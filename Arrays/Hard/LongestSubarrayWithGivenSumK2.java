package Arrays.Hard;

public class LongestSubarrayWithGivenSumK2 {
    /*
     * # Longest Subarray with given Sum K(Positives)
     * 
     * Problem Statement: Given an array nums of size n and an integer k, find the
     * length of the longest sub-array that sums to k. If no such sub-array exists,
     * return 0.
     * 
     * Input: nums = [10, 5, 2, 7, 1, 9], k = 15
     * Output: 4
     */

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int k = 15;

        System.out.println(longestSubarray(nums, k));
    }

    // Optimal - Only POSITIVES
    // TC -> O(2N), SC -> O(1)
    public static int longestSubarray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > k) {
                while (sum > k && idx < i) {
                    sum = sum - nums[idx];
                    idx++;
                }
            }

            if (sum == k) {
                max = Math.max(max, i - idx + 1);
            }
        }

        return max;
    }

}
