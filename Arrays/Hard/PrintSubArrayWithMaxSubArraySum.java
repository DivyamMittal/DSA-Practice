package Arrays.Hard;

public class PrintSubArrayWithMaxSubArraySum {

    /*
     * Given an integer array nums, find the subarray with the largest sum and
     * return the sum of the elements present in that subarray.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * Input: nums = [2, 3, 5, -2, 7, -4]
     * Output:
     */

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, -2, 7, -4, 4 };

        int[] ans = printSubArray(nums);

        for (int i = ans[0]; i <= ans[1]; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] printSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > max) {
                max = sum;
                end = i;
            }

            if (sum < 0) {
                sum = 0;
                start = i;
            }
        }

        return new int[] { start, end };
    }
}