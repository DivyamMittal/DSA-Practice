package Arrays.easy;

public class SecondLargestElement {
    /*
     * Given an array of integers nums, return the second-largest element in the
     * array. If the second-largest element does not exist, return -1.
     * 
     * Input: nums = [8, 8, 7, 6, 5]
     * Output: 7
     */

    public static void main(String[] args) {
        int[] nums = { 10000, -10000 };

        System.out.println(secondLargestElement(nums));
    }

    public static int secondLargestElement(int[] nums) {
        int lar = nums[0];
        int secLar = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > lar) {
                secLar = lar;
                lar = nums[i];
            } else if (nums[i] > secLar && nums[i] < lar) {
                secLar = nums[i];
            }
        }
        return secLar;
    }
}
