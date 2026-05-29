package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumberAfterSelf {

    /*
     * (Extended version of Count Inversion)
     * Given an integer array nums, return an integer array counts where counts[i]
     * is the number of smaller elements to the right of nums[i].
     * Input: nums = [5,2,6,1]
     * Output: [2,1,1,0]
     *
     * Input: nums = [2,0,1]
     * Output: [2,0,0]
     * 
     * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
     */

    public static void main(String[] args) {
        int[] nums = { 5, 2, 6, 1 };
        System.out.println(countSmaller(nums));

    }

    public static List<Integer> countSmaller(int[] nums) {
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        int[] ans = new int[nums.length];

        mergeSort(arr, 0, nums.length - 1, ans);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            result.add(ans[i]);
        }
        return result;
    }

    private static void mergeSort(Pair[] arr, int low, int high, int[] ans) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid, ans);
        mergeSort(arr, mid + 1, high, ans);
        merge(arr, low, mid, high, ans);
    }

    private static void merge(Pair[] arr, int low, int mid, int high, int[] ans) {
        int left = low;
        int right = mid + 1;
        List<Pair> temp = new ArrayList<>();
        int rightCount = 0;

        while (left <= mid && right <= high) {

            if (arr[left].val <= arr[right].val) {
                ans[arr[left].idx] += rightCount;
                temp.add(arr[left]);
                left++;

            } else {
                temp.add(arr[right]);
                right++;
                rightCount++;
            }

        }

        while (left <= mid) {
            ans[arr[left].idx] += rightCount;
            temp.add(arr[left]);
            left++;

        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

}

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}