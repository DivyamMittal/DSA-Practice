package BinarySearch.Easy;

public class SearchInsertPosition {
    /*
     * Given a sorted array of nums consisting of distinct integers and a target
     * value, return the index if the target is found. If not, return the index
     * where it would be if it were inserted in order.
     * 
     * Input: nums = [1, 3, 5, 6], target = 5
     * Output: 2
     */

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int ans = nums.length;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
