package Arrays.Medium;

public class RemoveDuplicatesFromSorted {
    /*
     * Given an integer array nums sorted in non-decreasing order, remove all
     * duplicates in-place so that each unique element appears only once.
     * 
     * Input: nums = [0, 0, 3, 3, 5, 6]
     * Output: 4
     */

    public static void main(String[] args) {
        int[] nums = { 0, 0, 3, 3, 5, 6 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int idx = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[idx] = nums[i + 1];
                idx++;
            }
        }
        return idx;
    }
}
