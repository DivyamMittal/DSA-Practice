package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    /*
     * Same Question like Longest subarray with sum zero
     * https://leetcode.com/problems/contiguous-array/description/
     * Given a binary array nums, return the maximum length of a contiguous subarray
     * with an equal number of 0 and 1.
     * 
     * Input: nums = [0,1,1,1,1,1,0,0,0]
     * Output: 6
     */

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
        System.out.println(findMaxLength(nums));
    }

    // TC -> O(N), SC -> O(N)
    public static int findMaxLength(int[] nums) {
        // assume 0 to be -1 and 1 to be 1 -> then the same problem can be solved using
        // Longest subarray with sum zero approach

        int max = 0;
        int sum = 0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
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
