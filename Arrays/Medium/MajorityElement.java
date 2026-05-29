package Arrays.Medium;

public class MajorityElement {
    /*
     * Given an integer array nums of size n, return the majority element of the
     * array.
     * The majority element of an array is an element that appears more than n/2
     * times in the array. The array is guaranteed to have a majority element.
     * 
     * Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
     * 
     * Output: 7
     */

    public static void main(String[] args) {
        int[] nums = { 7, 0, 0, 1, 7, 7, 2, 7, 7 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int ele = nums[0];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                ele = nums[i];
                cnt++;
            } else {
                if (nums[i] != ele) {
                    cnt--;
                } else {
                    cnt++;
                }
            }
        }

        return ele;
    }
}
