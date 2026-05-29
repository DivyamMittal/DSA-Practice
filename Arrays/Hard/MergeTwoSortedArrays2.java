package Arrays.Hard;

import java.util.Arrays;

public class MergeTwoSortedArrays2 {
    /*
     * Given two integer arrays nums1 and nums2. Both arrays are sorted in
     * non-decreasing order.
     * Merge both the arrays into a single array sorted in non-decreasing order.
     * 
     * The final sorted array should be stored inside the array nums1 and it should
     * be done in-place.
     * 
     * nums1 has a length of m + n, where the first m elements denote the elements
     * of nums1 and rest are 0s.
     * 
     * nums2 has a length of n.
     * 
     * Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]
     * Output: nums1 = [-5, -3, -2, 1] nums2 = [4, 5, 8]
     */

    // In place, have to sart the arrays in given arrays only

    public static void main(String[] args) {
        int[] nums1 = { -5, -2, 4, 5 };
        int[] nums2 = { -3, 1, 8 };

        // merge1(nums1, nums1.length, nums2, nums2.length);
        merge2(nums1, nums1.length, nums2, nums2.length);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
    }

    // Optimal Solution 1.
    // TC -> O(min(N, M)) + O(NxlogN) + O(MxlogM), SC -> O(1)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;

        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                swap(nums1, nums2, left, right);
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    // Optimal Solution 2. Using Shell Sort
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len = (m + n);
        int gap = (len / 2) + (len % 2); // This way we will get the seil of a number -> 7/2 -> 3 + 7%2 -> 1 = 3+1 =4

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // 3 cases
                // 1. if left is on the left array and right is on right
                if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);

                }

                // 2. if left and right both on the right array
                else if (left >= m) {
                    swapIfGreater(nums2, nums2, left - m, right - m);

                }

                // 3. if left and right are both on left array
                else {
                    swapIfGreater(nums1, nums1, left, right);

                }
                left++;
                right++;
            }

            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);

        }
    }

    // ---------------------- HELPER FUNCTION ------------------------
    private static void swap(int[] nums1, int[] nums2, int i, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }

    private static void swapIfGreater(int[] nums1, int[] nums2, int i, int j) {
        if (nums1[i] > nums2[j]) {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }

    }
}
