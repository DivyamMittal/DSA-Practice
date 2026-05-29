package Arrays.Medium;

import java.util.ArrayList;

public class RearrangeElementsBySign {

    /*
     * Rearrange array elements by sign
     * Given an integer array nums of even length consisting of an equal number of
     * positive and negative integers.Return the answer array in such a way that the
     * given conditions are met:
     * 
     * Every consecutive pair of integers have opposite signs.
     * 
     * For all integers with the same sign, the order in which they were present in
     * nums is preserved.
     * 
     * The rearranged array begins with a positive integer.
     * Input : nums = [2, 4, 5, -1, -3, -4]
     * Output : [2, -1, 4, -3, 5, -4]
     */

    public static void main(String[] args) {
        int[] nums = { 2, 4, 5, -1, -3, -4, -1, -2 };

        int[] ans = rearrangeArrayWay2(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    // when we have the equal number of positives and negatives
    // TC-> O(n). SC -> O(n)
    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];

        int p = 0, n = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                ans[p] = nums[i];
                p = p + 2;
            } else {
                ans[n] = nums[i];
                n = n + 2;
            }
        }

        return ans;
    }

    // when we don't have the equal no. of positives and negatives
    public static int[] rearrangeArrayWay2(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }
            int k = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                nums[k] = pos.get(i);
                k++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }
            int k = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                nums[k] = neg.get(i);
                k++;
            }

        }

        return nums;
    }
}