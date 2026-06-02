package BinarySearch.Easy;

public class BinarySearch {
    /*
     * Given a sorted array of integers nums with 0-based indexing, find the index
     * of a specified target integer. If the target is found in the array, return
     * its index. If the target is not found, return -1.
     * 
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     */

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target));
        System.out.println(searchRec(nums, 0, nums.length, target));
    }

    // Iterative Search
    // TC -> O(logn), SC -> O(1)
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // Recursive Search
    // TC -> O(logn), SC -> O(1)
    public static int searchRec(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        else if (target > nums[mid])
            return searchRec(nums, mid + 1, right, target);
        else
            return searchRec(nums, left, mid - 1, target);
    }

}
