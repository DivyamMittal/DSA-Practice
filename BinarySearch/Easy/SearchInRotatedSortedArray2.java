package BinarySearch.Easy;

public class SearchInRotatedSortedArray2 {
    /*
     * Given an integer array nums, sorted in ascending order (may contain duplicate
     * values) and a target value k. Now the array is rotated at some pivot point
     * unknown to you. Return True if k is present and otherwise, return False.
     * 
     * Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
     * Output: True
     */

    public static void main(String[] args) {
        // int[] nums = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
        // int k = 3;
        int[] nums = { 3, 1, 3, 3, 3, 3 };
        int k = 1;

        System.out.println(search(nums, k));
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left = left + 1;
                right = right - 1;
                continue;
            }

            // if left is sorted
            else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // if right is sorted
            else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
