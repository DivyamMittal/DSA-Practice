package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class LeaderInAArray {
    /*
     * Leaders in an Array
     * A leader in an array is an element whose value is strictly greater than all
     * elements to its right in the given array. The rightmost element is always a
     * leader. The elements in the leader array must appear in the order they appear
     * in the nums array.
     * Input: nums = [1, 2, 5, 3, 1, 2]
     * 
     * Output: [5, 3, 2]
     */

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 3, 1, 2 };
        List<Integer> res = leaders(nums);
        System.out.println(res);

    }

    public static List<Integer> leaders(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }

        int leader = nums[nums.length - 1];
        ans.add(leader);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > leader) {
                leader = nums[i];
                ans.add(0, nums[i]);
            }
        }

        return ans;
    }
}
