package BinarySearch.Medium2;

import java.util.Arrays;

public class AggressiveCows {
    /*
     * Given an array nums of size n, which denotes the positions of stalls, and an
     * integer k, which denotes the number of aggressive cows, assign stalls to k
     * cows such that the minimum distance between any two cows is the maximum
     * possible. Find the maximum possible minimum distance.
     * Input: k = 4, nums = [0, 3, 4, 7, 10, 9]
     * 
     * Output: 3
     * 
     * LEETCODE:-
     * https://leetcode.com/problems/magnetic-force-between-two-balls/description/
     */

    public static void main(String[] args) {
        int[] nums = { 0, 3, 4, 7, 10, 9 };
        int k = 4;

        System.out.println(aggressiveCows(nums, k));
        System.out.println(aggressiveCowsOptimize(nums, k));
    }

    // Using Binary Search
    // TC - O(NlogN) + O(N *log(max-min))
    public static int aggressiveCowsOptimize(int[] nums, int k) {
        int n = nums.length;

        int low = 1;
        int high = nums[n - 1] - nums[0];
        Arrays.sort(nums);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(nums, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    // USING LINEAR SEARCH
    // TC - O(NlogN) + O(N *(max-min))
    public static int aggressiveCows(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int limit = nums[n - 1] - nums[0];
        int ans = limit;

        for (int i = 1; i <= limit; i++) {
            if (canWePlace(nums, k, i)) {
                ans = i;
            } else {
                return ans;
            }

        }

        return ans;
    }

    private static boolean canWePlace(int[] nums, int cows, int dist) {
        int n = nums.length;

        int cnt = 1;
        int lastCow = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] - lastCow >= dist) {
                cnt++;
                lastCow = nums[i];
            }

            if (cnt >= cows) {
                return true;
            }
        }

        return false;
    }
}
