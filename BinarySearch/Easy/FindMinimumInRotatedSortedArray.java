package BinarySearch.Easy;

public class FindMinimumInRotatedSortedArray {
    /*
     * Given an integer array nums of size N, sorted in ascending order with
     * distinct values, and then rotated an unknown number of times (between 1 and
     * N), find the minimum element in the array.
     * 
     * Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
     * Output: 0
     */

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            // if array is already sorted as the lements are unique
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            if (nums[mid] < ans) {
                ans = nums[mid];
            }

            // if left array is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] < ans) {
                    ans = nums[left];
                }
                left = mid + 1;
            }
            // if right array is sorted
            else {
                if (nums[mid + 1] < ans) {
                    ans = nums[left];
                }
                right = mid - 1;
            }
        }
        return ans;
    }
}
