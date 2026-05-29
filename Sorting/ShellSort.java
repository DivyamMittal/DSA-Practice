package Sorting;

public class ShellSort {
    /*
     * Shell Sort
     * Input: nums: [5,3,7,2,4,1,0,6]
     * Output: [0,1,2,3,4,5,6,7]
     */

    public static void main(String[] args) {
        int[] nums = { 5, 3, 7, 2, 4, 1, 0, 6 };
        shellSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void shellSort(int[] nums) {
        int len = nums.length;
        int gap = (len / 2) + (len % 2); // Gives me the seil number
        while (gap > 0) {
            int left = 0;
            int right = gap;

            while (right < len) {
                if (nums[left] > nums[right]) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
                right++;
            }
            if (gap == 1)
                return;
            gap = (gap / 2) + (gap % 2); // seil of gap
        }

        return;
    }
}
