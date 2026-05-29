package Sorting;

public class SelectionSort {
    /*
     * Selection Sort
     * Input: nums = [7, 4, 1, 5, 3]
     * 
     * Output: [1, 3, 4, 5, 7]
     */

    public static void main(String[] args) {
        int[] nums = { 7, 4, 1, 5, 3 };

        nums = selectionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
