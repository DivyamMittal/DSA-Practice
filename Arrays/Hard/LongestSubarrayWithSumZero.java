package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestSubarrayWithSumZero {
    /*
     * Given an array containing both positive and negative integers, we have to
     * find the length of the longest subarray with the sum of all elements equal to
     * zero.
     * Input: {9, -3, 3, -1, 6, -5}
     * output: 5
     */

    public static void main(String[] args) {
        int[] nums = { 1, -1 };
        // int[] nums = { 9, -3, 3, -1, 6, -5 };

        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int max = 0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    int idx = map.get(sum);
                    max = Math.max(max, i - idx);
                } else {
                    map.put(sum, i);
                }
            }

        }

        return max;
    }

}
