package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    /*
     * Given an integer array nums and an integer target. Return all quadruplets
     * [nums[a], nums[b], nums[c], nums[d]] such that:
     * a, b, c, d are all distinct valid indices of nums.
     * nums[a] + nums[b] + nums[c] + nums[d] == target.
     * Notice that the solution set must not contain duplicate quadruplets. One
     * element can be a part of multiple quadruplets. The output and the quadruplets
     * can be returned in any order.
     * Input: nums = [1, -2, 3, 5, 7, 9], target = 7
     * 
     * Output: [[-2, 1, 3, 5]]
     */

    public static void main(String[] args) {
        int[] nums = { 1, -2, 3, 5, 7, 9, -2, 1, -1, 4 };
        int target = 7;
        // int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000 };
        // int target = -294967296;

        System.out.println(fourSum(nums, target));
        System.out.println(fourSumOptimal(nums, target));
    }

    // Optimal Approach
    // TC -> O(N^3)
    // SC -> O(no. of the quadruplets)
    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        List<List<Integer>> quadSet = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if ((long) target == sum) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        quadSet.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < (long) target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return quadSet;
    }

    // Better Approach
    // TC -> O(N^3 x log(M)),
    // SC -> O(2 x no. of the quadruplets)+O(N)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> quadSet = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> temp = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;
                    if (temp.contains(fourth)) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        ans.add((int) fourth);

                        Collections.sort(ans);
                        quadSet.add(ans);

                    } else {
                        temp.add((long) nums[k]);
                    }
                }
            }
        }

        return new ArrayList<>(quadSet);
    }

    // BruteForce
    // traverse 4 loops -> TC -> O(N^4)
}
