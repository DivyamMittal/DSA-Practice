package Arrays.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementII {
    /*
     * Given an integer array nums of size n. Return all elements which appear more
     * than n/3 times in the array. The output can be returned in any order.
     * Input: nums = [1, 2, 1, 1, 3, 2, 2]
     * 
     * Output: [1, 2]
     */

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 1, 3, 2, 2 };

        System.out.println(majorityElementTwo(nums));
    }

    public static List<Integer> majorityElementTwo(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != ele2) {
                cnt1++;
                ele1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != ele1) {
                cnt2++;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                cnt1++;
            } else if (ele2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Manual Check
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (ele1 == nums[i]) {
                cnt1++;
            } else if (ele2 == nums[i]) {
                cnt2++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (cnt1 > n / 3) {
            ans.add(ele1);
        }
        if (cnt2 > n / 3) {
            ans.add(ele2);
        }

        Collections.sort(ans);
        return ans;
    }
}
