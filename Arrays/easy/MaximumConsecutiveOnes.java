package Arrays.easy;

public class MaximumConsecutiveOnes {
    /*
     * Given a binary array nums, return the maximum number of consecutive 1s in the
     * array.
     * A binary array is an array that contains only 0s and 1s.
     * 
     * Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
     * Output: 3
     */
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 0, 1, 1, 1, 0 };

        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int ans = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
                ans = Math.max(cur, ans);
            } else {
                cur = 0;
            }
        }
        return ans;
    }
}
