package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubarraysWithSumK {
    /*
     * Given an array of integers nums and an integer k, return the total number of
     * subarrays whose sum equals to k.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     */

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = sum - k;

            cnt += map.getOrDefault(rem, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
