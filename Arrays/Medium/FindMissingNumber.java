package Arrays.Medium;

import java.util.Arrays;

public class FindMissingNumber {
    /*
     * Given an integer array of size n containing distinct values in the range from
     * 0 to n (inclusive), return the only number missing from the array within this
     * range.
     * Input: nums = [0, 2, 3, 1, 4]
     * 
     * Output: 5
     */

    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 1, 4 };
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberOptimize2(nums));
    }

    // optimize approach - using summation formula
    public static int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;

        int numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSum = numsSum + nums[i];
        }

        return sum - numsSum;
    }

    // optimize approach 2 using xor
    public static int missingNumberOptimize2(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }

        return xor1 ^ xor2;
    }

    // bruteForce approach
    public static int missingNumberBF(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }
}
