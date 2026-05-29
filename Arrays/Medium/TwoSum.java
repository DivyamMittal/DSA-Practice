package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * 
     * You can return the answer in any order.
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     */

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, -7, 6, -3 };
        int[] ans = twoSum(nums, 0);
        System.out.println(ans[0] + " " + ans[1]);
    }

    // TC -> O(N), SC -> O(N). As searching key in map take O(1)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];

            if (map.containsKey(rem)) {
                return new int[] { map.get(rem), i };
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] { -1, -1 };
    }

    // Or we can use two pointer by sorting the array -> O(NlogN), O(1) only if
    // someone says not to use extra space or hashmap
}
