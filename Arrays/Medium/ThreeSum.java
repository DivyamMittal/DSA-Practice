package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    /*
     * Given an integer array nums. Return all triplets such that:
     * i != j, i != k, and j != k
     * nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets. One element
     * can be a part of multiple triplets. The output and the triplets can be
     * returned in any order.
     * Input: nums = [2, -2, 0, 3, -3, 5]
     * 
     * Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]
     */

    public static void main(String[] args) {
        int[] nums = { 2, -2, 0, 3, -3, 5 };
        System.out.println(threeSum(nums));
        System.out.println(threeSumOptimal(nums));
    }

    // Optimal Approach
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }

        }
        return ans;
    }

    // Better Approach
    // TC -> O(N^2), SC -> O(2 x no. of the unique triplets) + O(N)
    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> tripleSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    Collections.sort(temp);
                    tripleSet.add(temp);
                }
                set.add(nums[j]);
            }

        }

        return new ArrayList<>(tripleSet);
    }

    /*
     * BruteForce:-
     * Use three nested loops to consider every possible triplet in the array:
     * Outer loop i runs from 0 to n-3.
     * Middle loop j runs from i+1 to n-2.
     * Inner loop k runs from j+1 to n-1.
     * TC -> O(N^3 x log(no. of unique triplets))
     * SC -> O(2 x no. of the unique triplets)
     * 
     */

}
