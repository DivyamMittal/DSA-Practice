package Arrays.easy;

public class LeftRotateByK {
    /*
     * Given an integer array nums and a non-negative integer k, rotate the array to
     * the left by k steps.
     * Input: nums = [1, 2, 3, 4, 5, 6], k = 2
     * 
     * Output: nums = [3, 4, 5, 6, 1, 2]
     */

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int k = 3;

        rotateArray(nums, k);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length-1);
        rotate(nums, 0, nums.length-1);
    }

    private static void rotate(int[] nums, int x, int y) {
        while (x < y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
    }
}
