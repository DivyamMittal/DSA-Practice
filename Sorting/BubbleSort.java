package Sorting;

public class BubbleSort {
    /*
     * Compares adjacent elements
     * Swaps them if they are in the wrong order
     * Largest element “bubbles” to the end after each pass
     */

    public static void main(String[] args) {
        int[] nums = { 7, 4, 1, 5, 3 };

        nums = bubbleSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                // check for j and j+1
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }
    /*
     * 7 4 1 5 3 -> 4 7 1 5 3 -> 4 1 7 5 3 -> 4 1 5 7 3 -> 4 1 5 3 7
     * 4 1 5 3 7 -> 1 4 5 3 7 -> 1 4 5 3 7 -> 1 4 3 5 7
     * 1 4 3 5 7 -> 1 4 3 5 7 -> 1 3 4 5 7
     * 1 3 4 5 7 -> 1 3 4 5 7
     * 
     * 
     */
}
