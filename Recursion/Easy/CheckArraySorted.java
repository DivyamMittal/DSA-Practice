package Recursion.Easy;

import java.util.*;

public class CheckArraySorted {
    /*
     * Given an array nums of n integers, return true if the array nums is sorted in
     * non-decreasing order or else false.
     */

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 4));

        System.out.println(isSorted(nums));
    }

    public static boolean isSorted(ArrayList<Integer> nums) {
        return helper(nums, 0);
    }

    private static boolean helper(ArrayList<Integer> nums, int idx) {
        if (idx == nums.size() - 1) {
            return true;
        }

        if (nums.get(idx) > nums.get(idx + 1)) {
            return false;
        }

        return helper(nums, idx + 1);
    }
}
