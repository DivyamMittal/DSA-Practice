package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {
    /*
     * Given an integer array nums. Return the number of inversions in the array.
     * Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     * It indicates how close an array is to being sorted.
     * A sorted array has an inversion count of 0.
     * An array sorted in descending order has maximum inversion.
     * 
     * Input: nums = [2, 3, 7, 1, 3, 5]
     * 
     * Output: 5
     */

    public static void main(String[] args) {
        int[] nums = { 2, 3, 7, 1, 3, 5 };
        System.out.println(numberOfInversions(nums));
        System.out.println(numberOfInversionsOptimal(nums));
    }

    /// Optimal Approach (Using Merge Sort)
    /// TC -> O(n log n), SC -> O(1)
    public static long numberOfInversionsOptimal(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static long mergeSort(int[] nums, int low, int high) {
        long cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += merge(nums, low, mid, high);
        return cnt;
    }

    private static long merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        long cnt = 0;
        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            }
            // right element is smaller
            else {
                cnt += (mid - left + 1);
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

        // assign temp array to original array
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

        return cnt;
    }

    /// Brute Force
    /// TC -> O(N^2), SC -> O(1)
    public static long numberOfInversions(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
