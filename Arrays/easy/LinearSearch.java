package Arrays.easy;

public class LinearSearch {
    /*
     * Given an array of integers nums and an integer target, find the smallest
     * index (0 based indexing) where the target appears in the array. If the target
     * is not found in the array, return -1
     * 
     * Input: nums = [2, 3, 4, 5, 3], target = 3
     * Output: 1
     */

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 5, 3 };
        System.out.println(linearSearch(nums, 3));
    }

    public static int linearSearch(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
