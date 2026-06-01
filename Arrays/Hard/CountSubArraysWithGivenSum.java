package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithGivenSum {
    /*
     * Given an array of integers nums and an integer k, return the total number of
     * subarrays whose sum equals to k.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     * 
     * Input: nums = [1, 2, 1, 2, 1 ], k = 3
     * Output: 4
     * 
     * Input: nums = [1,-1,0 ], k = 0
     * Output: 4
     */

    public static void main(String[] args) {
        int[] nums = { 1, -1, 0 };
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                cnt++;
            } else {
                if (map.containsKey(sum - k)) {
                    cnt++;
                }
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }
        return cnt;
    }
}
