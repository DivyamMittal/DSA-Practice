package BasicRecursion;

public class ReverseAnArray {
    /*
     * Given an array nums of n integers, return reverse of the array.
     * Input : nums = [1, 2, 3, 4, 5]
     * 
     * Output : [5, 4, 3, 2, 1]
     */

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        nums = reverseArray(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] reverseArray(int[] nums) {
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        reverse(nums, start + 1, end - 1);
    }
}
