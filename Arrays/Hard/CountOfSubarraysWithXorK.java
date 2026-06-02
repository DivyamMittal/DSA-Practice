package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubarraysWithXorK {
    /*
     * Leetcode Link:-
     * https://leetcode.com/problems/count-the-number-of-beautiful-subarrays
     * 
     * Given an array of integers nums and an integer k, return the total number of
     * subarrays whose XOR equals to k.
     * 
     * Input : nums = [4, 2, 2, 6, 4], k = 6
     * Output : 4
     */

    public static void main(String[] args) {
        int[] nums = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(subarraysWithXorK(nums, k));
    }

    public static int subarraysWithXorK(int[] nums, int k) {

        int cnt = 0;
        int preXor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            preXor ^= nums[i];
            int target = preXor ^ k;

            cnt += map.getOrDefault(target, 0);

            map.put(preXor, map.getOrDefault(preXor, 0) + 1);
        }

        return cnt;
    }
}
