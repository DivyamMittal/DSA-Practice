package Arrays.Hard;

public class KadaneAlgorithms {
    /*
     * https://leetcode.com/problems/maximum-subarray/description/
     * 
     * ---- Maximum Subarray Sum ----
     * Given an integer array nums, find the subarray with the largest sum and
     * return the sum of the elements present in that subarray.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * Input: nums = [2, 3, 5, -2, 7, -4]
     * 
     * Output: 15
     */

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, -2, 7, -4 };

        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayOptimal(nums));
    }

    // Optimal Approach
    public static int maxSubArrayOptimal(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    // Better Approach
    // TC -> O(N^2) , SC -> O(1)
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
