package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    /*
     * Given an integer array nums. Return the number of reverse pairs in the array.
     * An index pair (i, j) is called a reverse pair if:
     * 0 <= i < j < nums.length
     * nums[i] > 2 * nums[j]
     * Input: nums = [6, 4, 1, 2, 7]
     * Output: 3
     * Explanation:
     * The reverse pairs are:
     * (0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
     * (0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
     * (1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1
     * 
     * Input: [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
     * Output: 0
     */

    public static void main(String[] args) {
        int[] nums = { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647 };
        // int[] nums = { 6, 4, 1, 2, 7 };

        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // using mergeSort
    private static int mergeSort(int[] nums, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {

        int cnt = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > (2L * nums[right])) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;

        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}
