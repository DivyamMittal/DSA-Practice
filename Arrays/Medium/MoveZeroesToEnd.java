package Arrays.Medium;

public class MoveZeroesToEnd {
    /*
     * Given an integer array nums, move all the 0's to the end of the array. The
     * relative order of the other elements must remain the same.
     * This must be done in place, without making a copy of the array.
     * Input: nums = [0, 1, 4, 0, 5, 2]
     * 
     * Output: [1, 4, 5, 2, 0, 0]
     */

    public static void main(String[] args) {
        int[] nums = { 2,1 };

        moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;

        for (int x = 0; x < nums.length; x++) {
            if (nums[x] != 0) {
                swap(nums, i, x);
                i++;
            }
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
