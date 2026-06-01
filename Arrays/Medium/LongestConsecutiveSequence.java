package Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
     * Given an unsorted array of integers nums, return the length of the longest
     * consecutive elements sequence.
     * 
     * You must write an algorithm that runs in O(n) time.
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     */

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveBetter(nums));
        System.out.println(longestConsecutiveOptimal(nums));

    }

    // Optimal Approach
    // TC -> O(N) + O(2N), SC -> O(N)
    public static int longestConsecutiveOptimal(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            int ele = nums[i];
            if (!set.contains(ele - 1)) {
                while (set.contains(ele + 1)) {
                    cnt++;
                    ele++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    // Better Approach
    // TC -> O(n Log n) + O(n), SC -> O(1)
    public static int longestConsecutiveBetter(int[] nums) {
        if (nums.length == 0)
            return 0;

        // sort the array
        Arrays.sort(nums);

        int max = 1;
        int prevEle = Integer.MIN_VALUE;
        int curCnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == prevEle) {
                curCnt++;
                prevEle = nums[i];
            } else if (nums[i] != prevEle) {
                prevEle = nums[i];
                curCnt = 1;
            }
            max = Math.max(max, curCnt);
        }
        return max;
    }

    // BruteForce
    // TC -> O(N^2), SC -> O(1)
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int cnt = 1;

            while (linearSearch(nums, cur + 1)) {
                cnt++;
                cur++;
            }

            max = Math.max(max, cnt);

        }
        return max;
    }

    // ------------------- HELPER FUNCTION -------------------
    private static boolean linearSearch(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
    }

}
