package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = { 7, 4, 1, 5, 3,0 };

        nums = insertionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                swap(nums, j, j - 1);
                j--;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }

}
