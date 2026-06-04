package BinarySearch.Easy;

public class SingleElementInSortedArray {
    /*
     * Given an array nums sorted in non-decreasing order. Every number in the array
     * except one appears twice. Find the single number in the array.
     * 
     * Input :nums = [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
     * Output:4
     */

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };

        System.out.println(singleNonDuplicate(nums));
    }

    // Using even odd approach
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // base conditions
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            else if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) || (mid % 2 == 0 && nums[mid + 1] == nums[mid])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
