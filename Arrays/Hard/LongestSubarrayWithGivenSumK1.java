package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSumK1 {
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
        int[] nums = { -5, 8, -14, 2, 4, 12 };
        int k = -5;
        System.out.println(longestSubarray(nums, k));
    }

    // OPTIMAL if array contains both POSITIVES and NEGATIVES
    // BETTER if array contains only POSITIVES
    // TC -> O(N), SC -> O(N)
    public static int longestSubarray(int[] nums, int k) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                max = i + 1;
            } else {
                if (map.containsKey(sum - k)) {
                    int idx = map.get(sum - k);
                    max = Math.max(max, i - idx);
                }
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
