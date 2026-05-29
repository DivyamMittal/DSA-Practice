package Arrays.Medium;

public class SortArray0_1_2 {
    /*
     * Given an array nums consisting of only 0, 1, or 2. Sort the array in
     * non-decreasing order.
     * The sorting must be done in-place, without making a copy of the original
     * array.
     * Input: nums = [1, 0, 2, 1, 0]
     * 
     * Output: [0, 0, 1, 1, 2]
     */
    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 1, 0 };
        sortZeroOneTwo(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sortZeroOneTwo(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /// Brute Force
    /// Sort the array
    /// TC -> O(nlogn) -> mergeSort
    ///
    /// Better Approach (TWO TRAVERSAL)
    /// Take three variable and count the frequencies of element
    /// override the value of nums and put the value in nums according to counter
    /// TC -> O(2N), SC -> O(1)
    ///
    /// Optimal Approach (ONE TRAVERSAL)
    /// Take two pointer for 0 and 2.
    /// TC -> O(N), SC -> O(1)
}
