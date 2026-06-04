package BinarySearch.Easy;

public class FindOutHowManyTimesArrayIsSorted {
    /*
     * Given an integer array nums of size n, sorted in ascending order with
     * distinct values. The array has been right rotated an unknown number of times,
     * between 0 and n-1 (including). Determine the number of rotations performed on
     * the array.
     * 
     * Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
     * Output: 4
     */

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };

        System.out.println(findKRotation(nums));
    }

    /// Approach is the find the index of minimum

    public static int findKRotation(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        int idx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // check if array is sorted
            if (nums[left] <= nums[right]) {
                if (nums[left] < ans) {
                    ans = nums[left];
                    idx = left;
                }
                break;
            }

            // check if left array is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] < ans) {
                    ans = nums[left];
                    idx = left;
                }
                left = mid + 1;
            }
            // right array is sorted
            else {
                if (nums[mid + 1] < ans) {
                    ans = nums[mid + 1];
                    idx = mid + 1;
                }
                right = mid - 1;
            }
        }

        return idx;
    }
}
