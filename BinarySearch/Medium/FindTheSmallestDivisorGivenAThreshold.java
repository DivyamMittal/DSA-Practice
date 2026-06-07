package BinarySearch.Medium;

public class FindTheSmallestDivisorGivenAThreshold {
    /*
     * Given an array of integers nums and an integer threshold, we will choose a
     * positive integer divisor, divide all the array by it, and sum the division's
     * result. Find the smallest divisor such that the result mentioned above is
     * less than or equal to threshold.
     * 
     * Each result of the division is rounded to the nearest integer greater than or
     * equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
     * 
     * The test cases are generated so that there will be an answer.
     * Input: nums = [1,2,5,9], threshold = 6
     * Output: 5
     */

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        if (nums.length > threshold) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int low = 1;
        int high = max;
        int ans = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (thresholdCheck(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean thresholdCheck(int[] nums, int threshold, int mid) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += Math.ceil((double) nums[i] / (double) mid);
        }

        return cnt <= threshold;
    }

}
