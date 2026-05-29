package Arrays.Hard;

public class MaximumProductSubarray {
    /*
     * Given an integer array nums. Find the subarray with the largest product, and
     * return the product of the elements present in that subarray.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * Input: nums = [4, 5, 3, 7, 1, 2]
     * Output: 840
     */

    public static void main(String[] args) {
        int[] nums = { 4, 5, 3, 7, 1, 2 };
        System.out.println(maxProduct(nums));
    }

    // For this Optmial solution we have two approach,
    // 1. Observation (using prefix and suffix) and 2. modified kadane algo
    public static int maxProduct(int[] nums) {
        int pre = 1, suf = 1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;

            pre *= nums[i];
            suf *= nums[n - i - 1];

            max = Math.max(max, Math.max(pre, suf));
        }
        return max;
    }
}
