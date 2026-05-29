package Arrays.easy;

public class CheckIfArrayIsSortedAndRotated {
    /*
     * Given an array nums, return true if the array was originally sorted in
     * non-decreasing order, then rotated some number of positions (including zero).
     * Otherwise, return false.
     * 
     * There may be duplicates in the original array.
     * 
     * Note: An array A rotated by x positions results in an array B of the same
     * length such that B[i] == A[(i+x) % A.length] for every valid index i.
     * 
     * Input: nums = [3,4,5,1,2]
     * Output: true
     */

    public static void main(String[] args) {
        int[] nums = { 5, 1, 5, 1 };
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) {
            return false;
        }

        int idx = -1;
        // find the index of first smallest element
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }

        if (idx == -1) {
            return true;
        }

        for (int i = idx; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        if (nums[n - 1] > nums[0]) {
            return false;
        }

        return true;
    }
}
